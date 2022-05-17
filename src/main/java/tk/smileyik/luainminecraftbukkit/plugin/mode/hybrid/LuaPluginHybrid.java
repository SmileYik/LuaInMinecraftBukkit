package tk.smileyik.luainminecraftbukkit.plugin.mode.hybrid;

import tk.smileyik.luainminecraftbukkit.plugin.AbstractLuaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class LuaPluginHybrid extends AbstractLuaPlugin {

  public LuaPluginHybrid(String id, String displayName, String author,
                         String version, List<String> softDependents,
                         List<String> dependents, File pluginPath,
                         File configPath, RunType runType) {
    super(id, displayName, author, version,
            softDependents, dependents, pluginPath, configPath, runType);
  }

  protected LuaPluginHybrid(AbstractLuaPlugin luaPlugin, RunType runType) {
    super(luaPlugin, runType);
  }

  /**
   * 方便require方法获取脚本插件的模块路径.
   *
   * @param module 模块名称
   * @return 返回脚本插件require所认可的模块路径.
   */
  @Override
  public String getRequirePath(String module) throws IOException {
    switch (getRunType()) {
      case Inside:
        return getPluginPath().getCanonicalPath() + "/" + module;
      case Outside:
        return getPluginPath().getPath() + "/" + module;
    }
    return null;
  }
}
