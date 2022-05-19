package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityEnterBlockEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityEnterBlockEvent extends LuaEvent<EntityEnterBlockEvent> {

  public LuaEntityEnterBlockEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityEnterBlockEvent e) {super.event(e);}
}