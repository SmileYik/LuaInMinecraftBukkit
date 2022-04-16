package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaProjectileHitEvent extends LuaEvent<ProjectileHitEvent> {

  public LuaProjectileHitEvent(String id) {super(id);}

  @EventHandler
  public void event(ProjectileHitEvent e) {super.event(e);}
}