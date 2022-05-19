package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerSwapHandItemsEvent extends LuaEvent<PlayerSwapHandItemsEvent> {

  public LuaPlayerSwapHandItemsEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerSwapHandItemsEvent e) {super.event(e);}
}