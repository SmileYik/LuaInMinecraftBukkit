package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerUnregisterChannelEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerUnregisterChannelEvent extends LuaEvent<PlayerUnregisterChannelEvent> {

  public LuaPlayerUnregisterChannelEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerUnregisterChannelEvent e) {super.event(e);}
}