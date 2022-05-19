package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaAsyncPlayerChatEvent extends LuaEvent<AsyncPlayerChatEvent> {

  public LuaAsyncPlayerChatEvent(String id) {super(id);}

  @EventHandler
  public void event(AsyncPlayerChatEvent e) {super.event(e);}
}