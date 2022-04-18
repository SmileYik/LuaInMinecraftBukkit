package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTakeLecternBookEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerTakeLecternBookEvent extends LuaEvent<PlayerTakeLecternBookEvent> {

  public LuaPlayerTakeLecternBookEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerTakeLecternBookEvent e) {super.event(e);}
}