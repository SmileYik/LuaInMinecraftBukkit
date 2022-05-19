package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerToggleFlightEvent extends LuaEvent<PlayerToggleFlightEvent> {

  public LuaPlayerToggleFlightEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerToggleFlightEvent e) {super.event(e);}
}