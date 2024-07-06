package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;
import tk.smileyik.luainminecraftbukkit.exception.FailedLoadLuaScriptException;

import java.io.IOException;

public class LuaConfigOutsideByScript extends LuaConfigOutside {
  private final String script;
  public LuaConfigOutsideByScript(String script) {
    this.script = script;
  }

  /**
   * 运行脚本.
   */
  @Override
  public void config() throws IOException, LuaException {
    setGlobal("helper", LuaConfigOutsideHelper.class);
    int ret = getEnvironment().LloadString(script);
    if (ret != 0) {
      throw new FailedLoadLuaScriptException(
              String.format("returned code %d, because: %s",
                      ret, getEnvironment().toString(-1)));
    }
    ret = getEnvironment().pcall(0, 0, 0);
    if (ret != 0) {
      throw new RuntimeException("加载脚本失败." +
              getEnvironment().toString(-1));
    }
  }
}
