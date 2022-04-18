package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaBlockDispenseEvent extends LuaEvent<BlockDispenseEvent> {

  public LuaBlockDispenseEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockDispenseEvent e) {super.event(e);}
}