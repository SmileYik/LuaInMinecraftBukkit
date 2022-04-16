package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaVehicleMoveEvent extends LuaEvent<VehicleMoveEvent> {

  public LuaVehicleMoveEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleMoveEvent e) {super.event(e);}
}