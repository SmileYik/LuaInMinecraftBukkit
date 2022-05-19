package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerLoginEvent extends LuaEvent<PlayerLoginEvent> {

  public LuaPlayerLoginEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerLoginEvent e) {super.event(e);}
}