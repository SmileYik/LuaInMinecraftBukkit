package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryCloseEvent extends LuaEvent<InventoryCloseEvent> {

  public LuaInventoryCloseEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryCloseEvent e) {super.event(e);}
}