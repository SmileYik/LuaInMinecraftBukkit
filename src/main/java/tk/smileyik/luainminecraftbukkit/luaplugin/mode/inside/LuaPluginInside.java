package tk.smileyik.luainminecraftbukkit.luaplugin.mode.inside;

import tk.smileyik.luainminecraftbukkit.luaplugin.AbstractLuaPlugin;
import tk.smileyik.luainminecraftbukkit.luaplugin.mode.hybrid.RunType;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LuaPluginInside extends AbstractLuaPlugin {
  public LuaPluginInside(String id, String displayName, String author,
                         String version, List<String> softDependents,
                         List<String> dependents, File pluginPath,
                         File configPath, RunType runType) {
    super(id, displayName, author, version,
            softDependents, dependents, pluginPath, configPath, runType);
  }

  public LuaPluginInside(AbstractLuaPlugin luaPlugin, RunType runType) {
    super(luaPlugin, runType);
  }

  @Override
  public String getRequirePath(String module) throws IOException {
    return getPluginPath().getCanonicalPath() + "/" + module;
  }
}
