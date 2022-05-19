package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPrepareAnvilEvent extends LuaEvent<PrepareAnvilEvent> {

  public LuaPrepareAnvilEvent(String id) {super(id);}

  @EventHandler
  public void event(PrepareAnvilEvent e) {super.event(e);}
}