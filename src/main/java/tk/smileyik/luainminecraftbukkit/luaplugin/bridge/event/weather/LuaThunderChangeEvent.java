package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.ThunderChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaThunderChangeEvent extends LuaEvent<ThunderChangeEvent> {

  public LuaThunderChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(ThunderChangeEvent e) {super.event(e);}
}