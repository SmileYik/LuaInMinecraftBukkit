package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChannelEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerChannelEvent extends LuaEvent<PlayerChannelEvent> {

  public LuaPlayerChannelEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerChannelEvent e) {super.event(e);}
}