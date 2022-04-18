package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPickupItemEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityPickupItemEvent extends LuaEvent<EntityPickupItemEvent> {

  public LuaEntityPickupItemEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPickupItemEvent e) {super.event(e);}
}