package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDropItemEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityDropItemEvent extends LuaEvent<EntityDropItemEvent> {

  public LuaEntityDropItemEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityDropItemEvent e) {super.event(e);}
}