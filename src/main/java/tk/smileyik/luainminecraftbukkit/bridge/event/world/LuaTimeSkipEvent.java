package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.TimeSkipEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaTimeSkipEvent extends LuaEvent<TimeSkipEvent> {

  public LuaTimeSkipEvent(String id) {super(id);}

  @EventHandler
  public void event(TimeSkipEvent e) {super.event(e);}
}