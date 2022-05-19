package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityChangeBlockEvent extends LuaEvent<EntityChangeBlockEvent> {

  public LuaEntityChangeBlockEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityChangeBlockEvent e) {super.event(e);}
}