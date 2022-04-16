package tk.smileyik.luainminecraftbukkit.bridge.event.weather;

import org.bukkit.event.EventHandler;
import org.bukkit.event.weather.LightningStrikeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaLightningStrikeEvent extends LuaEvent<LightningStrikeEvent> {

  public LuaLightningStrikeEvent(String id) {super(id);}

  @EventHandler
  public void event(LightningStrikeEvent e) {super.event(e);}
}