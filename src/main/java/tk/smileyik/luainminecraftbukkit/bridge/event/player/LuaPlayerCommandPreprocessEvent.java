package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerCommandPreprocessEvent extends LuaEvent<PlayerCommandPreprocessEvent> {

  public LuaPlayerCommandPreprocessEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerCommandPreprocessEvent e) {super.event(e);}
}