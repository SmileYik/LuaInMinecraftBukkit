package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryOpenEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryOpenEvent extends LuaEvent<InventoryOpenEvent> {

  public LuaInventoryOpenEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryOpenEvent e) {super.event(e);}
}