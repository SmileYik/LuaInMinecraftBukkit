package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaVillagerCareerChangeEvent extends LuaEvent<VillagerCareerChangeEvent> {

  public LuaVillagerCareerChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(VillagerCareerChangeEvent e) {super.event(e);}
}