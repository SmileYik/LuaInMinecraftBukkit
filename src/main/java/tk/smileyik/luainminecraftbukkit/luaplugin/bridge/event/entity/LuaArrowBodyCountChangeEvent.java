package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ArrowBodyCountChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaArrowBodyCountChangeEvent extends LuaEvent<ArrowBodyCountChangeEvent> {

  public LuaArrowBodyCountChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(ArrowBodyCountChangeEvent e) {super.event(e);}
}