package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerToggleSneakEvent extends LuaEvent<PlayerToggleSneakEvent> {

  public LuaPlayerToggleSneakEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerToggleSneakEvent e) {super.event(e);}
}