package tk.smileyik.luainminecraftbukkit.luaconfig.exception;

public class LuaConfigNotClosureException extends RuntimeException {
  public LuaConfigNotClosureException() {
    super("正在尝试运行一个非闭包对象.");
  }
}
