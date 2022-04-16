package tk.smileyik.luainminecraftbukkit.plugin;

import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

public class LuaPluginHelper {
  /**
   * 指定脚本插件是否加载.
   * @param id 脚本插件id
   * @return 如果已经加载则返回true.
   */
  public boolean isLoadPlugin(String id) {
    return LuaInMinecraftBukkit.getPluginManager().isLoadPlugin(id);
  }
}
