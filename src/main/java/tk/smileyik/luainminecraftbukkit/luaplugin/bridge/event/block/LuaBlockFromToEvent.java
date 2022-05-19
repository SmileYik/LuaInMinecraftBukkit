package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFromToEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockFromToEvent extends LuaEvent<BlockFromToEvent> {

  public LuaBlockFromToEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockFromToEvent e) {super.event(e);}
}