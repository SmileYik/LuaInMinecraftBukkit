package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SheepRegrowWoolEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaSheepRegrowWoolEvent extends LuaEvent<SheepRegrowWoolEvent> {

  public LuaSheepRegrowWoolEvent(String id) {super(id);}

  @EventHandler
  public void event(SheepRegrowWoolEvent e) {super.event(e);}
}