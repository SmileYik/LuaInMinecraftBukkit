package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.EntityBlockFormEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEntityBlockFormEvent extends LuaEvent<EntityBlockFormEvent> {

  public LuaEntityBlockFormEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityBlockFormEvent e) {super.event(e);}
}