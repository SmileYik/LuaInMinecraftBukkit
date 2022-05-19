package tk.smileyik.luainminecraftbukkit.luaplugin.mode.outside;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class NativeLuaLoader {
  private static boolean loaded = false;
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

  public static boolean isLoaded() {
    return loaded;
  }

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
    }
    loaded = true;
  }

  private static void storeLib(String from, File to) throws IOException {
    try (BufferedInputStream bis =
                 new BufferedInputStream(Objects.requireNonNull(NativeLuaLoader.class.getResourceAsStream(from)));
         BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(to.toPath()))) {
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
