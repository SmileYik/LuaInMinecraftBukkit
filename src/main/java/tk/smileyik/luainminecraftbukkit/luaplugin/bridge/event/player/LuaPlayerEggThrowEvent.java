package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerEggThrowEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerEggThrowEvent extends LuaEvent<PlayerEggThrowEvent> {

  public LuaPlayerEggThrowEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerEggThrowEvent e) {super.event(e);}
}