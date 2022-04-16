package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaFoodLevelChangeEvent extends LuaEvent<FoodLevelChangeEvent> {

  public LuaFoodLevelChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(FoodLevelChangeEvent e) {super.event(e);}
}