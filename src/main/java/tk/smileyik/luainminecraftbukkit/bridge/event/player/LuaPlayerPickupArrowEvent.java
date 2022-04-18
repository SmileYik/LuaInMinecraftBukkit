package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerPickupArrowEvent extends LuaEvent<PlayerPickupArrowEvent> {

  public LuaPlayerPickupArrowEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerPickupArrowEvent e) {super.event(e);}
}