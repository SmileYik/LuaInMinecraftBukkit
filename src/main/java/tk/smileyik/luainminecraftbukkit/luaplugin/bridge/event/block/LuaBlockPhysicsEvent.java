package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPhysicsEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaBlockPhysicsEvent extends LuaEvent<BlockPhysicsEvent> {

  public LuaBlockPhysicsEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockPhysicsEvent e) {super.event(e);}
}