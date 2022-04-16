package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityBreakDoorEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityBreakDoorEvent extends LuaEvent<EntityBreakDoorEvent> {

  public LuaEntityBreakDoorEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityBreakDoorEvent e) {super.event(e);}
}