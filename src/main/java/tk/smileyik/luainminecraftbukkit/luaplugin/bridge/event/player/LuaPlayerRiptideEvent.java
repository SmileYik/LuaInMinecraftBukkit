package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRiptideEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPlayerRiptideEvent extends LuaEvent<PlayerRiptideEvent> {

  public LuaPlayerRiptideEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerRiptideEvent e) {super.event(e);}
}