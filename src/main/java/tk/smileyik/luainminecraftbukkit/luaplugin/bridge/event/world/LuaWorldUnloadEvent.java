package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldUnloadEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaWorldUnloadEvent extends LuaEvent<WorldUnloadEvent> {

  public LuaWorldUnloadEvent(String id) {super(id);}

  @EventHandler
  public void event(WorldUnloadEvent e) {super.event(e);}
}