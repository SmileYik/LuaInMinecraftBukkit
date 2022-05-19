package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaWorldEvent extends LuaEvent<WorldEvent> {

  public LuaWorldEvent(String id) {super(id);}

  @EventHandler
  public void event(WorldEvent e) {super.event(e);}
}