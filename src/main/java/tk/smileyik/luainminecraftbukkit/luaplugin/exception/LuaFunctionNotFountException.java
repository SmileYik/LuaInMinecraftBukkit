package tk.smileyik.luainminecraftbukkit.luaplugin.exception;

public class LuaFunctionNotFountException extends RuntimeException {
  public LuaFunctionNotFountException(String pluginId, String path) {
    super(String.format(
            "脚本插件%s中未发现方法%s",
            pluginId, path
    ));
  }

  public LuaFunctionNotFountException(String pluginId,
                                      String path, Exception e) {
    super(String.format(
            "脚本插件%s中未发现方法%s",
            pluginId, path
    ), e);
  }
}
