package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaInventoryPickupItemEvent extends LuaEvent<InventoryPickupItemEvent> {

  public LuaInventoryPickupItemEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryPickupItemEvent e) {super.event(e);}
}