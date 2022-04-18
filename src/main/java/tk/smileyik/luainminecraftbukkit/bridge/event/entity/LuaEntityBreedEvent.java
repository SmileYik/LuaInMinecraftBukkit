package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityBreedEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityBreedEvent extends LuaEvent<EntityBreedEvent> {

  public LuaEntityBreedEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityBreedEvent e) {super.event(e);}
}