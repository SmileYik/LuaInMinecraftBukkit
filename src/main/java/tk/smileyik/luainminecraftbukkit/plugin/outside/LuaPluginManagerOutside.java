package tk.smileyik.luainminecraftbukkit.plugin.outside;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.*;
import tk.smileyik.luainminecraftbukkit.plugin.util.LuaPluginHelper;
import tk.smileyik.luainminecraftbukkit.util.LuaTableBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class LuaPluginManagerOutside extends AbstractLuaPluginManager {
  private final Map<String, LuaState> globals = new HashMap<>();

  public LuaPluginManagerOutside() {
    try {
      NativeLuaLoader.initNativeLua(LuaInMinecraftBukkit.getInstance().getDataFolder());
    } catch (IOException e) {
      throw new RuntimeException("无法使用Native模式, 切换至原生模式.", e);
    }
  }

  /**
   * 取消加载指定id脚本插件.
   * @param id 脚本插件的id.
   */
  @Override
  public void disablePlugin(String id) {
    EVENT_REGISTER.unregisterAll(id);
    try {
      callClosure(new String[]{
              id, DISABLE_FUNCTION
      });
    } catch (Exception e) {
      if (!loadedPlugins.containsKey(id)) {
        throw new RuntimeException(e);
      }
    } finally {
      LuaState luaState = globals.remove(id);
      if (luaState != null) {
        luaState.close();
      }
      loadedPlugins.remove(id);
    }
  }

  /**
   * 加载一个脚本插件.
   * @param plugin 脚本插件.
   * @return 如果加载成功或者插件已经被加载则返回true.加载失败返回false.
   */
  @Override
  public boolean loadPlugin(LuaPlugin plugin) {
    if (!checkDependents(plugin)) {
      return false;
    } else if (isLoadPlugin(plugin.getId())) {
      return true;
    }
    LuaInMinecraftBukkit.log(
            "正在加载插件: %s(%s), 作者: %s, 版本: %s",
            plugin.getDisplayName(),
            plugin.getId(),
            plugin.getAuthor(),
            plugin.getVersion()
    );

    try {
      LuaState pluginGlobals = LuaStateFactory.newLuaState();
      pluginGlobals.openLibs();

      setLuaBukkit(pluginGlobals);
      // 生成环境
      for (String dependent : plugin.getDependents()) {
        pluginGlobals.pushObjectValue(globals.get(dependent));
        pluginGlobals.setGlobal(dependent);
      }
      for (String softDependent : plugin.getSoftDependents()) {
        pluginGlobals.pushObjectValue(globals.get(softDependent));
        pluginGlobals.setGlobal(softDependent);
      }
      pluginGlobals.pushObjectValue(plugin);
      pluginGlobals.setGlobal("self");

      // 环境生成完毕
      try {
        pluginGlobals.LloadString(new String(
                Files.readAllBytes(new File(plugin.getPluginPath(), PLUGIN_MAIN).toPath())
        ));
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }

      int ret = pluginGlobals.pcall(0, 0, 0);
      if (ret != 0) {
        throw new LuaException("Error on load! " + plugin.getPluginPath() + ": " + pluginGlobals.toString(-1));
      }
      globals.put(plugin.getId(), pluginGlobals);
      LuaInMinecraftBukkit.log(
              "正在启用插件: %s(%s), 作者: %s, 版本: %s",
              plugin.getDisplayName(),
              plugin.getId(),
              plugin.getAuthor(),
              plugin.getVersion()
      );
      callClosure(new String[]{
              plugin.getId(), ENABLE_FUNCTION
      });
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public void setLuaBukkit(LuaState luaState) {
    new LuaTableBuilder(luaState).put("pluginHelper", new LuaPluginHelper())
            .put("server", LuaInMinecraftBukkit.getInstance().getServer())
            .put("eventRegister", EVENT_REGISTER)
            .put("commandRegister", COMMAND_REGISTER)
            .buildGlobal("luaBukkit");
  }

  /**
   * 获取脚本闭包.
   * @param vars 闭包路径(本来是以点分隔)
   * @return 返回对应的闭包, 如果指定路径闭包不存在则为NIL.
   */
  @Override
  public LuaObject getClosure(String[] vars) {
    LuaState g = globals.get(vars[0]);
    if (g == null) {
      throw new RuntimeException("id 不存在");
    }
    LuaObject obj = g.getLuaObject(vars[1]);
    for (int i = 2; i < vars.length; ++i) {
      try {
        obj = obj.getField(vars[i]);
      } catch (LuaException e) {
        throw new RuntimeException(e + ": " + g.toString(-1));
      }
    }
    return obj;
  }

  /**
   * 执行一个闭包.
   * @param vars 闭包路径(本来是以点分隔)
   */
  @Override
  public void callClosure(String[] vars) {
    LuaObject c = getClosure(vars);
    assert !c.isFunction();
    long time = System.currentTimeMillis();
    try {
      c.call(new Object[]{});
    } catch (LuaException e) {
      throw new RuntimeException(e.getMessage() + ": " + Arrays.toString(vars) + ": " + c.getLuaState().toString(-1) + "; " + c.getString());
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", Arrays.toString(vars), time);
  }

  /**
   * 执行一个闭包.
   * @param vars 闭包路径(本来是以点分隔)
   * @param objs 要传入的参数.
   */
  @Override
  public void callClosure(String[] vars, Object ... objs) {
    LuaObject c = getClosure(vars);
    assert !c.isFunction();
    long time = System.currentTimeMillis();
    try {
      c.call(objs);
    } catch (LuaException e) {
      throw new RuntimeException(e.getMessage() + ": " + Arrays.toString(vars) + "; params: " + Arrays.toString(objs) + ": " + c.getLuaState().toString(-1));
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", Arrays.toString(vars), time);
  }
}
