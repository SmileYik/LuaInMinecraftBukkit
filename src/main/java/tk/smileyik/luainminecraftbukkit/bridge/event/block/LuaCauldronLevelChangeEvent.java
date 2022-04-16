package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.CauldronLevelChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaCauldronLevelChangeEvent extends LuaEvent<CauldronLevelChangeEvent> {

  public LuaCauldronLevelChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(CauldronLevelChangeEvent e) {super.event(e);}
}