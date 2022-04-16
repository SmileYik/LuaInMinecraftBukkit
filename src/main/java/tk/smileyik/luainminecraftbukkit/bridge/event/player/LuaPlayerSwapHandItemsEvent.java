package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerSwapHandItemsEvent extends LuaEvent<PlayerSwapHandItemsEvent> {

  public LuaPlayerSwapHandItemsEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerSwapHandItemsEvent e) {super.event(e);}
}