package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServiceUnregisterEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaServiceUnregisterEvent extends LuaEvent<ServiceUnregisterEvent> {

  public LuaServiceUnregisterEvent(String id) {super(id);}

  @EventHandler
  public void event(ServiceUnregisterEvent e) {super.event(e);}
}