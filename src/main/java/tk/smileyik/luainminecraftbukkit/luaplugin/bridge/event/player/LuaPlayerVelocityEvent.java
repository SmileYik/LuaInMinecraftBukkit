package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerVelocityEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerVelocityEvent extends LuaEvent<PlayerVelocityEvent> {

  public LuaPlayerVelocityEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerVelocityEvent e) {super.event(e);}
}