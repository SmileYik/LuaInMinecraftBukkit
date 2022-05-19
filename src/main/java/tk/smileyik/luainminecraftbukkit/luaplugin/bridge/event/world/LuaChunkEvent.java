package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.world;

import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaChunkEvent extends LuaEvent<ChunkEvent> {

  public LuaChunkEvent(String id) {super(id);}

  @EventHandler
  public void event(ChunkEvent e) {super.event(e);}
}