package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerMoveEvent extends LuaEvent<PlayerMoveEvent> {

  public LuaPlayerMoveEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerMoveEvent e) {super.event(e);}
}