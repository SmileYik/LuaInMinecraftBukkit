package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FireworkExplodeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaFireworkExplodeEvent extends LuaEvent<FireworkExplodeEvent> {

  public LuaFireworkExplodeEvent(String id) {super(id);}

  @EventHandler
  public void event(FireworkExplodeEvent e) {super.event(e);}
}