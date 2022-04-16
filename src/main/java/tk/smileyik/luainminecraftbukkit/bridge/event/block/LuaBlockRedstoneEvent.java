package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockRedstoneEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBlockRedstoneEvent extends LuaEvent<BlockRedstoneEvent> {

  public LuaBlockRedstoneEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockRedstoneEvent e) {super.event(e);}
}