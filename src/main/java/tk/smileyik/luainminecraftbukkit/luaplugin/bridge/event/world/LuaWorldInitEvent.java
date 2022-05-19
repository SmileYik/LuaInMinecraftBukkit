package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldInitEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaWorldInitEvent extends LuaEvent<WorldInitEvent> {

  public LuaWorldInitEvent(String id) {super(id);}

  @EventHandler
  public void event(WorldInitEvent e) {super.event(e);}
}