package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerInteractEvent extends LuaEvent<PlayerInteractEvent> {

  public LuaPlayerInteractEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerInteractEvent e) {super.event(e);}
}