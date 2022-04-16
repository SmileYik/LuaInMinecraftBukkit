package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaFurnaceExtractEvent extends LuaEvent<FurnaceExtractEvent> {

  public LuaFurnaceExtractEvent(String id) {super(id);}

  @EventHandler
  public void event(FurnaceExtractEvent e) {super.event(e);}
}