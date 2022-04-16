package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemMergeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaItemMergeEvent extends LuaEvent<ItemMergeEvent> {

  public LuaItemMergeEvent(String id) {super(id);}

  @EventHandler
  public void event(ItemMergeEvent e) {super.event(e);}
}