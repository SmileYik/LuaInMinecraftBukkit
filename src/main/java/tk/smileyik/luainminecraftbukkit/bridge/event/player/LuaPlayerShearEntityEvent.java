package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerShearEntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerShearEntityEvent extends LuaEvent<PlayerShearEntityEvent> {

  public LuaPlayerShearEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerShearEntityEvent e) {super.event(e);}
}