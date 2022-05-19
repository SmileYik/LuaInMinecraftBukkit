package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemDamageEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerItemDamageEvent extends LuaEvent<PlayerItemDamageEvent> {

  public LuaPlayerItemDamageEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerItemDamageEvent e) {super.event(e);}
}