package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaCreatureSpawnEvent extends LuaEvent<CreatureSpawnEvent> {

  public LuaCreatureSpawnEvent(String id) {super(id);}

  @EventHandler
  public void event(CreatureSpawnEvent e) {super.event(e);}
}