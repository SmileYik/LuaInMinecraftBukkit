package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerUnleashEntityEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerUnleashEntityEvent extends LuaEvent<PlayerUnleashEntityEvent> {

  public LuaPlayerUnleashEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerUnleashEntityEvent e) {super.event(e);}
}