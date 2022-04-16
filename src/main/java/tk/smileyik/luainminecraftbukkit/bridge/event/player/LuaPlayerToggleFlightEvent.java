package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerToggleFlightEvent extends LuaEvent<PlayerToggleFlightEvent> {

  public LuaPlayerToggleFlightEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerToggleFlightEvent e) {super.event(e);}
}