package tk.smileyik.luainminecraftbukkit.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PotionSplashEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPotionSplashEvent extends LuaEvent<PotionSplashEvent> {

  public LuaPotionSplashEvent(String id) {super(id);}

  @EventHandler
  public void event(PotionSplashEvent e) {super.event(e);}
}