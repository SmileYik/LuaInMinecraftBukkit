package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaFoodLevelChangeEvent extends LuaEvent<FoodLevelChangeEvent> {

  public LuaFoodLevelChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(FoodLevelChangeEvent e) {super.event(e);}
}