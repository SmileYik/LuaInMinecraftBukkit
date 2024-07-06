package tk.smileyik.luainminecraftbukkit.luaplugin.util;

import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.luaplugin.exception.LuaFunctionException;

public class LuaRunnable implements Runnable {
  private final String id;
  private final String[] vars;
  private Object obj;

  public LuaRunnable(String id) {
    this.id = id;
    vars = id.split("\\.");
  }

  public LuaRunnable(String id, Object obj) {
    this.id = id;
    vars = id.split("\\.");
    this.obj = obj;
  }

  @Override
  public void run() {
      try {
          LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
      } catch (LuaFunctionException e) {
          throw new RuntimeException(e);
      }
  }

  public String getId() {
    return id;
  }

  public String getPluginId() {
    return vars[0];
  }
}
