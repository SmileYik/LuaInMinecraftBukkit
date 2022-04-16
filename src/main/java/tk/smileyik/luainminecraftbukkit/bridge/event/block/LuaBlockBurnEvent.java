package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBurnEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBlockBurnEvent extends LuaEvent<BlockBurnEvent> {

  public LuaBlockBurnEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockBurnEvent e) {super.event(e);}
}