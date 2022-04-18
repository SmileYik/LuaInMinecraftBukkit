package tk.smileyik.luainminecraftbukkit.plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public interface LuaPlugin {
  String getId();

  String getDisplayName();

  String getAuthor();

  String getVersion();

  List<String> getSoftDependents();

  List<String> getDependents();

  File getConfigPath();

  File getPluginPath();

  String getRequirePath(String module) throws IOException;

  Logger getLogger();
}
