package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkLoadEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaChunkLoadEvent extends LuaEvent<ChunkLoadEvent> {

  public LuaChunkLoadEvent(String id) {super(id);}

  @EventHandler
  public void event(ChunkLoadEvent e) {super.event(e);}
}