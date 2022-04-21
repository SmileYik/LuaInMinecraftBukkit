package tk.smileyik.luainminecraftbukkit.plugin.util;

import org.bukkit.plugin.Plugin;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.mode.outside.LuaPluginManagerOutside;

public class LuaPluginHelper {
  /**
   * 指定脚本插件是否加载.
   * @param id 脚本插件id
   * @return 如果已经加载则返回true.
   */
  public static boolean isLoadPlugin(String id) {
    return LuaInMinecraftBukkit.getPluginManager().isLoadPlugin(id);
  }

  /**
   * 以指定id对应的函数为run方法主体创建一个Runnable子类实例
   * @param id 函数路径
   * @return LuaRunnable实例
   */
  public static LuaRunnable newLuaRunnable(String id) {
    return new LuaRunnable(id);
  }

  /**
   * 以指定id对应的函数为run方法主体创建一个Runnable子类实例
   * @param id 函数路径
   * @param obj 带入的参数.
   * @return LuaRunnable实例
   */
  public static LuaRunnable newLuaRunnable(String id, Object obj) {
    return new LuaRunnable(id, obj);
  }

  /**
   * 获取本插件实例对象.
   * @return 本插件的实例对象.
   */
  public static Plugin getPlugin() {
    return LuaInMinecraftBukkit.getInstance();
  }

  /**
   * 通过全类名去获取java类类型.
   * @param name 全类名
   * @return 如果类存在则返回对应的类
   * @throws ClassNotFoundException 当找不到指定路径的类则抛出.
   */
  public static Class<?> getClass(String name) throws ClassNotFoundException {
    return Class.forName(name);
  }

  /**
   * 插件是否在Native模式下运行.
   * @return 如果是在Native模式下运行则返回true.
   */
  public static boolean isNativeMode() {
    return LuaInMinecraftBukkit.getPluginManager() instanceof LuaPluginManagerOutside;
  }
}
