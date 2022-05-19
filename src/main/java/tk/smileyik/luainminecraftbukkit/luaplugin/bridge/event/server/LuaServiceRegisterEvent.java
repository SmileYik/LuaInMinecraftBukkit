package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServiceRegisterEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaServiceRegisterEvent extends LuaEvent<ServiceRegisterEvent> {

  public LuaServiceRegisterEvent(String id) {super(id);}

  @EventHandler
  public void event(ServiceRegisterEvent e) {super.event(e);}
}