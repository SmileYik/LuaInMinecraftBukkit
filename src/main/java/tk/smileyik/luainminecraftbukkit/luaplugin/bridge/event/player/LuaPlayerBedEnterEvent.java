package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedEnterEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerBedEnterEvent extends LuaEvent<PlayerBedEnterEvent> {

  public LuaPlayerBedEnterEvent(String id) {
    super(id);
  }

  @EventHandler
  public void event(PlayerBedEnterEvent e) {
    super.event(e);
  }
}
