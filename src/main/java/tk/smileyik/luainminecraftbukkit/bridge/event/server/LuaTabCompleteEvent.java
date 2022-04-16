package tk.smileyik.luainminecraftbukkit.bridge.event.server;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.TabCompleteEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaTabCompleteEvent extends LuaEvent<TabCompleteEvent> {

  public LuaTabCompleteEvent(String id) {super(id);}

  @EventHandler
  public void event(TabCompleteEvent e) {super.event(e);}
}