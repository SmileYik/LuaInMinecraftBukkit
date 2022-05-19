package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockIgniteEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockIgniteEvent extends LuaEvent<BlockIgniteEvent> {

  public LuaBlockIgniteEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockIgniteEvent e) {super.event(e);}
}