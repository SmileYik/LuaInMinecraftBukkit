package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPistonExtendEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockPistonExtendEvent extends LuaEvent<BlockPistonExtendEvent> {

  public LuaBlockPistonExtendEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockPistonExtendEvent e) {super.event(e);}
}