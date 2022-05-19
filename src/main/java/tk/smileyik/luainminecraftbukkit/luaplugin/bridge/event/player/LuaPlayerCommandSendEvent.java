package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerCommandSendEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerCommandSendEvent extends LuaEvent<PlayerCommandSendEvent> {

  public LuaPlayerCommandSendEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerCommandSendEvent e) {super.event(e);}
}