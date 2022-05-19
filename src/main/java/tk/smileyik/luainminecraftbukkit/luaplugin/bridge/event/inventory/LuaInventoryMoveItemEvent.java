package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryMoveItemEvent extends LuaEvent<InventoryMoveItemEvent> {

  public LuaInventoryMoveItemEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryMoveItemEvent e) {super.event(e);}
}