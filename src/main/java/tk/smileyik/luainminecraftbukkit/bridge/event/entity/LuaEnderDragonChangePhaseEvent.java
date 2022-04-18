package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EnderDragonChangePhaseEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaEnderDragonChangePhaseEvent extends LuaEvent<EnderDragonChangePhaseEvent> {

  public LuaEnderDragonChangePhaseEvent(String id) {super(id);}

  @EventHandler
  public void event(EnderDragonChangePhaseEvent e) {super.event(e);}
}