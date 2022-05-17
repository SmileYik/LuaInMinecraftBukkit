package tk.smileyik.luainminecraftbukkit.plugin;

import tk.smileyik.luainminecraftbukkit.plugin.LuaPlugin;
import tk.smileyik.luainminecraftbukkit.plugin.mode.hybrid.RunType;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractLuaPlugin implements LuaPlugin {
  private final String id;
  private final String displayName;
  private final String author;
  private final String version;
  private final List<String> softDependents;
  private final List<String> dependents;
  private final File pluginPath;
  private final File configPath;
  private final Logger logger;
  private final RunType runType;

  public AbstractLuaPlugin(String id, String displayName, String author,
                         String version, List<String> softDependents,
                         List<String> dependents, File pluginPath,
                         File configPath, RunType runType) {
    this.id = id;
    this.displayName = displayName;
    this.author = author;
    this.version = version;
    this.softDependents = softDependents;
    this.dependents = dependents;
    this.pluginPath = pluginPath;
    this.configPath = configPath;
    this.logger = Logger.getLogger(id);
    this.runType = runType;
  }

  protected AbstractLuaPlugin(AbstractLuaPlugin luaPlugin, RunType runType) {
    this.id = luaPlugin.id;
    this.displayName = luaPlugin.displayName;
    this.author = luaPlugin.author;
    this.version = luaPlugin.version;
    this.softDependents = luaPlugin.softDependents;
    this.dependents = luaPlugin.dependents;
    this.pluginPath = luaPlugin.pluginPath;
    this.configPath = luaPlugin.configPath;
    this.runType = runType;
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
   * 日志.
   * @return 日志
   */
  @Override
  public Logger getLogger() {
    return logger;
  }

  @Override
  public RunType getRunType() {
    return runType;
  }

  @Override
  public String toString() {
    return "AbstractLuaPlugin{" +
            "id='" + id + '\'' +
            ", displayName='" + displayName + '\'' +
            ", author='" + author + '\'' +
            ", version='" + version + '\'' +
            ", softDependents=" + softDependents +
            ", dependents=" + dependents +
            ", pluginPath=" + pluginPath +
            ", configPath=" + configPath +
            ", runType=" + runType +
            '}';
  }
}
