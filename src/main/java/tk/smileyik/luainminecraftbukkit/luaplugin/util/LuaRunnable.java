package tk.smileyik.luainminecraftbukkit.luaplugin.util;

import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

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
    LuaInMinecraftBukkit.getPluginManager().callClosure(
            vars,
            obj
    );
  }

  public String getId() {
    return id;
  }

  public String getPluginId() {
    return vars[0];
  }
}
