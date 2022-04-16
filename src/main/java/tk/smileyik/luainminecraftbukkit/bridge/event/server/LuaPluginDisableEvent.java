package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.PluginDisableEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPluginDisableEvent extends LuaEvent<PluginDisableEvent> {

  public LuaPluginDisableEvent(String id) {super(id);}

  @EventHandler
  public void event(PluginDisableEvent e) {super.event(e);}
}