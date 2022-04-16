package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.Material;
import org.bukkit.block.Jukebox;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockJukebox {
  // TODO org.bukkit.block.Jukebox START
  public String getPlaying(LuaValue location) {
    Jukebox block = (Jukebox) LuaValueHelper.toBlock(location).getState();
    return block.getPlaying().name();
  }

  public void setPlaying(LuaValue location, String material) {
    Jukebox block = (Jukebox) LuaValueHelper.toBlock(location).getState();
    block.setPlaying(Material.valueOf(material));
  }

  public boolean isPlaying(LuaValue location) {
    Jukebox block = (Jukebox) LuaValueHelper.toBlock(location).getState();
    return block.isPlaying();
  }

  public boolean eject(LuaValue location) {
    Jukebox block = (Jukebox) LuaValueHelper.toBlock(location).getState();
    return block.eject();
  }
  // TODO org.bukkit.block.Jukebox END
}
