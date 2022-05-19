package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockBreakEvent extends LuaEvent<BlockBreakEvent> {

  public LuaBlockBreakEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockBreakEvent e) {super.event(e);}
}