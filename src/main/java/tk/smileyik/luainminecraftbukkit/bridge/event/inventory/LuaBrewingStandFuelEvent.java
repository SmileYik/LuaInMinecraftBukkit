package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.BrewingStandFuelEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaBrewingStandFuelEvent extends LuaEvent<BrewingStandFuelEvent> {

  public LuaBrewingStandFuelEvent(String id) {super(id);}

  @EventHandler
  public void event(BrewingStandFuelEvent e) {super.event(e);}
}