package tk.smileyik.luainminecraftbukkit.bridge.event.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRecipeDiscoverEvent;
import tk.smileyik.luainminecraftbukkit.plugin.event.LuaEvent;

public class LuaPlayerRecipeDiscoverEvent extends LuaEvent<PlayerRecipeDiscoverEvent> {

  public LuaPlayerRecipeDiscoverEvent(String id) {super(id);}

  @EventHandler
  public void event(PlayerRecipeDiscoverEvent e) {super.event(e);}
}