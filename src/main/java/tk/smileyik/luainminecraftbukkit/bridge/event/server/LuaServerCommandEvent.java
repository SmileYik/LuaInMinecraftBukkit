package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerCommandEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaServerCommandEvent extends LuaEvent<ServerCommandEvent> {

  public LuaServerCommandEvent(String id) {super(id);}

  @EventHandler
  public void event(ServerCommandEvent e) {super.event(e);}
}