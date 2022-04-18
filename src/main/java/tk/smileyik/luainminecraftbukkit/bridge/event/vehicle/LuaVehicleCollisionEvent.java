package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaVehicleCollisionEvent extends LuaEvent<VehicleCollisionEvent> {

  public LuaVehicleCollisionEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleCollisionEvent e) {super.event(e);}
}