package tk.smileyik.luainminecraftbukkit.plugin.inside;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class LuaPluginInside implements tk.smileyik.luainminecraftbukkit.plugin.LuaPlugin {
  private final String id;
  private final String displayName;
  private final String author;
  private final String version;
  private final List<String> softDependents;
  private final List<String> dependents;
  private final File pluginPath;
  private final File configPath;
  private final Logger logger;

  public LuaPluginInside(String id, String displayName, String author,
                         String version, List<String> softDependents,
                         List<String> dependents, File pluginPath, File configPath) {
    this.id = id;
    this.displayName = displayName;
    this.author = author;
    this.version = version;
    this.softDependents = softDependents;
    this.dependents = dependents;
    this.pluginPath = pluginPath;
    this.configPath = configPath;
    this.logger = Logger.getLogger(id);
  }

  /**
   * 获取脚本插件id.
   * @return 脚本插件的id.
   */
  @Override
  public String getId() {
    return id;
  }

  /**
   * 获取脚本文件的显示名称.
   * @return 显示名称.
   */
  @Override
  public String getDisplayName() {
    return displayName;
  }

  /**
   * 获取脚本插件的作者.
   * @return 脚本插件的作者.
   */
  @Override
  public String getAuthor() {
    return author;
  }

  /**
   * 获取脚本插件的版本.
   * @return 脚本插件的版本.
   */
  @Override
  public String getVersion() {
    return version;
  }

  /**
   * 获取脚本插件的非强制性依赖.
   * @return 非强制性依赖脚本插件id列表
   */
  @Override
  public List<String> getSoftDependents() {
    return softDependents;
  }

  /**
   * 获取脚本插件的强制性依赖.
   * @return 强制性依赖脚本插件id列表
   */
  @Override
  public List<String> getDependents() {
    return dependents;
  }

  /**
   * 获取配置文件夹路径.
   * @return 配置文件夹路径.
   */
  @Override
  public File getConfigPath() {
    return configPath;
  }

  /**
   * 脚本插件文件夹路径.
   * @return 脚本插件文件夹路径.
   */
  @Override
  public File getPluginPath() {
    return pluginPath;
  }

  /**
   * 获取模块的绝对路径.
   * @param module 模块名(后缀名为lua的文件但是不带后缀名)
   * @return 模块的完整路径
   * @throws IOException 如果获取失败则抛出
   */
  @Override
  public String getRequirePath(String module) throws IOException {
    return getPluginPath().getCanonicalPath() + "/" + module;
  }

  /**
   * 日志.
   * @return 日志
   */
  @Override
  public Logger getLogger() {
    return logger;
  }
}
