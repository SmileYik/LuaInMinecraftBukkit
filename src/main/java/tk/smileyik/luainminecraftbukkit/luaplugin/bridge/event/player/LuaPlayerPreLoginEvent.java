package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPreLoginEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerPreLoginEvent extends LuaEvent<PlayerPreLoginEvent> {

  public LuaPlayerPreLoginEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerPreLoginEvent e) {super.event(e);}
}