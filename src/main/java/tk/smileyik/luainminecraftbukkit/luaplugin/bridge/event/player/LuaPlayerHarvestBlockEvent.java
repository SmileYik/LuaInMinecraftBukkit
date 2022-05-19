package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerHarvestBlockEvent extends LuaEvent<PlayerHarvestBlockEvent> {

  public LuaPlayerHarvestBlockEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerHarvestBlockEvent e) {super.event(e);}
}