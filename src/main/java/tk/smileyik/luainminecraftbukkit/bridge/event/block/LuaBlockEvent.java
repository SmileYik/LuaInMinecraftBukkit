package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaBlockEvent extends LuaEvent<BlockEvent> {

  public LuaBlockEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockEvent e) {super.event(e);}
}