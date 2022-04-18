package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFadeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaBlockFadeEvent extends LuaEvent<BlockFadeEvent> {

  public LuaBlockFadeEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockFadeEvent e) {super.event(e);}
}