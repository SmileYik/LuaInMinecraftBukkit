package tk.smileyik.luainminecraftbukkit.plugin;

import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

public class LuaRunnable implements Runnable {
  private final String id;
  private final String[] vars;

  public LuaRunnable(String id) {
    this.id = id;
    vars = id.split("\\.");
  }

  public static LuaRunnable newLuaRunnable(String id) {
    return new LuaRunnable(id);
  }

  @Override
  public void run() {
    LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
  }

  public String getId() {
    return id;
  }

  public String getPluginId() {
    return vars[0];
  }
}
