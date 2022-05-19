package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleSwimEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityToggleSwimEvent extends LuaEvent<EntityToggleSwimEvent> {

  public LuaEntityToggleSwimEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityToggleSwimEvent e) {super.event(e);}
}