package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerBucketEmptyEvent extends LuaEvent<PlayerBucketEmptyEvent> {

  public LuaPlayerBucketEmptyEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerBucketEmptyEvent e) {super.event(e);}
}