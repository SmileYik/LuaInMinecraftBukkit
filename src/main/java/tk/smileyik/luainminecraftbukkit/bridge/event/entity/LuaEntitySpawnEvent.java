package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntitySpawnEvent extends LuaEvent<EntitySpawnEvent> {

  public LuaEntitySpawnEvent(String id) {super(id);}

  @EventHandler
  public void event(EntitySpawnEvent e) {super.event(e);}
}