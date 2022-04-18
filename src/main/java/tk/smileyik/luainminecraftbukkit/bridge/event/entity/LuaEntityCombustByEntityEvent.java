package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityCombustByEntityEvent extends LuaEvent<EntityCombustByEntityEvent> {

  public LuaEntityCombustByEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityCombustByEntityEvent e) {super.event(e);}
}