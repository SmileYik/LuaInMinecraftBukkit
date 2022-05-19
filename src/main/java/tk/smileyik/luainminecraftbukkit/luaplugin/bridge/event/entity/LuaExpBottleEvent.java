package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ExpBottleEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaExpBottleEvent extends LuaEvent<ExpBottleEvent> {

  public LuaExpBottleEvent(String id) {super(id);}

  @EventHandler
  public void event(ExpBottleEvent e) {super.event(e);}
}