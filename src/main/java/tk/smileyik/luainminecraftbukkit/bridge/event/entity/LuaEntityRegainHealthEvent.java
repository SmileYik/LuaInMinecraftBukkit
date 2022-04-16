package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityRegainHealthEvent extends LuaEvent<EntityRegainHealthEvent> {

  public LuaEntityRegainHealthEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityRegainHealthEvent e) {super.event(e);}
}