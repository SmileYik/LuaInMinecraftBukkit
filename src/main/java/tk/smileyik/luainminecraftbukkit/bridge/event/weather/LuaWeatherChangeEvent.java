package tk.smileyik.luainminecraftbukkit.bridge.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.WeatherChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaWeatherChangeEvent extends LuaEvent<WeatherChangeEvent> {

  public LuaWeatherChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(WeatherChangeEvent e) {super.event(e);}
}