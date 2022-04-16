package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityDamageByBlockEvent extends LuaEvent<EntityDamageByBlockEvent> {

  public LuaEntityDamageByBlockEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDamageByBlockEvent e) {super.event(e);}
}