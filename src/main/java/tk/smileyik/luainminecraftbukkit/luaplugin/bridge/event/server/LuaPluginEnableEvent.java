package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.PluginEnableEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPluginEnableEvent extends LuaEvent<PluginEnableEvent> {

  public LuaPluginEnableEvent(String id) {super(id);}

  @EventHandler
  public void event(PluginEnableEvent e) {super.event(e);}
}