package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerDeathEvent extends LuaEvent<PlayerDeathEvent> {

  public LuaPlayerDeathEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerDeathEvent e) {super.event(e);}
}