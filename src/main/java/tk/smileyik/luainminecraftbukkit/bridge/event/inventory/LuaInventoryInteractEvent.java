package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryInteractEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaInventoryInteractEvent extends LuaEvent<InventoryInteractEvent> {

  public LuaInventoryInteractEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryInteractEvent e) {super.event(e);}
}