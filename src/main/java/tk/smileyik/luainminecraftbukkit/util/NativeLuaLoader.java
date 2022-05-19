package tk.smileyik.luainminecraftbukkit.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class NativeLuaLoader {
  private enum Os {
    WIN(0, "libs/win"),
    LINUX(1, "libs/linux"),
    OTHER(2, "");

    private final int index;
    private final String innerPath;

    Os(int index, String innerPath) {
      this.index = index;
      this.innerPath = innerPath;
    }

    public int getIndex() {
      return index;
    }

    public String getInnerPath() {
      return innerPath;
    }
  }

  private static final String[][] LIB_LOAD_ORDER = {
          {
                  "lua.dll",
                  "luajava.dll"
          },
          {
                  "liblua.so",
                  "libluajava.so"
          }
  };

  private static final Os OS;

  static {
    String osString = System.getProperty("os.name").toLowerCase();
    if (osString.contains("win")) {
      OS = Os.WIN;
    } else if (osString.contains("linux")) {
      OS = Os.LINUX;
    } else {
      OS = Os.OTHER;
    }
  }

  /**
   * 加载动态链接库.
   * @param baseDir 动态链接库所在的(将要被放置的)文件夹.
   * @throws IOException 如果加载出来有问题的话.
   */
  public static void initNativeLua(File baseDir) throws IOException {
    if (Os.OTHER == OS) {
      throw new RuntimeException("Native lua 模式不适于当前系统.");
    }
    for (String fileName : LIB_LOAD_ORDER[OS.getIndex()]) {
      File libPath = new File(baseDir, fileName);
      if (!libPath.exists()) {
        storeLib("/" + OS.getInnerPath() + "/" + fileName, libPath);
      }
      System.load(libPath.getCanonicalPath());
      /*
       * 对于已经加载过一次的服务器, 在服务器中输入 reload 指令
       * 其会导致已经加载的插件的类加载器与新加载的同个插件的类加
       * 载器不同. 因为安全关系, JVM并不会允许跨类加载器调用其中
       * 已经加载的动态链接库. 所以对于要使用Native模式的服务器,
       * 尽量不要使用 reload 指令去重新加载插件, 应该重启服务器
       * 来达到重新加载插件的目的.
       */
    }
  }

  private static void storeLib(String from, File to) throws IOException {
    try (
            BufferedInputStream bis =
                 new BufferedInputStream(Objects.requireNonNull(
                         NativeLuaLoader.class.getResourceAsStream(from)));
            BufferedOutputStream bos =
                    new BufferedOutputStream(
                         Files.newOutputStream(to.toPath()))) {
      byte[] bytes = new byte[8192];
      int len;
      while ((len = bis.read(bytes)) != -1) {
        bos.write(bytes, 0, len);
      }
      bos.flush();
    } catch (IOException e) {
      throw new IOException("无法导出依赖库...", e);
    }
  }
}
