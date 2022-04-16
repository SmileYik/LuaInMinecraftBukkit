package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityTargetLivingEntityEvent extends LuaEvent<EntityTargetLivingEntityEvent> {

  public LuaEntityTargetLivingEntityEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityTargetLivingEntityEvent e) {super.event(e);}
}