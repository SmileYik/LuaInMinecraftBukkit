package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.PortalCreateEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPortalCreateEvent extends LuaEvent<PortalCreateEvent> {

  public LuaPortalCreateEvent(String id) {super(id);}

  @EventHandler
  public void event(PortalCreateEvent e) {super.event(e);}
}