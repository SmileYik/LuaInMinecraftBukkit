package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.LeavesDecayEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaLeavesDecayEvent extends LuaEvent<LeavesDecayEvent> {

  public LuaLeavesDecayEvent(String id) {super(id);}

  @EventHandler
  public void event(LeavesDecayEvent e) {super.event(e);}
}