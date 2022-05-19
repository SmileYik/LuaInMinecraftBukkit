package tk.smileyik.luainminecraftbukkit.luaconfig;

import java.io.IOException;

public class LuaConfigInsideByScript extends LuaConfigInside {
  private final String script;

  public LuaConfigInsideByScript(String script) {
    this.script = script;
  }

  /**
   * 运行脚本.
   */
  @Override
  public void config() throws IOException {
    getEnvironment().load(script).call();
  }
}
