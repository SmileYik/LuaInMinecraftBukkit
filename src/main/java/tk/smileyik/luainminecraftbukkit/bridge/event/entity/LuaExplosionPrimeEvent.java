package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaExplosionPrimeEvent extends LuaEvent<ExplosionPrimeEvent> {

  public LuaExplosionPrimeEvent(String id) {super(id);}

  @EventHandler
  public void event(ExplosionPrimeEvent e) {super.event(e);}
}