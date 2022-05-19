package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.hanging;

import org.bukkit.event.EventHandler;
import org.bukkit.event.hanging.HangingEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaHangingEvent extends LuaEvent<HangingEvent> {

  public LuaHangingEvent(String id) {super(id);}

  @EventHandler
  public void event(HangingEvent e) {super.event(e);}
}