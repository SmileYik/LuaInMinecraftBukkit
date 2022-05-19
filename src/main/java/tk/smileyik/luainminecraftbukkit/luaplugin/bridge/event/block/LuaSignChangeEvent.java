package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaSignChangeEvent extends LuaEvent<SignChangeEvent> {

  public LuaSignChangeEvent(String id) {super(id);}

  @EventHandler
  public void event(SignChangeEvent e) {super.event(e);}
}