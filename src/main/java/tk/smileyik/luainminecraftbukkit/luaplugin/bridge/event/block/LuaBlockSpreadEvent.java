package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockSpreadEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockSpreadEvent extends LuaEvent<BlockSpreadEvent> {

  public LuaBlockSpreadEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockSpreadEvent e) {super.event(e);}
}