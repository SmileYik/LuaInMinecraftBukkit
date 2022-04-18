package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerLeashEntityEvent extends LuaEvent<PlayerLeashEntityEvent> {

  public LuaPlayerLeashEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerLeashEntityEvent e) {super.event(e);}
}