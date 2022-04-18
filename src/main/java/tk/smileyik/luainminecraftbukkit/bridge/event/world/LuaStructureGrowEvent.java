package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.StructureGrowEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaStructureGrowEvent extends LuaEvent<StructureGrowEvent> {

  public LuaStructureGrowEvent(String id) {super(id);}

  @EventHandler
  public void event(StructureGrowEvent e) {super.event(e);}
}