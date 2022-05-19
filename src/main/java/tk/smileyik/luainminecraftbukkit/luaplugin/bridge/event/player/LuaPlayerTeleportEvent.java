package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerTeleportEvent extends LuaEvent<PlayerTeleportEvent> {

  public LuaPlayerTeleportEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerTeleportEvent e) {super.event(e);}
}