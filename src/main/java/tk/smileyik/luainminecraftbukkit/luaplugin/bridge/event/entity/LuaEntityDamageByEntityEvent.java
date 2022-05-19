package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityDamageByEntityEvent extends LuaEvent<EntityDamageByEntityEvent> {

  public LuaEntityDamageByEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDamageByEntityEvent e) {super.event(e);}
}