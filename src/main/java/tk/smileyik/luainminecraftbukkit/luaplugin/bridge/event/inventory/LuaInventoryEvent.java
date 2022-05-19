package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryEvent extends LuaEvent<InventoryEvent> {

  public LuaInventoryEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryEvent e) {super.event(e);}
}