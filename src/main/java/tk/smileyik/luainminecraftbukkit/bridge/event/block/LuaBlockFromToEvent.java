package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFromToEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBlockFromToEvent extends LuaEvent<BlockFromToEvent> {

  public LuaBlockFromToEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockFromToEvent e) {super.event(e);}
}