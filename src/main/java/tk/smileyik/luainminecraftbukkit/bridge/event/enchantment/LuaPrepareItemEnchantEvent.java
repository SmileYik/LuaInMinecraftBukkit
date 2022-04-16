package tk.smileyik.luainminecraftbukkit.bridge.event.enchantment;

import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaPrepareItemEnchantEvent extends LuaEvent<PrepareItemEnchantEvent> {

  public LuaPrepareItemEnchantEvent(String id) {super(id);}

  @EventHandler
  public void event(PrepareItemEnchantEvent e) {super.event(e);}
}