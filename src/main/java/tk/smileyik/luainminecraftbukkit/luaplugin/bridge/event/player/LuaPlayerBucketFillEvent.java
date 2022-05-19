package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBucketFillEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerBucketFillEvent extends LuaEvent<PlayerBucketFillEvent> {

  public LuaPlayerBucketFillEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerBucketFillEvent e) {super.event(e);}
}