package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityInteractEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityInteractEvent extends LuaEvent<EntityInteractEvent> {

  public LuaEntityInteractEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityInteractEvent e) {super.event(e);}
}