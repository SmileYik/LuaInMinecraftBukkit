package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServiceEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaServiceEvent extends LuaEvent<ServiceEvent> {

  public LuaServiceEvent(String id) {super(id);}

  @EventHandler
  public void event(ServiceEvent e) {super.event(e);}
}