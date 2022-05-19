package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleBlockCollisionEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleBlockCollisionEvent extends LuaEvent<VehicleBlockCollisionEvent> {

  public LuaVehicleBlockCollisionEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleBlockCollisionEvent e) {super.event(e);}
}