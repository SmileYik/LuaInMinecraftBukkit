package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerKickEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerKickEvent extends LuaEvent<PlayerKickEvent> {

  public LuaPlayerKickEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerKickEvent e) {super.event(e);}
}