package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemHeldEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerItemHeldEvent extends LuaEvent<PlayerItemHeldEvent> {

  public LuaPlayerItemHeldEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerItemHeldEvent e) {super.event(e);}
}