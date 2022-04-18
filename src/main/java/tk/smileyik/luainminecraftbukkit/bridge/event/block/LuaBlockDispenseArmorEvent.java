package tk.smileyik.luainminecraftbukkit.bridge.event.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaBlockDispenseArmorEvent extends LuaEvent<BlockDispenseArmorEvent> {

  public LuaBlockDispenseArmorEvent(String id) {super(id);}

  @EventHandler
  public void event(BlockDispenseArmorEvent e) {super.event(e);}
}