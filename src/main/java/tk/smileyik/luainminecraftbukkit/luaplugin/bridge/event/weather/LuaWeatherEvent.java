package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaWeatherEvent extends LuaEvent<WeatherEvent> {

  public LuaWeatherEvent(String id) {super(id);}

  @EventHandler
  public void event(WeatherEvent e) {super.event(e);}
}