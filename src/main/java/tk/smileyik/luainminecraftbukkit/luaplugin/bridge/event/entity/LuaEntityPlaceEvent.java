package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPlaceEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityPlaceEvent extends LuaEvent<EntityPlaceEvent> {

  public LuaEntityPlaceEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPlaceEvent e) {super.event(e);}
}