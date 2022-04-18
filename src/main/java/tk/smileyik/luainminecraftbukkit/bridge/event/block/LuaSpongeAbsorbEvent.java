package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SpongeAbsorbEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaSpongeAbsorbEvent extends LuaEvent<SpongeAbsorbEvent> {

  public LuaSpongeAbsorbEvent(String id) {super(id);}

  @EventHandler
  public void event(SpongeAbsorbEvent e) {super.event(e);}
}