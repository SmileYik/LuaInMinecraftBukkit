package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleExitEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleExitEvent extends LuaEvent<VehicleExitEvent> {

  public LuaVehicleExitEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleExitEvent e) {super.event(e);}
}