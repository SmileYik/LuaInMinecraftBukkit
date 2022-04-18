package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.VillagerReplenishTradeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaVillagerReplenishTradeEvent extends LuaEvent<VillagerReplenishTradeEvent> {

  public LuaVillagerReplenishTradeEvent(String id) {super(id);}

  @EventHandler
  public void event(VillagerReplenishTradeEvent e) {super.event(e);}
}