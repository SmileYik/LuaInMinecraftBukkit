package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaInventoryCreativeEvent extends LuaEvent<InventoryCreativeEvent> {

  public LuaInventoryCreativeEvent(String id) {super(id);}

  @EventHandler
  public void event(InventoryCreativeEvent e) {super.event(e);}
}