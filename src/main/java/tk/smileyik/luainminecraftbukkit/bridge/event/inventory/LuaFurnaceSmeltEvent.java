package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaFurnaceSmeltEvent extends LuaEvent<FurnaceSmeltEvent> {

  public LuaFurnaceSmeltEvent(String id) {super(id);}

  @EventHandler
  public void event(FurnaceSmeltEvent e) {super.event(e);}
}