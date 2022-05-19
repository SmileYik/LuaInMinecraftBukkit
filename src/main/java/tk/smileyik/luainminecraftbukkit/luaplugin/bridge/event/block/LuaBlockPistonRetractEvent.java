package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPistonRetractEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockPistonRetractEvent extends LuaEvent<BlockPistonRetractEvent> {

  public LuaBlockPistonRetractEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockPistonRetractEvent e) {super.event(e);}
}