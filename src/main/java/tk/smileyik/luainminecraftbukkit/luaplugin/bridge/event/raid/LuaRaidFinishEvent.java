package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.raid;

import org.bukkit.event.EventHandler;
import org.bukkit.event.raid.RaidFinishEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaRaidFinishEvent extends LuaEvent<RaidFinishEvent> {

  public LuaRaidFinishEvent(String id) {super(id);}

  @EventHandler
  public void event(RaidFinishEvent e) {super.event(e);}
}