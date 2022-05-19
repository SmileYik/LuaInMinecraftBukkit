package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.FluidLevelChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaFluidLevelChangeEvent extends LuaEvent<FluidLevelChangeEvent> {

  public LuaFluidLevelChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(FluidLevelChangeEvent e) {super.event(e);}
}