package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityTargetEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityTargetEvent extends LuaEvent<EntityTargetEvent> {

  public LuaEntityTargetEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityTargetEvent e) {super.event(e);}
}