package tk.smileyik.luainminecraftbukkit.plugin.exception;

public class LuaFunctionIllegalException extends RuntimeException {

  public LuaFunctionIllegalException(String pluginId, String path) {
    super(String.format(
            "%s所注册的%s不是一个有效的方法",
            pluginId, path
    ));
  }

  public LuaFunctionIllegalException(Exception e) {
    super(e);
  }

  public LuaFunctionIllegalException(String str, Exception e) {
    super(str, e);
  }
}
