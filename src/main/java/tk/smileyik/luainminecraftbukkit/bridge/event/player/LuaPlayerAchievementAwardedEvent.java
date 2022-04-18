package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerAchievementAwardedEvent extends LuaEvent<PlayerAchievementAwardedEvent> {

  public LuaPlayerAchievementAwardedEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerAchievementAwardedEvent e) {super.event(e);}
}