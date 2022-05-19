package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleEnterEvent extends LuaEvent<VehicleEnterEvent> {

  public LuaVehicleEnterEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleEnterEvent e) {super.event(e);}
}