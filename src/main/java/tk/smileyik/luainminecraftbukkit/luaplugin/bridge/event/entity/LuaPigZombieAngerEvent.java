package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PigZombieAngerEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPigZombieAngerEvent extends LuaEvent<PigZombieAngerEvent> {

  public LuaPigZombieAngerEvent(String id) {super(id);}

  @EventHandler
  public void event(PigZombieAngerEvent e) {super.event(e);}
}