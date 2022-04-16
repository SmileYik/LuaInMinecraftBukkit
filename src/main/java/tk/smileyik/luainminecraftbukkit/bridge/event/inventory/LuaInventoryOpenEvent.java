package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryOpenEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaInventoryOpenEvent extends LuaEvent<InventoryOpenEvent> {

  public LuaInventoryOpenEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryOpenEvent e) {super.event(e);}
}