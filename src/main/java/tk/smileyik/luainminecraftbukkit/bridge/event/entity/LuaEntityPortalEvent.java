package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityPortalEvent extends LuaEvent<EntityPortalEvent> {

  public LuaEntityPortalEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPortalEvent e) {super.event(e);}
}