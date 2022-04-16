package tk.smileyik.luainminecraftbukkit.bridge.event.enchantment;

import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;

public class LuaEnchantItemEvent extends LuaEvent<EnchantItemEvent> {

  public LuaEnchantItemEvent(String id) {super(id);}

  @EventHandler
  public void event(EnchantItemEvent e) {super.event(e);}
}