package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerBucketEvent extends LuaEvent<PlayerBucketEvent> {

  public LuaPlayerBucketEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerBucketEvent e) {super.event(e);}
}