package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDropItemEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockDropItemEvent extends LuaEvent<BlockDropItemEvent> {

  public LuaBlockDropItemEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockDropItemEvent e) {super.event(e);}
}