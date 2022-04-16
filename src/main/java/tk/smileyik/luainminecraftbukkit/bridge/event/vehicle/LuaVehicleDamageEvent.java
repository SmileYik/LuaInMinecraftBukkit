package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleDamageEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaVehicleDamageEvent extends LuaEvent<VehicleDamageEvent> {

  public LuaVehicleDamageEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleDamageEvent e) {super.event(e);}
}