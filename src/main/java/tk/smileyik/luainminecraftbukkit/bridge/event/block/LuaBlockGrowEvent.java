package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockGrowEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaBlockGrowEvent extends LuaEvent<BlockGrowEvent> {

  public LuaBlockGrowEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockGrowEvent e) {super.event(e);}
}