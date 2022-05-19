package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPrepareItemCraftEvent extends LuaEvent<PrepareItemCraftEvent> {

  public LuaPrepareItemCraftEvent(String id) {super(id);}

  @EventHandler
  public void event(PrepareItemCraftEvent e) {super.event(e);}
}