package tk.smileyik.luainminecraftbukkit.plugin;

import org.bukkit.configuration.file.YamlConfiguration;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.bridge.block.*;
import tk.smileyik.luainminecraftbukkit.bridge.block.container.*;
import tk.smileyik.luainminecraftbukkit.bridge.entity.*;
import tk.smileyik.luainminecraftbukkit.util.EnumHelper;
import tk.smileyik.luainminecraftbukkit.util.JavaSEUtil;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class LuaPluginManager {
  private static final LuaValue LUA_BUKKIT;
  private static final String PLUGIN_MAIN = "main.lua";
  private static final String PLUGIN_META = "lua_plugin.yml";
  private static final String ENABLE_FUNCTION = "onEnable";
  private static final String DISABLE_FUNCTION = "onDisable";
  private static final String CONFIG_PATH = "config";
  private static final File PLUGIN_PATH;

  private static final EventRegister EVENT_REGISTER = new EventRegister();

  private static final CommandRegister COMMAND_REGISTER = new CommandRegister();

  static {
//    Bukkit bukkit = null;
//    try {
//      Constructor<Bukkit> declaredConstructor = Bukkit.class.getDeclaredConstructor();
//      declaredConstructor.setAccessible(true);
//      bukkit = declaredConstructor.newInstance();
//    } catch (NoSuchMethodException e) {
//      throw new RuntimeException(e);
//    } catch (InvocationTargetException e) {
//      throw new RuntimeException(e);
//    } catch (InstantiationException e) {
//      throw new RuntimeException(e);
//    } catch (IllegalAccessException e) {
//      throw new RuntimeException(e);
//    }

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
                    "noteBlock", CoerceJavaToLua.coerce(new LuaBlockNoteBlock()),
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
            ),
            "utils", LuaValueHelper.toTable(
                    "helper", CoerceJavaToLua.coerce(new LuaValueHelper()),
                    "jseUtil", CoerceJavaToLua.coerce(new JavaSEUtil()),
                    "enumHelper", CoerceJavaToLua.coerce(new EnumHelper())
            )
    );
    PLUGIN_PATH = new File(
            LuaInMinecraftBukkit.getInstance().getDataFolder(),
            "plugins"
    );
    if (!PLUGIN_PATH.exists()) {
      PLUGIN_PATH.mkdirs();
    }
  }

  private final Globals globals = JsePlatform.standardGlobals();
  private final HashMap<String, LuaPlugin> loadedPlugins = new HashMap<>();

  /**
   * 取消加载指定id脚本插件.
   * @param id 脚本插件的id.
   */
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
   * 取消加载所有脚本插件.
   */
  public void disableAllPlugins() {
    loadedPlugins.forEach((id, plug) -> {
      disablePlugin(id);
    });
    loadedPlugins.clear();
  }

  /**
   * 重载脚本插件.
   * @param id 插件id.
   * @return 如果重新加载成功则返回true, 反之则返回false.
   * @throws IOException 当加载时出错则抛出.
   */
  public boolean reloadPlugin(String id) throws IOException {
    if (isLoadPlugin(id)) {
      LuaPlugin plugin = loadedPlugins.get(id);
      disablePlugin(id);
      loadPlugin(plugin.getPluginPath().getName());
      return false;
    }
    return true;
  }

  /**
   * 加载plugins目录下的所有脚本插件.
   */
  public void loadPlugins() {
    LinkedList<File> queue = new LinkedList<>();
    PLUGIN_PATH.listFiles(it -> {
      if (it.isDirectory()) {
        queue.add(it);
        return true;
      }
      return false;
    });
    loadPlugins(queue);
  }

  /**
   * 加载批量脚本插件.
   * @param queue 要加载的脚本插件的目录路径链表.
   */
  public void loadPlugins(LinkedList<File> queue) {
    int lastWaitToLoad = queue.size();
    int waitToLoad = queue.size();
    boolean loadFailed = false;
    while (!queue.isEmpty()) {
      File file = queue.removeFirst();
      LuaPlugin plugin;
      try {
        plugin = checkPlugin(file);
      } catch (RuntimeException e) {
        e.printStackTrace();
        continue;
      }
      if (loadFailed) {
        LuaInMinecraftBukkit.debug(plugin.getId() + ": 没有找到插件的必要依赖.");
        return;
      } else if (!loadPlugin(plugin)) {
        queue.add(file);
      } else {
        loadedPlugins.put(plugin.getId(), plugin);
      }

      if (--waitToLoad == 0) {
        if (queue.size() == lastWaitToLoad) {
          loadFailed = true;
        }
        waitToLoad = queue.size();
        lastWaitToLoad = queue.size();
      }
    }
  }

  /**
   * 通过一个文件夹名称去加载一个脚本插件.
   * @param pluginDir 一个在plugins下存在的文件夹名称.
   */
  public void loadPlugin(String pluginDir) {
    LinkedList<File> queue = new LinkedList<>();
    queue.add(new File(PLUGIN_PATH, pluginDir));
    loadPlugins(queue);
  }

  /**
   * 加载一个脚本插件.
   * @param plugin 脚本插件.
   * @return 如果加载成功或者插件已经被加载则返回true.加载失败返回false.
   */
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
   * 检查脚本插件的依赖是否启用.
   * @param plugin 脚本插件
   * @return 如果所有依赖都存在则返回true, 反之则返回false.
   */
  private boolean checkDependents(LuaPlugin plugin) {
    for (String dependent : plugin.getDependents()) {
      if (!loadedPlugins.containsKey(dependent)) {
        return false;
      }
    }
    return true;
  }

  /**
   * 检查一个文件夹是否是一个正常的脚本插件.
   * @param file 文件夹文件
   * @return  如果文件夹是一个正常的脚本插件则返回具体实例, 反之则返回false.
   * @throws RuntimeException 如果指定路径是一个不合法的脚本插件路径则抛出.
   */
  private LuaPlugin checkPlugin(File file) throws RuntimeException {
    File configFile = new File(file, PLUGIN_META);
    if (!configFile.exists()) {
      throw new RuntimeException("不是一个正常插件! 加载路径: " + file);
    }
    YamlConfiguration config = YamlConfiguration.loadConfiguration(
            configFile
    );
    String id = config.getString("id");
    String displayName = config.getString("displayName", id);
    String author = config.getString("author");
    String version = config.getString("version");
    List<String> softDependents = config.getStringList("softDependents");
    List<String> dependents = config.getStringList("dependents");

    if (id == null) {
      throw new RuntimeException("在plugin.yml配置文件中 id 不能为空! 加载路径: " + file);
    } else if (author == null) {
      throw new RuntimeException("在plugin.yml配置文件中 author 不能为空! 加载路径: " + file);
    } else if (version == null) {
      throw new RuntimeException("在plugin.yml配置文件中 version 不能为空! 加载路径: " + file);
    }

    return new LuaPlugin(
            id,
            displayName,
            author,
            version,
            softDependents,
            dependents,
            file,
            new File(file, CONFIG_PATH)
    );
  }

  /**
   * 获取脚本闭包.
   * @param vars 闭包路径(本来是以点分隔)
   * @return 返回对应的闭包, 如果指定路径闭包不存在则为NIL.
   */
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
   * @param obj 要传入的参数.
   */
  public void callClosure(String[] vars, LuaValue obj) {
    LuaValue c = getClosure(vars);
    assert c != LuaValue.NIL;
    long time = System.currentTimeMillis();
    c.call(obj);
    time = System.currentTimeMillis() - time;
    LuaInMinecraftBukkit.debug("called closure %s: %dms", Arrays.toString(vars), time);
  }

  /**
   * 判断某个脚本插件是否启用.
   * @param id 脚本插件id.
   * @return 如果脚本插件已经启用则返回true.
   */
  public boolean isLoadPlugin(String id) {
    return loadedPlugins.containsKey(id);
  }

  /**
   * 获取插件信息.
   * @param id 插件id
   * @return 插件信息.
   */
  public String getPluginInfo(String id) {
    if (isLoadPlugin(id)) {
      LuaPlugin plugin = loadedPlugins.get(id);
      return String.format(
              "正在启用插件: %s(%s), 作者: %s, 版本: %s",
              plugin.getDisplayName(),
              plugin.getId(),
              plugin.getAuthor(),
              plugin.getVersion()
      );
    }
    return "插件未加载.";
  }

  public static CommandRegister getCommandRegister() {
    return COMMAND_REGISTER;
  }

  public static EventRegister getEventRegister() {
    return EVENT_REGISTER;
  }
}
