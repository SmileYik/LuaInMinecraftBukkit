package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SheepDyeWoolEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaSheepDyeWoolEvent extends LuaEvent<SheepDyeWoolEvent> {

  public LuaSheepDyeWoolEvent(String id) {super(id);}

  @EventHandler
  public void event(SheepDyeWoolEvent e) {super.event(e);}
}