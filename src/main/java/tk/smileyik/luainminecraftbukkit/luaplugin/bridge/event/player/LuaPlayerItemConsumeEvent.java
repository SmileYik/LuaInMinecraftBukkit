package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerItemConsumeEvent extends LuaEvent<PlayerItemConsumeEvent> {

  public LuaPlayerItemConsumeEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerItemConsumeEvent e) {super.event(e);}
}