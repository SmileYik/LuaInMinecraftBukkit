package tk.smileyik.luainminecraftbukkit.plugin.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPluginManager;

public abstract class LuaEvent <T extends Event> implements Listener {
  private final String id;
  private final String[] vars;

  public LuaEvent(String id) {
    this.id = id;
    vars = id.split("\\.");
  }

  @EventHandler
  public void event(T e) {
    try {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, e);
    } catch (Exception ee) {
      if (ee.getMessage().startsWith("attempt to index ? (a nil value)")) {
        LuaInMinecraftBukkit.debug("未找到闭包: %s, 取消监听此事件...", getId());
        LuaPluginManager.getEventRegister().unregisterEvent(getId());
      }
      ee.printStackTrace();
    }
  }

  public String getId() {
    return id;
  }

  public String getPluginId() {
    return vars[0];
  }
}
