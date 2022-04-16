package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTameEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityTameEvent extends LuaEvent<EntityTameEvent> {

  public LuaEntityTameEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityTameEvent e) {super.event(e);}
}