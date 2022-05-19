package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerAdvancementDoneEvent extends LuaEvent<PlayerAdvancementDoneEvent> {

  public LuaPlayerAdvancementDoneEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerAdvancementDoneEvent e) {super.event(e);}
}