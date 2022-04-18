package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityEvent extends LuaEvent<EntityEvent> {

  public LuaEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityEvent e) {super.event(e);}
}