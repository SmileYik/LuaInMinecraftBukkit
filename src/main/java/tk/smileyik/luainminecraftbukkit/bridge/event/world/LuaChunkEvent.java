package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaChunkEvent extends LuaEvent<ChunkEvent> {

  public LuaChunkEvent(String id) {super(id);}

  @EventHandler
  public void event(ChunkEvent e) {super.event(e);}
}