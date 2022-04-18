package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.StriderTemperatureChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaStriderTemperatureChangeEvent extends LuaEvent<StriderTemperatureChangeEvent> {

  public LuaStriderTemperatureChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(StriderTemperatureChangeEvent e) {super.event(e);}
}