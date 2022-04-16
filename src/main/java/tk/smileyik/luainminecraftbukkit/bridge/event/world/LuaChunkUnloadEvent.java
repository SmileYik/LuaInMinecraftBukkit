package tk.smileyik.luainminecraftbukkit.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkUnloadEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaChunkUnloadEvent extends LuaEvent<ChunkUnloadEvent> {

  public LuaChunkUnloadEvent(String id) {super(id);}

  @EventHandler
  public void event(ChunkUnloadEvent e) {super.event(e);}
}