package tk.smileyik.luainminecraftbukkit.plugin.inside;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.bridge.block.*;
import tk.smileyik.luainminecraftbukkit.bridge.block.container.*;
import tk.smileyik.luainminecraftbukkit.bridge.entity.*;
import tk.smileyik.luainminecraftbukkit.plugin.AbstractLuaPluginManager;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPlugin;
import tk.smileyik.luainminecraftbukkit.plugin.util.LuaPluginHelper;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LuaPluginManagerInside extends AbstractLuaPluginManager {

  private static final LuaValue LUA_BUKKIT;

  static {
    LUA_BUKKIT = LuaValueHelper.toTable(
            "pluginHelper", CoerceJavaToLua.coerce(new LuaPluginHelper()),
            "server", CoerceJavaToLua.coerce(LuaInMinecraftBukkit.getInstance().getServer()),
            "eventRegister", CoerceJavaToLua.coerce(EVENT_REGISTER),
            "commandRegister", CoerceJavaToLua.coerce(COMMAND_REGISTER),
            "entities", LuaValueHelper.toTable(
                    "entity", CoerceJavaToLua.coerce(new LuaEntity()),
                    "damageable", CoerceJavaToLua.coerce(new LuaEntityDamageable()),
                    "human", CoerceJavaToLua.coerce(new LuaEntityHumanEntity()),
                    "player", CoerceJavaToLua.coerce(new LuaEntityPlayer()),
                    "living", CoerceJavaToLua.coerce(new LuaEntityLiving())
            ),
            "blocks", LuaValueHelper.toTable(
                    "block", CoerceJavaToLua.coerce(new LuaBlock()),
                    "banner", CoerceJavaToLua.coerce(new LuaBlockBanner()),
                    "commandBlock", CoerceJavaToLua.coerce(new LuaBlockCommandBlock()),
                    "creatureSpawner", CoerceJavaToLua.coerce(new LuaBlockCreatureSpawner()),
                    "endGateway", CoerceJavaToLua.coerce(new LuaBlockEndGateway()),
                    "jukebox", CoerceJavaToLua.coerce(new LuaBlockJukebox()),
                    "sign", CoerceJavaToLua.coerce(new LuaBlockSign()),
                    "skull", CoerceJavaToLua.coerce(new LuaBlockSkull()),
                    "structure", CoerceJavaToLua.coerce(new LuaBlockStructure()),
                    "container", CoerceJavaToLua.coerce(new LuaBlockContainer()),
                    "beacon", CoerceJavaToLua.coerce(new LuaBlockBeacon()),
                    "brewingStand", CoerceJavaToLua.coerce(new LuaBlockBrewingStand()),
                    "chest", CoerceJavaToLua.coerce(new LuaBlockChest()),
                    "dispenser", CoerceJavaToLua.coerce(new LuaBlockDispenser()),
                    "dropper", CoerceJavaToLua.coerce(new LuaBlockDropper()),
                    "furnace", CoerceJavaToLua.coerce(new LuaBlockFurnace()),
                    "skulkerBox", CoerceJavaToLua.coerce(new LuaBlockSkull())
            )
    );
  }

  private final Globals globals = JsePlatform.standardGlobals();


  /**
   * 取消加载指定id脚本插件.
   * @param id 脚本插件的id.
   */
  @Override
  public void disablePlugin(String id) {
    LuaValue pluginFunc = globals.get(id);
    loadedPlugins.remove(id);

    if (!pluginFunc.isnil()) {
      LuaValue disableFunc = pluginFunc.get(DISABLE_FUNCTION);
      if (!disableFunc.isnil()) {
        try {
          disableFunc.call();
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          EVENT_REGISTER.unregisterAll(id);
        }
        // TODO task
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
    if (objs.length == 1) {
      c.call(LuaValueHelper.valueOf(objs[0]));
    } else {
      c.call(LuaValueHelper.asList(objs));
    }
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", Arrays.toString(vars), time);
  }
}
