package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockExpEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockExpEvent extends LuaEvent<BlockExpEvent> {

  public LuaBlockExpEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockExpEvent e) {super.event(e);}
}