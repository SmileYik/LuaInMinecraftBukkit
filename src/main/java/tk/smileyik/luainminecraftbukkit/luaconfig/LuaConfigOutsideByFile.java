package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;

import java.io.IOException;
import java.nio.file.Path;

public class LuaConfigOutsideByFile extends LuaConfigOutside {
  private final Path path;
  protected LuaConfigOutsideByFile(Path path) {
    this.path = path;
  }

  /**
   * 运行脚本.
   */
  @Override
  public void config() throws IOException, LuaException {
    setGlobal("helper", LuaConfigOutsideHelper.class);
    getEnvironment().LloadFile(path.toRealPath().toString());
    int ret = getEnvironment().pcall(0, 0, 0);
    if (ret != 0) {
      throw new RuntimeException("加载脚本失败." +
              getEnvironment().toString(-1));
    }
    getEnvironment().close();
  }
}
