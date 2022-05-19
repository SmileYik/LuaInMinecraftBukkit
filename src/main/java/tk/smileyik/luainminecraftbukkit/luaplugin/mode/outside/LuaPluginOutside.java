package tk.smileyik.luainminecraftbukkit.luaplugin.mode.outside;

import tk.smileyik.luainminecraftbukkit.luaplugin.AbstractLuaPlugin;
import tk.smileyik.luainminecraftbukkit.luaplugin.mode.hybrid.RunType;

import java.io.File;
import java.util.List;

public class LuaPluginOutside extends AbstractLuaPlugin {

  public LuaPluginOutside(String id, String displayName, String author,
                          String version, List<String> softDependents,
                          List<String> dependents, File pluginPath,
                          File configPath, RunType runType) {
    super(id, displayName, author, version,
            softDependents, dependents, pluginPath, configPath, runType);
  }

  public LuaPluginOutside(AbstractLuaPlugin luaPlugin, RunType runType) {
    super(luaPlugin, runType);
  }

  @Override
  public String getRequirePath(String module) {
    return getPluginPath().getPath() + "/" + module;
  }
}
