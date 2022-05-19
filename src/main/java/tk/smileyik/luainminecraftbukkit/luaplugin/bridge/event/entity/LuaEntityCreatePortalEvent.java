package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCreatePortalEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityCreatePortalEvent extends LuaEvent<EntityCreatePortalEvent> {

  public LuaEntityCreatePortalEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityCreatePortalEvent e) {super.event(e);}
}