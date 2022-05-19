package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTransformEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityTransformEvent extends LuaEvent<EntityTransformEvent> {

  public LuaEntityTransformEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityTransformEvent e) {super.event(e);}
}