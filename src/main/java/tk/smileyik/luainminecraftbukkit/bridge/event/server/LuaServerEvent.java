package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaServerEvent extends LuaEvent<ServerEvent> {

  public LuaServerEvent(String id) {super(id);}

  @EventHandler
  public void event(ServerEvent e) {super.event(e);}
}