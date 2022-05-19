package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.SlimeSplitEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaSlimeSplitEvent extends LuaEvent<SlimeSplitEvent> {

  public LuaSlimeSplitEvent(String id) {super(id);}

  @EventHandler
  public void event(SlimeSplitEvent e) {super.event(e);}
}