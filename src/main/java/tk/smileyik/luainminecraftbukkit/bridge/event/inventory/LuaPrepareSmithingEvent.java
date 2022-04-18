package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPrepareSmithingEvent extends LuaEvent<PrepareSmithingEvent> {

  public LuaPrepareSmithingEvent(String id) {super(id);}

  @EventHandler
  public void event(PrepareSmithingEvent e) {super.event(e);}
}