package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityDamageEvent extends LuaEvent<EntityDamageEvent> {

  public LuaEntityDamageEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDamageEvent e) {super.event(e);}
}