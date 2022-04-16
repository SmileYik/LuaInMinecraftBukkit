package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerRespawnEvent extends LuaEvent<PlayerRespawnEvent> {

  public LuaPlayerRespawnEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerRespawnEvent e) {super.event(e);}
}