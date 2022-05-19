package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemBreakEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerItemBreakEvent extends LuaEvent<PlayerItemBreakEvent> {

  public LuaPlayerItemBreakEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerItemBreakEvent e) {super.event(e);}
}