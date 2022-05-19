package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPoseChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityPoseChangeEvent extends LuaEvent<EntityPoseChangeEvent> {

  public LuaEntityPoseChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPoseChangeEvent e) {super.event(e);}
}