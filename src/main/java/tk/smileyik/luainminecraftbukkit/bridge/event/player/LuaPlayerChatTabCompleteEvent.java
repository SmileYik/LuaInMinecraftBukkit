package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPlayerChatTabCompleteEvent extends LuaEvent<PlayerChatTabCompleteEvent> {

  public LuaPlayerChatTabCompleteEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerChatTabCompleteEvent e) {super.event(e);}
}