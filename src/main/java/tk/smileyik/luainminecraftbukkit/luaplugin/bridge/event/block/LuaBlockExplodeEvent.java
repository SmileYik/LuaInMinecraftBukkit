package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockExplodeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockExplodeEvent extends LuaEvent<BlockExplodeEvent> {

  public LuaBlockExplodeEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockExplodeEvent e) {super.event(e);}
}