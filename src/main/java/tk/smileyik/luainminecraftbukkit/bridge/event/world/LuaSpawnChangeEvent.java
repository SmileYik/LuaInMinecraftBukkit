package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.SpawnChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaSpawnChangeEvent extends LuaEvent<SpawnChangeEvent> {

  public LuaSpawnChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(SpawnChangeEvent e) {super.event(e);}
}