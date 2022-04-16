package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerPortalEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerPortalEvent extends LuaEvent<PlayerPortalEvent> {

  public LuaPlayerPortalEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerPortalEvent e) {super.event(e);}
}