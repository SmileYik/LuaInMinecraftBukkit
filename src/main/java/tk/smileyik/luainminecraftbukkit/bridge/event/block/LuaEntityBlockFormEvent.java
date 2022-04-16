package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.EntityBlockFormEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEntityBlockFormEvent extends LuaEvent<EntityBlockFormEvent> {

  public LuaEntityBlockFormEvent(String id) {super(id);}

  @EventHandler
  public void event(EntityBlockFormEvent e) {super.event(e);}
}