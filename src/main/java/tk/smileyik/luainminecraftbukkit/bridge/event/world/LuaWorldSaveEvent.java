package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldSaveEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaWorldSaveEvent extends LuaEvent<WorldSaveEvent> {

  public LuaWorldSaveEvent(String id) {super(id);}

  @EventHandler
  public void event(WorldSaveEvent e) {super.event(e);}
}