package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaAreaEffectCloudApplyEvent extends LuaEvent<AreaEffectCloudApplyEvent> {

  public LuaAreaEffectCloudApplyEvent(String id) {super(id);}

  @EventHandler
  public void event(AreaEffectCloudApplyEvent e) {super.event(e);}
}