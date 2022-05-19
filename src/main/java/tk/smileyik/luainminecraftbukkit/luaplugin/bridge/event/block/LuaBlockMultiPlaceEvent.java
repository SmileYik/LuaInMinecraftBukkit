package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockMultiPlaceEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockMultiPlaceEvent extends LuaEvent<BlockMultiPlaceEvent> {

  public LuaBlockMultiPlaceEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockMultiPlaceEvent e) {super.event(e);}
}