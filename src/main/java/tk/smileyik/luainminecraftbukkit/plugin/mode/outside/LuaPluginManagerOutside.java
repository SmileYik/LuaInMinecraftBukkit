package tk.smileyik.luainminecraftbukkit.plugin.mode.outside;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.*;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaFunctionIllegalException;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaFunctionNotFountException;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaFunctionRuntimeException;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaPluginNotFountException;
import tk.smileyik.luainminecraftbukkit.plugin.util.LuaPluginHelper;
import tk.smileyik.luainminecraftbukkit.util.LuaTableBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class LuaPluginManagerOutside extends AbstractLuaPluginManager {
  private final Map<String, LuaState> globals = new HashMap<>();

  public LuaPluginManagerOutside() {
    if (NativeLuaLoader.isLoaded()) {
      return;
    }
    try {
      NativeLuaLoader.initNativeLua(
              LuaInMinecraftBukkit.getInstance().getDataFolder());
    } catch (UnsatisfiedLinkError e) {
      // 已经加载时会产生此错误, 忽略.
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
    TASK_REGISTER.cancelAll(id);
    try {
      callClosure(new String[]{
              id, DISABLE_FUNCTION
      });
    } catch (LuaFunctionNotFountException |
             LuaPluginNotFountException |
             LuaFunctionIllegalException e) {
      // 如果onDisable方法未找到或此插件未被加载, 则忽略
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
    if (isLoadPlugin(plugin.getId())) {
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
                Files.readAllBytes(
                        new File(plugin.getPluginPath(), PLUGIN_MAIN).toPath())
        ));
      } catch (IOException e) {
        e.printStackTrace();
        // 加载主要的脚本失败则, 直接加载失败.
        return false;
      }

      int ret = pluginGlobals.pcall(0, 0, 0);
      if (ret != 0) {
        // 脚本加载出错 取消加载插件并且抛出出错信息
        disablePlugin(plugin.getId());
        throw new LuaException(String.format(
                "加载脚本%s时出错: %s",
                plugin.getPluginPath(),
                pluginGlobals.toString(-1)
        ));
      }
      globals.put(plugin.getId(), pluginGlobals);
      LuaInMinecraftBukkit.log(
              "正在以Native模式启用插件: %s(%s), 作者: %s, 版本: %s",
              plugin.getDisplayName(),
              plugin.getId(),
              plugin.getAuthor(),
              plugin.getVersion()
      );
      try {
        callClosure(new String[]{
                plugin.getId(), ENABLE_FUNCTION
        });
      } catch (LuaFunctionNotFountException | LuaFunctionIllegalException e) {
        // 当方法不存在时则不做任何事情.
      }
    } catch (Exception e) {
      // 捕捉所有报错(包括内部抛出)
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public void setLuaBukkit(LuaState luaState) {
    new LuaTableBuilder(luaState)
            .put("pluginHelper", LuaPluginHelper.class) // 将被删除, 被helper替代
            .put("helper", LuaPluginHelper.class)
            .put("server", LuaInMinecraftBukkit.getInstance().getServer())
            .put("eventRegister", EVENT_REGISTER)       // 将被删除, 被event替代
            .put("event", EVENT_REGISTER)
            .put("commandRegister", COMMAND_REGISTER)   // 将被删除, 被command替代
            .put("command", COMMAND_REGISTER)
            .put("task", TASK_REGISTER)
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
      throw new LuaPluginNotFountException(vars[0]);
    }
    LuaObject obj;
    try {
      obj = g.getLuaObject(vars[1]);
      for (int i = 2; i < vars.length; ++i) {
        obj = obj.getField(vars[i]);
      }
      return obj;
    } catch (Exception e) {
      throw new LuaFunctionNotFountException(vars[0], Arrays.toString(vars));
    }
  }

  /**
   * 执行一个闭包.
   * @param vars 闭包路径(本来是以点分隔)
   */
  @Override
  public void callClosure(String[] vars) {
    LuaObject c = getClosure(vars);
    if (!c.isFunction()) {
      throw new LuaFunctionIllegalException(vars[0], Arrays.toString(vars));
    }
    long time = System.currentTimeMillis();
    try {
      c.call(new Object[]{});
    } catch (LuaException e) {
      throw new LuaFunctionRuntimeException(
              vars[0], Arrays.toString(vars),
              c.getLuaState().toString(-1)
      );
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug(
            "called closure %s: %dms", Arrays.toString(vars), time);
  }

  /**
   * 执行一个闭包.
   * @param vars 闭包路径(本来是以点分隔)
   * @param objs 要传入的参数.
   */
  @Override
  public void callClosure(String[] vars, Object ... objs) {
    LuaObject c = getClosure(vars);
    if (!c.isFunction()) {
      throw new LuaFunctionIllegalException(vars[0], Arrays.toString(vars));
    }
    long time = System.currentTimeMillis();
    try {
      c.call(objs);
    } catch (LuaException e) {
      throw new LuaFunctionRuntimeException(
              vars[0], Arrays.toString(vars),
              c.getLuaState().toString(-1)
      );
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug(
            "called closure %s: %dms", Arrays.toString(vars), time);
  }

  @Override
  public void callClosure(String id, Object closure) {
    LuaObject luaObject = (LuaObject) closure;
    long time = System.currentTimeMillis();
    try {
      luaObject.call(new Object[0]);
    } catch (LuaException e) {
      throw new LuaFunctionRuntimeException(
              id, id,
              luaObject.getLuaState().toString(-1)
      );
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", id, time);
  }

  @Override
  public void callClosure(String id, Object closure, Object... objs) {
    LuaObject luaObject = (LuaObject) closure;
    long time = System.currentTimeMillis();
    try {
      luaObject.call(objs);
    } catch (LuaException e) {
      throw new LuaFunctionRuntimeException(
              id, id,
              luaObject.getLuaState().toString(-1)
      );
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", id, time);
  }
}
