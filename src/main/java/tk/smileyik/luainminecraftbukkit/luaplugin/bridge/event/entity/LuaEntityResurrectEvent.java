package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityResurrectEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityResurrectEvent extends LuaEvent<EntityResurrectEvent> {

  public LuaEntityResurrectEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityResurrectEvent e) {super.event(e);}
}