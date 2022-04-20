package tk.smileyik.luainminecraftbukkit.plugin.exception;

public class LuaFunctionRuntimeException extends RuntimeException {
  public LuaFunctionRuntimeException(String id, String path, String reason) {
    super(String.format(
            "运行%s脚本中的%s函数发生了错误: %s",
            id, path, reason
    ));
  }
}
