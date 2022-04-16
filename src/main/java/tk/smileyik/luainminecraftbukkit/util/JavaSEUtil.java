package tk.smileyik.luainminecraftbukkit.util;

public class JavaSEUtil {
  public Class<?> getClazz(String path) throws ClassNotFoundException {
    return Class.forName(path);
  }
}
