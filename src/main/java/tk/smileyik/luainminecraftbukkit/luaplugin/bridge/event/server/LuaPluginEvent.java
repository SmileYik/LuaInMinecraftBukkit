package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.PluginEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaPluginEvent extends LuaEvent<PluginEvent> {

  public LuaPluginEvent(String id) {super(id);}

  @EventHandler
  public void event(PluginEvent e) {super.event(e);}
}