package tk.smileyik.luainminecraftbukkit.plugin.inside;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.AbstractLuaPluginManager;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPlugin;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaFunctionIllegalException;
import tk.smileyik.luainminecraftbukkit.plugin.util.LuaPluginHelper;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LuaPluginManagerInside extends AbstractLuaPluginManager {

  private static final LuaValue LUA_BUKKIT;

  static {
    LUA_BUKKIT = LuaValueHelper.toTable(
            "pluginHelper", CoerceJavaToLua.coerce(LuaPluginHelper.class), //弃用, 被helper替代
            "helper", CoerceJavaToLua.coerce(LuaPluginHelper.class),
            "server", CoerceJavaToLua.coerce(LuaInMinecraftBukkit.getInstance().getServer()),
            "eventRegister", CoerceJavaToLua.coerce(EVENT_REGISTER),      // 弃用, 被event替代
            "event", CoerceJavaToLua.coerce(EVENT_REGISTER),
            "commandRegister", CoerceJavaToLua.coerce(COMMAND_REGISTER),  // 弃用, 被command替代
            "command", CoerceJavaToLua.coerce(COMMAND_REGISTER),
            "task", CoerceJavaToLua.coerce(TASK_REGISTER)
    );
  }

  private final Globals globals = JsePlatform.standardGlobals();


  /**
   * 取消加载指定id脚本插件.
   * @param id 脚本插件的id.
   */
  @Override
  public void disablePlugin(String id) {
    EVENT_REGISTER.unregisterAll(id);
    TASK_REGISTER.cancelAll(id);

    LuaValue pluginFunc = globals.get(id);
    loadedPlugins.remove(id);
    if (!pluginFunc.isnil()) {
      LuaValue disableFunc = pluginFunc.get(DISABLE_FUNCTION);
      if (!disableFunc.isnil()) {
        try {
          disableFunc.call();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      globals.set(id, LuaValue.NIL);
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
      // 生成环境
      Globals pluginGlobals =
              LuaInMinecraftBukkit.isDebug() ? JsePlatform.debugGlobals() : JsePlatform.standardGlobals();
      pluginGlobals.set("luaBukkit", LUA_BUKKIT);
      for (String dependent : plugin.getDependents()) {
        pluginGlobals.set(dependent, globals.get(dependent));
      }
      for (String softDependent : plugin.getSoftDependents()) {
        pluginGlobals.set(softDependent, globals.get(softDependent));
      }
      pluginGlobals.set("self", LuaValueHelper.valueOf(plugin));
      // 环境生成完毕
      LuaValue func = null;
      try {
        func = pluginGlobals.loadfile(
                new File(plugin.getPluginPath(), PLUGIN_MAIN).getCanonicalPath()
        );
      } catch (IOException e) {
        e.printStackTrace();
        return false;
      }
      globals.set(plugin.getId(), pluginGlobals);
      func.call();
      LuaInMinecraftBukkit.log(
              "正在启用插件: %s(%s), 作者: %s, 版本: %s",
              plugin.getDisplayName(),
              plugin.getId(),
              plugin.getAuthor(),
              plugin.getVersion()
      );
      LuaValue enableFunction = pluginGlobals.get(ENABLE_FUNCTION);
      if (!enableFunction.isnil()) {
        enableFunction.call();
      }
    } catch (Exception e) {
      disablePlugin(plugin.getId());
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * 获取脚本闭包.
   * @param vars 闭包路径(本来是以点分隔)
   * @return 返回对应的闭包, 如果指定路径闭包不存在则为NIL.
   */
  @Override
  public LuaValue getClosure(String[] vars) {
    LuaValue g = globals;
    for (String s : vars) {
      g = g.get(s);
    }
    return g;
  }

  /**
   * 执行一个闭包.
   * @param vars 闭包路径(本来是以点分隔)
   */
  @Override
  public void callClosure(String[] vars) {
    LuaValue c = getClosure(vars);
    assert c != LuaValue.NIL;
    long time = System.currentTimeMillis();
    c.call();
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
    LuaValue c = getClosure(vars);
    assert c != LuaValue.NIL;
    long time = System.currentTimeMillis();
    call(c, objs);
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", Arrays.toString(vars), time);
  }

  private void call(LuaValue c, Object[] objs) {
    if (objs.length == 0) {
      c.call();
    } else if (objs.length == 1) {
      c.call(LuaValueHelper.valueOf(objs[0]));
    } else if (objs.length == 2) {
      c.call(
              LuaValueHelper.valueOf(objs[0]),
              LuaValueHelper.valueOf(objs[1])
      );
    } else if (objs.length == 3) {
      c.call(
              LuaValueHelper.valueOf(objs[0]),
              LuaValueHelper.valueOf(objs[1]),
              LuaValueHelper.valueOf(objs[2])
      );
    } else {
      c.call(LuaValueHelper.asList(objs));
    }
  }

  @Override
  public void callClosure(String id, Object closure) {
    long time = System.currentTimeMillis();
    if (closure instanceof LuaValue) {
      LuaValue value = ((LuaValue) closure);
      if (value.isfunction()) {
        value.call();
      } else {
        throw new LuaFunctionIllegalException(id, id);
      }
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", id, time);
  }

  @Override
  public void callClosure(String id, Object closure, Object... objs) {
    if (closure instanceof LuaValue) {
      LuaValue value = ((LuaValue) closure);
      if (value.isfunction()) {
        long time = System.currentTimeMillis();
        call(value, objs);
        time = System.currentTimeMillis() - time;
        LuaInMinecraftBukkit.debug("called closure %s: %dms", id, time);
      } else {
        throw new LuaFunctionIllegalException(id, id);
      }
    }
  }
}
