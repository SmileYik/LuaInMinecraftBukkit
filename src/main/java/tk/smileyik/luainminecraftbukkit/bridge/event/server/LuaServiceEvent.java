package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServiceEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaServiceEvent extends LuaEvent<ServiceEvent> {

  public LuaServiceEvent(String id) {super(id);}

  @EventHandler
  public void event(ServiceEvent e) {super.event(e);}
}