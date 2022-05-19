package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerExpChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerExpChangeEvent extends LuaEvent<PlayerExpChangeEvent> {

  public LuaPlayerExpChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerExpChangeEvent e) {super.event(e);}
}