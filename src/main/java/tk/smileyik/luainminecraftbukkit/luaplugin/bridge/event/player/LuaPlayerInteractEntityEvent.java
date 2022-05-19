package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerInteractEntityEvent extends LuaEvent<PlayerInteractEntityEvent> {

  public LuaPlayerInteractEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerInteractEntityEvent e) {super.event(e);}
}