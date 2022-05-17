package tk.smileyik.luainminecraftbukkit.plugin.event;

import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPluginManager;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaFunctionIllegalException;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaFunctionNotFountException;
import tk.smileyik.luainminecraftbukkit.plugin.exception.LuaPluginNotFountException;

import java.util.Arrays;
import java.util.Objects;

public abstract class LuaEvent <T extends Event> implements Listener {
  private String id;
  private final String[] vars;

  private Object closure;

  public LuaEvent(String id) {
    this.id = id;
    vars = id.split("\\.");
  }

  @EventHandler
  public void event(T e) {
    try {
      if (closure != null) {
        LuaInMinecraftBukkit.getPluginManager().callClosure(vars[0], closure, e);
      } else {
        LuaInMinecraftBukkit.getPluginManager().callClosure(vars, e);
      }
    } catch (LuaFunctionIllegalException |
             LuaFunctionNotFountException |
             LuaPluginNotFountException notFount) {
      notFount.printStackTrace();
      LuaInMinecraftBukkit.debug("取消监听事件: %s", getId());
      LuaPluginManager.getEventRegister().unregisterEvent(getId());
    } catch (Exception ee) {
      if (ee.getMessage().startsWith("attempt to index ? (a nil value)")) {
        LuaInMinecraftBukkit.debug("取消监听事件: %s", getId());
        LuaPluginManager.getEventRegister().unregisterEvent(getId());
      }
      ee.printStackTrace();
    }
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }

  public String getPluginId() {
    return vars[0];
  }

  public void setClosure(Object closure) {
    this.closure = closure;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LuaEvent<?> luaEvent = (LuaEvent<?>) o;
    return Objects.equals(id, luaEvent.id) &&
            Arrays.equals(vars, luaEvent.vars) &&
            Objects.equals(closure, luaEvent.closure);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(id, closure);
    result = 31 * result + Arrays.hashCode(vars);
    return result;
  }
}
