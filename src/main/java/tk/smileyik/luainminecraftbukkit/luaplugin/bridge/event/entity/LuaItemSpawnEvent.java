package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ItemSpawnEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaItemSpawnEvent extends LuaEvent<ItemSpawnEvent> {

  public LuaItemSpawnEvent(String id) {super(id);}

  @EventHandler
  public void event(ItemSpawnEvent e) {super.event(e);}
}