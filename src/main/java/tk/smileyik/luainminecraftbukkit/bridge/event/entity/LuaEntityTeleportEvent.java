package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTeleportEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityTeleportEvent extends LuaEvent<EntityTeleportEvent> {

  public LuaEntityTeleportEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityTeleportEvent e) {super.event(e);}
}