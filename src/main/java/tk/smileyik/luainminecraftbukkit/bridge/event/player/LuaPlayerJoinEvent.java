package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerJoinEvent extends LuaEvent<PlayerJoinEvent> {

  public LuaPlayerJoinEvent(String id) {
    super(id);
  }

  @EventHandler
  public void event(PlayerJoinEvent e) {
    super.event(e);
  }
}
