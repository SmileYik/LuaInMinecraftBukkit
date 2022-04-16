package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedEnterEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerBedEnterEvent extends LuaEvent<PlayerBedEnterEvent> {

  public LuaPlayerBedEnterEvent(String id) {
    super(id);
  }

  @EventHandler
  public void event(PlayerBedEnterEvent e) {
    super.event(e);
  }
}
