package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;

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
    getEnvironment().LloadString(script);
    int ret = getEnvironment().pcall(0, 0, 0);
    if (ret != 0) {
      throw new RuntimeException("加载脚本失败." +
              getEnvironment().toString(-1));
    }
    getEnvironment().close();
  }
}
