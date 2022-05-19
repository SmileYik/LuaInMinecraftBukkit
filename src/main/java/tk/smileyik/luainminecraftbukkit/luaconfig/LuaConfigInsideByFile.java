package tk.smileyik.luainminecraftbukkit.luaconfig;

import java.io.IOException;
import java.nio.file.Path;

public class LuaConfigInsideByFile extends LuaConfigInside {

  private final Path path;

  public LuaConfigInsideByFile(Path path) {
    super();
    this.path = path;
  }

  /**
   * 运行脚本.
   */
  @Override
  public void config() throws IOException {
    getEnvironment().loadfile(path.toRealPath().toString()).call();
  }
}
