package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemMergeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaItemMergeEvent extends LuaEvent<ItemMergeEvent> {

  public LuaItemMergeEvent(String id) {super(id);}

  @EventHandler
  public void event(ItemMergeEvent e) {super.event(e);}
}