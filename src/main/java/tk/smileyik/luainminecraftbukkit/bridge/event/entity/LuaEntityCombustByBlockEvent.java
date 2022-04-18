package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCombustByBlockEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityCombustByBlockEvent extends LuaEvent<EntityCombustByBlockEvent> {

  public LuaEntityCombustByBlockEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityCombustByBlockEvent e) {super.event(e);}
}