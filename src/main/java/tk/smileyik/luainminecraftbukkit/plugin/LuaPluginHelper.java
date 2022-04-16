package tk.smileyik.luainminecraftbukkit.plugin;

import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

public class LuaPluginHelper {
  public boolean isLoadPlugin(String id) {
    return LuaInMinecraftBukkit.getPluginManager().isLoadPlugin(id);
  }
}
