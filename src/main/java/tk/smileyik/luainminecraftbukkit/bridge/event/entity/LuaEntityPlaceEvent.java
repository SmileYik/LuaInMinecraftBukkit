package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPlaceEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityPlaceEvent extends LuaEvent<EntityPlaceEvent> {

  public LuaEntityPlaceEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPlaceEvent e) {super.event(e);}
}