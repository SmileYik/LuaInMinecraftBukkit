package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.event.enchantment;

import org.bukkit.event.EventHandler;
import org.bukkit.event.enchantment.EnchantItemEvent;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.LuaEvent;

public class LuaEnchantItemEvent extends LuaEvent<EnchantItemEvent> {

  public LuaEnchantItemEvent(String id) {super(id);}

  @EventHandler
  public void event(EnchantItemEvent e) {super.event(e);}
}