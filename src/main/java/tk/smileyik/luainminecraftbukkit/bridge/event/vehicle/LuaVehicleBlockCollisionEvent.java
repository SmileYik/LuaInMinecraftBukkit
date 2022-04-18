package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaVehicleBlockCollisionEvent extends LuaEvent<VehicleBlockCollisionEvent> {

  public LuaVehicleBlockCollisionEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleBlockCollisionEvent e) {super.event(e);}
}