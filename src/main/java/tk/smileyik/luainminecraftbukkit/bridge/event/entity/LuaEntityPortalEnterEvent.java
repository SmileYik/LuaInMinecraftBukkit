package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPortalEnterEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityPortalEnterEvent extends LuaEvent<EntityPortalEnterEvent> {

  public LuaEntityPortalEnterEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPortalEnterEvent e) {super.event(e);}
}