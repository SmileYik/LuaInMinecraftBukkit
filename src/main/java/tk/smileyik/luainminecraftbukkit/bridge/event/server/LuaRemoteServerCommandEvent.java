package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.RemoteServerCommandEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaRemoteServerCommandEvent extends LuaEvent<RemoteServerCommandEvent> {

  public LuaRemoteServerCommandEvent(String id) {super(id);}

  @EventHandler
  public void event(RemoteServerCommandEvent e) {super.event(e);}
}