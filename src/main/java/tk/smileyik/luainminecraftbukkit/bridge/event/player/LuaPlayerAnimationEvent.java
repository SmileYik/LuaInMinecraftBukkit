package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerAnimationEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerAnimationEvent extends LuaEvent<PlayerAnimationEvent> {

  public LuaPlayerAnimationEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerAnimationEvent e) {super.event(e);}
}