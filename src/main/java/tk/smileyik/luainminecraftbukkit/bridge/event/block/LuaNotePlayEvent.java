package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.NotePlayEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaNotePlayEvent extends LuaEvent<NotePlayEvent> {

  public LuaNotePlayEvent(String id) {super(id);}

  @EventHandler
  public void event(NotePlayEvent e) {super.event(e);}
}