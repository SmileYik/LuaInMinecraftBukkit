package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemMendEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerItemMendEvent extends LuaEvent<PlayerItemMendEvent> {

  public LuaPlayerItemMendEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerItemMendEvent e) {super.event(e);}
}