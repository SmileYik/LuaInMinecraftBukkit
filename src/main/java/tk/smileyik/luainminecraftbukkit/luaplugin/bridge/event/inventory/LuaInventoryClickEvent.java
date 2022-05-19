package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryClickEvent extends LuaEvent<InventoryClickEvent> {

  public LuaInventoryClickEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryClickEvent e) {super.event(e);}
}