package tk.smileyik.luainminecraftbukkit.bridge.event.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.TradeSelectEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaTradeSelectEvent extends LuaEvent<TradeSelectEvent> {

  public LuaTradeSelectEvent(String id) {super(id);}

  @EventHandler
  public void event(TradeSelectEvent e) {super.event(e);}
}