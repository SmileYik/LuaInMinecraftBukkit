package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerEditBookEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerEditBookEvent extends LuaEvent<PlayerEditBookEvent> {

  public LuaPlayerEditBookEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerEditBookEvent e) {super.event(e);}
}