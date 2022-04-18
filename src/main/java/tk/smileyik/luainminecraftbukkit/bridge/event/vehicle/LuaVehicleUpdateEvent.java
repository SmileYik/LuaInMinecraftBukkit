package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaVehicleUpdateEvent extends LuaEvent<VehicleUpdateEvent> {

  public LuaVehicleUpdateEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleUpdateEvent e) {super.event(e);}
}