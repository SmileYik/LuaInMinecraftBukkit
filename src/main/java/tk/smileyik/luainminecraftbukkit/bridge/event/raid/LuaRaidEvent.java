package tk.smileyik.luainminecraftbukkit.bridge.event.raid;

import org.bukkit.event.EventHandler;
import org.bukkit.event.raid.RaidEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaRaidEvent extends LuaEvent<RaidEvent> {

  public LuaRaidEvent(String id) {super(id);}

  @EventHandler
  public void event(RaidEvent e) {super.event(e);}
}