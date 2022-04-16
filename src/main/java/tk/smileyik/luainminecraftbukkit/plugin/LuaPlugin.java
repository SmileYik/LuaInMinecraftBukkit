package tk.smileyik.luainminecraftbukkit.plugin;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

public class LuaPlugin {
  private final String id;
  private final String displayName;
  private final String author;
  private final String version;
  private final List<String> softDependents;
  private final List<String> dependents;
  private final File pluginPath;
  private final File configPath;
  private final Logger logger;

  public LuaPlugin(String id, String displayName, String author, String version, List<String> softDependents, List<String> dependents, File pluginPath, File configPath) {
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

  public String getId() {
    return id;
  }

  public String getDisplayName() {
    return displayName;
  }

  public String getAuthor() {
    return author;
  }

  public String getVersion() {
    return version;
  }

  public List<String> getSoftDependents() {
    return softDependents;
  }

  public List<String> getDependents() {
    return dependents;
  }

  public File getConfigPath() {
    return configPath;
  }

  public File getPluginPath() {
    return pluginPath;
  }

  public Logger getLogger() {
    return logger;
  }
}
