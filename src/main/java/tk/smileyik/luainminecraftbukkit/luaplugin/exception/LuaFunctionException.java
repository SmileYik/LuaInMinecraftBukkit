package tk.smileyik.luainminecraftbukkit.luaplugin.exception;

import org.keplerproject.luajava.LuaException;

public class LuaFunctionException extends LuaException {
  public LuaFunctionException(Exception e, String id, String path, String reason) {
    super(String.format(
            "运行%s脚本中的%s函数发生了错误: %s",
            id, path, reason
    ), e);
  }
}
