package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerChatEvent extends LuaEvent<PlayerChatEvent> {

  public LuaPlayerChatEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerChatEvent e) {super.event(e);}
}