package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockShearEntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaBlockShearEntityEvent extends LuaEvent<BlockShearEntityEvent> {

  public LuaBlockShearEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockShearEntityEvent e) {super.event(e);}
}