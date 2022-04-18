package tk.smileyik.luainminecraftbukkit.bridge.event.raid;

import org.bukkit.event.EventHandler;
import org.bukkit.event.raid.RaidSpawnWaveEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaRaidSpawnWaveEvent extends LuaEvent<RaidSpawnWaveEvent> {

  public LuaRaidSpawnWaveEvent(String id) {super(id);}

  @EventHandler
  public void event(RaidSpawnWaveEvent e) {super.event(e);}
}