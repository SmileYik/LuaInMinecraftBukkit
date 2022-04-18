package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PigZapEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPigZapEvent extends LuaEvent<PigZapEvent> {

  public LuaPigZapEvent(String id) {super(id);}

  @EventHandler
  public void event(PigZapEvent e) {super.event(e);}
}