package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityDeathEvent extends LuaEvent<EntityDeathEvent> {

  public LuaEntityDeathEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDeathEvent e) {super.event(e);}
}