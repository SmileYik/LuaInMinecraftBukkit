package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityUnleashEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityUnleashEvent extends LuaEvent<EntityUnleashEvent> {

  public LuaEntityUnleashEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityUnleashEvent e) {super.event(e);}
}