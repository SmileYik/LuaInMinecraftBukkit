package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityAirChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityAirChangeEvent extends LuaEvent<EntityAirChangeEvent> {

  public LuaEntityAirChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityAirChangeEvent e) {super.event(e);}
}