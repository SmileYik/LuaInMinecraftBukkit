package tk.smileyik.luainminecraftbukkit.luaplugin.exception;

public class LuaPluginNotFountException extends RuntimeException {
  public LuaPluginNotFountException(String id) {
    super(String.format("not found lua plugin: %s", id));
  }
}
