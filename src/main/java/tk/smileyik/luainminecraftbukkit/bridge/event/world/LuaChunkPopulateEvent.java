package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkPopulateEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaChunkPopulateEvent extends LuaEvent<ChunkPopulateEvent> {

  public LuaChunkPopulateEvent(String id) {super(id);}

  @EventHandler
  public void event(ChunkPopulateEvent e) {super.event(e);}
}