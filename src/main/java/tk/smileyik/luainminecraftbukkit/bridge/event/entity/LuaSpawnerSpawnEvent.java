package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaSpawnerSpawnEvent extends LuaEvent<SpawnerSpawnEvent> {

  public LuaSpawnerSpawnEvent(String id) {super(id);}

  @EventHandler
  public void event(SpawnerSpawnEvent e) {super.event(e);}
}