package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerInteractAtEntityEvent extends LuaEvent<PlayerInteractAtEntityEvent> {

  public LuaPlayerInteractAtEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerInteractAtEntityEvent e) {super.event(e);}
}