package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleCollisionEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleCollisionEvent extends LuaEvent<VehicleCollisionEvent> {

  public LuaVehicleCollisionEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleCollisionEvent e) {super.event(e);}
}