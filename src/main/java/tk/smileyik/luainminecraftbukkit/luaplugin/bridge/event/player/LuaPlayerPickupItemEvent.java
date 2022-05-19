package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPickupItemEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerPickupItemEvent extends LuaEvent<PlayerPickupItemEvent> {

  public LuaPlayerPickupItemEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerPickupItemEvent e) {super.event(e);}
}