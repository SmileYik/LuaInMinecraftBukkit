package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryDragEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryDragEvent extends LuaEvent<InventoryDragEvent> {

  public LuaInventoryDragEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryDragEvent e) {super.event(e);}
}