package tk.smileyik.luainminecraftbukkit.plugin.mode.hybrid;

import tk.smileyik.luainminecraftbukkit.plugin.AbstractLuaPluginManager;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPlugin;
import tk.smileyik.luainminecraftbukkit.plugin.mode.inside.LuaPluginManagerInside;
import tk.smileyik.luainminecraftbukkit.plugin.mode.outside.LuaPluginManagerOutside;

import java.util.HashMap;
import java.util.Map;

/**
 * 混合模式, 读取插件元数据中的运行模式进行选择运行模式.
 */
public class LuaPluginManagerHybrid extends AbstractLuaPluginManager {

  private final LuaPluginManagerInside inside;
  private final LuaPluginManagerOutside outside;
  private final Map<String, RunType> plugins;

  public LuaPluginManagerHybrid() {
    inside = new LuaPluginManagerInside();
    outside = new LuaPluginManagerOutside();
    plugins = new HashMap<>();
  }

  /**
   * 通过脚本插件的id来卸载插件
   *
   * @param id 脚本插件的id.
   */
  @Override
  public void disablePlugin(String id) {
    if (plugins.containsKey(id)) {
      RunType runType = plugins.remove(id);
      switch (runType) {
        case Inside:
          inside.disablePlugin(id);
          break;
        case Outside:
          outside.disablePlugin(id);
          break;
      }
    }
  }

  /**
   * 通过LuaPlugin实例去加载一个插件.
   *
   * @param plugin luaplugin实例.
   * @return 如果加载成功则返回true.
   */
  @Override
  public boolean loadPlugin(LuaPlugin plugin) {
    switch (plugin.getRunType()) {
      case Inside:
        plugins.put(plugin.getId(), RunType.Inside);
        return inside.loadPlugin(plugin);
      case Outside:
        plugins.put(plugin.getId(), RunType.Outside);
        return outside.loadPlugin(plugin);
    }
    return false;
  }

  /**
   * 通过给定的路径去获取lua函数闭包.
   *
   * @param vars 从下标0开始依次为插件id, 全局表, 全局函数, 其中全局表可以忽略.
   * @return 返回对应路径下的lua函数闭包.
   */
  @Override
  public Object getClosure(String[] vars) {
    if (plugins.containsKey(vars[0])) {
      switch (plugins.get(vars[0])) {
        case Inside:
          return inside.getClosure(vars);
        case Outside:
          return outside.getClosure(vars);
      }
    }
    return null;
  }

  /**
   * 通过给定的路径去调用lua函数闭包.
   *
   * @param vars 从下标0开始依次为插件id, 全局表, 全局函数, 其中全局表可以忽略.
   */
  @Override
  public void callClosure(String[] vars) {
    if (plugins.containsKey(vars[0])) {
      switch (plugins.get(vars[0])) {
        case Inside:
          inside.callClosure(vars);
          break;
        case Outside:
          outside.callClosure(vars);
          break;
      }
    }
  }

  /**
   * 通过给定的路径与参数去调用lua函数闭包.
   *
   * @param vars 从下标0开始依次为插件id, 全局表, 全局函数, 其中全局表可以忽略.
   * @param obj  要传给函数的参数.
   */
  @Override
  public void callClosure(String[] vars, Object... obj) {
    if (plugins.containsKey(vars[0])) {
      switch (plugins.get(vars[0])) {
        case Inside:
          inside.callClosure(vars, obj);
          break;
        case Outside:
          outside.callClosure(vars, obj);
          break;
      }
    }
  }

  /**
   * 给定插件id与lua插件闭包实例去调用lua闭包.
   *
   * @param id      脚本插件id
   * @param closure lua闭包在java中的实例
   */
  @Override
  public void callClosure(String id, Object closure) {
    if (plugins.containsKey(id)) {
      switch (plugins.get(id)) {
        case Inside:
          inside.callClosure(id, closure);
          break;
        case Outside:
          outside.callClosure(id, closure);
          break;
      }
    }
  }

  /**
   * 给定插件id与lua插件闭包实例去调用lua闭包.
   *
   * @param id      lua插件id
   * @param closure lua函数对象
   * @param obj     要传给lua函数的参数.
   */
  @Override
  public void callClosure(String id, Object closure, Object... obj) {
    if (plugins.containsKey(id)) {
      switch (plugins.get(id)) {
        case Inside:
          inside.callClosure(id, closure, obj);
          break;
        case Outside:
          outside.callClosure(id, closure, obj);
          break;
      }
    }
  }
}
