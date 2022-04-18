package tk.smileyik.luainminecraftbukkit.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaVehicleEnterEvent extends LuaEvent<VehicleEnterEvent> {

  public LuaVehicleEnterEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleEnterEvent e) {super.event(e);}
}