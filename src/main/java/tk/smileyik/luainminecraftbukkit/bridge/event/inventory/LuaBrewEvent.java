package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.BrewEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBrewEvent extends LuaEvent<BrewEvent> {

  public LuaBrewEvent(String id) {super(id);}

  @EventHandler
  public void event(BrewEvent e) {super.event(e);}
}