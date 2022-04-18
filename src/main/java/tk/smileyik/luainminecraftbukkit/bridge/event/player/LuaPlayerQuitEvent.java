package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerQuitEvent extends LuaEvent<PlayerQuitEvent> {

  public LuaPlayerQuitEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerQuitEvent e) {super.event(e);}
}