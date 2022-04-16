package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerChangedWorldEvent extends LuaEvent<PlayerChangedWorldEvent> {

  public LuaPlayerChangedWorldEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerChangedWorldEvent e) {super.event(e);}
}