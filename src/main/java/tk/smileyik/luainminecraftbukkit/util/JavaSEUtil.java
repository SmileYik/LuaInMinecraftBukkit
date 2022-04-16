package tk.smileyik.luainminecraftbukkit.util;

public class JavaSEUtil {
  /**
   * 获取类.
   * @param path 类全路径
   * @return 对应的类.
   * @throws ClassNotFoundException 如果不存在该类则抛出.
   */
  public Class<?> getClazz(String path) throws ClassNotFoundException {
    return Class.forName(path);
  }
}
