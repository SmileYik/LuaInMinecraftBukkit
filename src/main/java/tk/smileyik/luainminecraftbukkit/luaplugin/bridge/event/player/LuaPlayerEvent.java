package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerEvent extends LuaEvent<PlayerEvent> {

  public LuaPlayerEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerEvent e) {super.event(e);}
}