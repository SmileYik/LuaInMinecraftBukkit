package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockSpreadEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBlockSpreadEvent extends LuaEvent<BlockSpreadEvent> {

  public LuaBlockSpreadEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockSpreadEvent e) {super.event(e);}
}