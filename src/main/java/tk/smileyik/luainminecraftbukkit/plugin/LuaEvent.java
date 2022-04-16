package tk.smileyik.luainminecraftbukkit.plugin;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

public abstract class LuaEvent <T extends Event> implements Listener {
  private final String id;
  private final String[] vars;

  public LuaEvent(String id) {
    this.id = id;
    vars = id.split("\\.");
  }

  @EventHandler
  public void event(T e) {
    LuaInMinecraftBukkit.debug("正在处理事件: " + getId());
    long time = System.currentTimeMillis();
    LuaInMinecraftBukkit.getPluginManager().callClosure(vars, CoerceJavaToLua.coerce(e));
    time = System.currentTimeMillis() - time;
    System.out.println(getId() + " 事件处理完毕, 耗时: " + time + "ms");
  }

  public String getId() {
    return id;
  }

  public String getPluginId() {
    return vars[0];
  }
}
