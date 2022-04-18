package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpellCastEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntitySpellCastEvent extends LuaEvent<EntitySpellCastEvent> {

  public LuaEntitySpellCastEvent(String id) {super(id);}

  @EventHandler
  public void event(EntitySpellCastEvent e) {super.event(e);}
}