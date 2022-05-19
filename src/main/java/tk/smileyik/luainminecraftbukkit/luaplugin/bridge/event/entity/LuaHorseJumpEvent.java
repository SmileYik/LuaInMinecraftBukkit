package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.HorseJumpEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaHorseJumpEvent extends LuaEvent<HorseJumpEvent> {

  public LuaHorseJumpEvent(String id) {super(id);}

  @EventHandler
  public void event(HorseJumpEvent e) {super.event(e);}
}