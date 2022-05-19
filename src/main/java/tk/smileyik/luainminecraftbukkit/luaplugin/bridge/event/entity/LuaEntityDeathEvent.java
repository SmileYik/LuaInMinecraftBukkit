package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityDeathEvent extends LuaEvent<EntityDeathEvent> {

  public LuaEntityDeathEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDeathEvent e) {super.event(e);}
}