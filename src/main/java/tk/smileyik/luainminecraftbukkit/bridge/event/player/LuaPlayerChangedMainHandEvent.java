package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChangedMainHandEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerChangedMainHandEvent extends LuaEvent<PlayerChangedMainHandEvent> {
  public LuaPlayerChangedMainHandEvent(String id) {
    super(id);
  }

  @EventHandler
  @Override
  public void event(PlayerChangedMainHandEvent e) {
    super.event(e);
  }
}
