package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDamageEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBlockDamageEvent extends LuaEvent<BlockDamageEvent> {

  public LuaBlockDamageEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockDamageEvent e) {super.event(e);}
}