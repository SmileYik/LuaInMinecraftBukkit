package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleUpdateEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleUpdateEvent extends LuaEvent<VehicleUpdateEvent> {

  public LuaVehicleUpdateEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleUpdateEvent e) {super.event(e);}
}