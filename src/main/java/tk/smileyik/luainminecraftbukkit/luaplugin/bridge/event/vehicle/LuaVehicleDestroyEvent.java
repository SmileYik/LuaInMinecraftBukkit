package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.vehicle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVehicleDestroyEvent extends LuaEvent<VehicleDestroyEvent> {

  public LuaVehicleDestroyEvent(String id) {super(id);}

  @EventHandler
  public void event(VehicleDestroyEvent e) {super.event(e);}
}