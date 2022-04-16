package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerGameModeChangeEvent extends LuaEvent<PlayerGameModeChangeEvent> {

  public LuaPlayerGameModeChangeEvent(String id) {
    super(id);
  }

  @EventHandler
  @Override
  public void event(PlayerGameModeChangeEvent e) {
    super.event(e);
  }
}
