package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerBedLeaveEvent extends LuaEvent<PlayerBedLeaveEvent> {

  public LuaPlayerBedLeaveEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerBedLeaveEvent e) {super.event(e);}
}