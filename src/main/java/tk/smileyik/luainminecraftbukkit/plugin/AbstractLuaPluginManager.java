package tk.smileyik.luainminecraftbukkit.plugin;

import org.bukkit.configuration.file.YamlConfiguration;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.mode.hybrid.RunType;
import tk.smileyik.luainminecraftbukkit.plugin.mode.inside.LuaPluginInside;
import tk.smileyik.luainminecraftbukkit.plugin.mode.outside.LuaPluginManagerOutside;
import tk.smileyik.luainminecraftbukkit.plugin.mode.outside.LuaPluginOutside;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractLuaPluginManager implements LuaPluginManager {
  protected static final File PLUGIN_PATH;

  static {
    PLUGIN_PATH = new File(
            LuaInMinecraftBukkit.getInstance().getDataFolder(),
            "plugins"
    );
    if (!PLUGIN_PATH.exists()) {
      PLUGIN_PATH.mkdirs();
    }
  }

  protected final HashMap<String, LuaPlugin> loadedPlugins = new HashMap<>();

  /**
   * 重载脚本插件.
   * @param id 插件id.
   * @return 如果重新加载成功则返回true, 反之则返回false.
   * @throws IOException 当加载时出错则抛出.
   */
  @Override
  public boolean reloadPlugin(String id) throws IOException {
    if (isLoadPlugin(id)) {
      LuaPlugin plugin = loadedPlugins.get(id);
      disablePlugin(id);
      loadPlugin(plugin.getPluginPath().getName());
      return true;
    }
    return false;
  }

  /**
   * 取消加载所有脚本插件.
   */
  @Override
  public void disableAllPlugins() {
    new HashMap<>(loadedPlugins).forEach((id, plug) -> {
      disablePlugin(id);
    });
    loadedPlugins.clear();
  }

  /**
   * 加载plugins目录下的所有脚本插件.
   */
  @Override
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
   * 通过一个文件夹名称去加载一个脚本插件.
   * @param pluginDir 一个在plugins下存在的文件夹名称.
   */
  @Override
  public void loadPlugin(String pluginDir) {
    LinkedList<File> queue = new LinkedList<>();
    queue.add(new File(PLUGIN_PATH, pluginDir));
    loadPlugins(queue);
  }

  /**
   * 加载批量脚本插件.
   * @param queue 要加载的脚本插件的目录路径链表.
   */
  @Override
  public void loadPlugins(LinkedList<File> queue) {
    int lastWaitToLoad = queue.size();
    int waitToLoad = queue.size();
    boolean loadFailed = false;
    while (!queue.isEmpty()) {
      File file = queue.removeFirst();
      LuaPlugin plugin;
      // 检查lua_plugin, 并返回相应实例.
      try {
        plugin = checkPlugin(file);
      } catch (RuntimeException e) {
        e.printStackTrace();
        continue;
      }
      if (loadFailed) {
        LuaInMinecraftBukkit.debug(
                plugin.getId() + ": 没有找到插件的必要依赖或插件加载时出错.");
        return;
      } else if (!checkDependents(plugin)) {
        // 不存在依赖. 加入队尾等待重新加载.
        queue.add(file);
      } else if (!loadPlugin(plugin)) {
        // 加载失败
        LuaInMinecraftBukkit.getInstance().getLogger().warning(String.format(
                "插件%s加载失败!", plugin.getId()));
      } else {
        loadedPlugins.put(plugin.getId(), plugin);
      }

      if (--waitToLoad == 0) {
        // 如果当前加载轮次与上一次加载轮次待加载的插件数量一样
        // 则判断剩下的为依赖不足无法继续加载.
        if (queue.size() == lastWaitToLoad) {
          loadFailed = true;
        }
        waitToLoad = queue.size();
        lastWaitToLoad = queue.size();
      }
    }
  }

  /**
   * 检查脚本插件的依赖是否启用.
   * @param plugin 脚本插件
   * @return 如果所有依赖都存在则返回true, 反之则返回false.
   */
  protected boolean checkDependents(LuaPlugin plugin) {
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
    RunType type = RunType.valueOf(config.getString("mode", "Inside"));

    if (id == null) {
      throw new RuntimeException(
              "在plugin.yml配置文件中 id 不能为空! 加载路径: " + file);
    } else if (author == null) {
      throw new RuntimeException(
              "在plugin.yml配置文件中 author 不能为空! 加载路径: " + file);
    } else if (version == null) {
      throw new RuntimeException(
              "在plugin.yml配置文件中 version 不能为空! 加载路径: " + file);
    }

    if (this instanceof LuaPluginManagerOutside) {
      return new LuaPluginOutside(
              id,
              displayName,
              author,
              version,
              softDependents,
              dependents,
              file,
              new File(file, CONFIG_PATH),
              type
      );
    } else {
      return new LuaPluginInside(
              id,
              displayName,
              author,
              version,
              softDependents,
              dependents,
              file,
              new File(file, CONFIG_PATH),
              type
      );
    }
  }

  /**
   * 判断某个脚本插件是否启用.
   * @param id 脚本插件id.
   * @return 如果脚本插件已经启用则返回true.
   */
  @Override
  public boolean isLoadPlugin(String id) {
    return loadedPlugins.containsKey(id);
  }

  /**
   * 获取插件信息.
   * @param id 插件id
   * @return 插件信息.
   */
  @Override
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
}
