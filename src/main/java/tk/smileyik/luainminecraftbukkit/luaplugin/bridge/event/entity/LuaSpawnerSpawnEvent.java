package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaSpawnerSpawnEvent extends LuaEvent<SpawnerSpawnEvent> {

  public LuaSpawnerSpawnEvent(String id) {super(id);}

  @EventHandler
  public void event(SpawnerSpawnEvent e) {super.event(e);}
}