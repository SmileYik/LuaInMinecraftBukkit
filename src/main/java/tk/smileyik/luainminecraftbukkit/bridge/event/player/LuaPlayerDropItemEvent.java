package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerDropItemEvent extends LuaEvent<PlayerDropItemEvent> {

  public LuaPlayerDropItemEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerDropItemEvent e) {super.event(e);}
}