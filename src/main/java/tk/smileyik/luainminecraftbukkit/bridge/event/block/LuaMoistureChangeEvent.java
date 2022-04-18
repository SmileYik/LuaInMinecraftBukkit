package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.MoistureChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaMoistureChangeEvent extends LuaEvent<MoistureChangeEvent> {

  public LuaMoistureChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(MoistureChangeEvent e) {super.event(e);}
}