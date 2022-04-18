package tk.smileyik.luainminecraftbukkit.bridge.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaWeatherEvent extends LuaEvent<WeatherEvent> {

  public LuaWeatherEvent(String id) {super(id);}

  @EventHandler
  public void event(WeatherEvent e) {super.event(e);}
}