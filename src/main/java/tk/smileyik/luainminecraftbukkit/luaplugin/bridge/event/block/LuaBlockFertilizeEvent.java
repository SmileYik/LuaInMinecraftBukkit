package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFertilizeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockFertilizeEvent extends LuaEvent<BlockFertilizeEvent> {

  public LuaBlockFertilizeEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockFertilizeEvent e) {super.event(e);}
}