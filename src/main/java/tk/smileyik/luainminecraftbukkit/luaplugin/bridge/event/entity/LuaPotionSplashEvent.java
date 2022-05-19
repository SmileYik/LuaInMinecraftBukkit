package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PotionSplashEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPotionSplashEvent extends LuaEvent<PotionSplashEvent> {

  public LuaPotionSplashEvent(String id) {super(id);}

  @EventHandler
  public void event(PotionSplashEvent e) {super.event(e);}
}