package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaProjectileLaunchEvent extends LuaEvent<ProjectileLaunchEvent> {

  public LuaProjectileLaunchEvent(String id) {super(id);}

  @EventHandler
  public void event(ProjectileLaunchEvent e) {super.event(e);}
}