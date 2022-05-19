package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleEvent extends LuaEvent<VehicleEvent> {

  public LuaVehicleEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleEvent e) {super.event(e);}
}