package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.hanging;

import org.bukkit.event.EventHandler;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaHangingBreakByEntityEvent extends LuaEvent<HangingBreakByEntityEvent> {

  public LuaHangingBreakByEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(HangingBreakByEntityEvent e) {super.event(e);}
}