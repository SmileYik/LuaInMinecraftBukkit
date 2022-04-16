package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaAsyncPlayerPreLoginEvent extends LuaEvent<AsyncPlayerPreLoginEvent> {

  public LuaAsyncPlayerPreLoginEvent(String id) {super(id);}

  @EventHandler
  public void event(AsyncPlayerPreLoginEvent e) {super.event(e);}
}