package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaFurnaceBurnEvent extends LuaEvent<FurnaceBurnEvent> {

  public LuaFurnaceBurnEvent(String id) {super(id);}

  @EventHandler
  public void event(FurnaceBurnEvent e) {super.event(e);}
}