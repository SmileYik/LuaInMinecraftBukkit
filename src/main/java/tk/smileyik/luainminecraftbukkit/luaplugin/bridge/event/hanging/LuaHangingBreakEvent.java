package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.hanging;

import org.bukkit.event.EventHandler;
import org.bukkit.event.hanging.HangingBreakEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaHangingBreakEvent extends LuaEvent<HangingBreakEvent> {

  public LuaHangingBreakEvent(String id) {super(id);}

  @EventHandler
  public void event(HangingBreakEvent e) {super.event(e);}
}