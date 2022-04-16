package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemDespawnEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaItemDespawnEvent extends LuaEvent<ItemDespawnEvent> {

  public LuaItemDespawnEvent(String id) {super(id);}

  @EventHandler
  public void event(ItemDespawnEvent e) {super.event(e);}
}