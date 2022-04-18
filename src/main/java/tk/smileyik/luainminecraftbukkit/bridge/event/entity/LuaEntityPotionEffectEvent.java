package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityPotionEffectEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityPotionEffectEvent extends LuaEvent<EntityPotionEffectEvent> {

  public LuaEntityPotionEffectEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityPotionEffectEvent e) {super.event(e);}
}