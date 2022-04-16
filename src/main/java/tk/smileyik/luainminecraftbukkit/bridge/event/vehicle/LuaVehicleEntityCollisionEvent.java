package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaVehicleEntityCollisionEvent extends LuaEvent<VehicleEntityCollisionEvent> {

  public LuaVehicleEntityCollisionEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleEntityCollisionEvent e) {super.event(e);}
}