package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockPlaceEvent extends LuaEvent<BlockPlaceEvent> {

  public LuaBlockPlaceEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockPlaceEvent e) {super.event(e);}
}