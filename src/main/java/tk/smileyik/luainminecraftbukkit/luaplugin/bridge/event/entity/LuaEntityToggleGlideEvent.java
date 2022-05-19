package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityToggleGlideEvent extends LuaEvent<EntityToggleGlideEvent> {

  public LuaEntityToggleGlideEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityToggleGlideEvent e) {super.event(e);}
}