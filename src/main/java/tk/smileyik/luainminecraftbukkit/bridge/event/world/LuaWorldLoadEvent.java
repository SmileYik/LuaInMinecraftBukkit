package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldLoadEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaWorldLoadEvent extends LuaEvent<WorldLoadEvent> {

  public LuaWorldLoadEvent(String id) {super(id);}

  @EventHandler
  public void event(WorldLoadEvent e) {super.event(e);}
}