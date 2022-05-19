package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBurnEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockBurnEvent extends LuaEvent<BlockBurnEvent> {

  public LuaBlockBurnEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockBurnEvent e) {super.event(e);}
}