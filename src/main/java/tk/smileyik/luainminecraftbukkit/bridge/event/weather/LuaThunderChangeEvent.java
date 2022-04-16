package tk.smileyik.luainminecraftbukkit.bridge.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.ThunderChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaThunderChangeEvent extends LuaEvent<ThunderChangeEvent> {

  public LuaThunderChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(ThunderChangeEvent e) {super.event(e);}
}