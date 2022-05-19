package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.MapInitializeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaMapInitializeEvent extends LuaEvent<MapInitializeEvent> {

  public LuaMapInitializeEvent(String id) {super(id);}

  @EventHandler
  public void event(MapInitializeEvent e) {super.event(e);}
}