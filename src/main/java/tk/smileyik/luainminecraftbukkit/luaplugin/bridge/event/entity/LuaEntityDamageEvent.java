package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityDamageEvent extends LuaEvent<EntityDamageEvent> {

  public LuaEntityDamageEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDamageEvent e) {super.event(e);}
}