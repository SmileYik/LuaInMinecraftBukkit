package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaServerListPingEvent extends LuaEvent<ServerListPingEvent> {

  public LuaServerListPingEvent(String id) {super(id);}

  @EventHandler
  public void event(ServerListPingEvent e) {super.event(e);}
}