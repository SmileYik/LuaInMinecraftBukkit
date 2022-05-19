package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityExplodeEvent extends LuaEvent<EntityExplodeEvent> {

  public LuaEntityExplodeEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityExplodeEvent e) {super.event(e);}
}