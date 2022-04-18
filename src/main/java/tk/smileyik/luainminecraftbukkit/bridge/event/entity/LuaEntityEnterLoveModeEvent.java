package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityEnterLoveModeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEntityEnterLoveModeEvent extends LuaEvent<EntityEnterLoveModeEvent> {

  public LuaEntityEnterLoveModeEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityEnterLoveModeEvent e) {super.event(e);}
}