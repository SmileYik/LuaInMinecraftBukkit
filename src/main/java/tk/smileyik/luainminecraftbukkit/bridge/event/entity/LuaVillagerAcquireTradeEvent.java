package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaVillagerAcquireTradeEvent extends LuaEvent<VillagerAcquireTradeEvent> {

  public LuaVillagerAcquireTradeEvent(String id) {super(id);}

  @EventHandler
  public void event(VillagerAcquireTradeEvent e) {super.event(e);}
}