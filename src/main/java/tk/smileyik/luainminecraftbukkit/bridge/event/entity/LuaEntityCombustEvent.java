package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityCombustEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityCombustEvent extends LuaEvent<EntityCombustEvent> {

  public LuaEntityCombustEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityCombustEvent e) {super.event(e);}
}