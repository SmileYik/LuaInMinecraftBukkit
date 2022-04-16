package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPistonEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBlockPistonEvent extends LuaEvent<BlockPistonEvent> {

  public LuaBlockPistonEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockPistonEvent e) {super.event(e);}
}