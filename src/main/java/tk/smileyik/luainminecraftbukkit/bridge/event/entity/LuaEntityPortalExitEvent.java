package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalExitEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityPortalExitEvent extends LuaEvent<EntityPortalExitEvent> {

  public LuaEntityPortalExitEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPortalExitEvent e) {super.event(e);}
}