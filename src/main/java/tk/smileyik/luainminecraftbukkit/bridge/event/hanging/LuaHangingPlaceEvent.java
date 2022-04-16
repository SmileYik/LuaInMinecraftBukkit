package tk.smileyik.luainminecraftbukkit.bridge.event.hanging;

import org.bukkit.event.EventHandler;
import org.bukkit.event.hanging.HangingPlaceEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaHangingPlaceEvent extends LuaEvent<HangingPlaceEvent> {

  public LuaHangingPlaceEvent(String id) {super(id);}

  @EventHandler
  public void event(HangingPlaceEvent e) {super.event(e);}
}