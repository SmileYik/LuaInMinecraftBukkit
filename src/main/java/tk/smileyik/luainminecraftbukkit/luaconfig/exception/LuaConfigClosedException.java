package tk.smileyik.luainminecraftbukkit.luaconfig.exception;

public class LuaConfigClosedException extends RuntimeException {
  public LuaConfigClosedException() {
    super("此LuaConfig已经关闭!");
  }
}
