package tk.smileyik.luainminecraftbukkit.luaplugin;

import tk.smileyik.luainminecraftbukkit.luaplugin.command.CommandRegister;
import tk.smileyik.luainminecraftbukkit.luaplugin.event.EventRegister;
import tk.smileyik.luainminecraftbukkit.luaplugin.task.TaskRegister;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public interface LuaPluginManager {

  /**
   * 首次读取的脚本文件.
   */
  static final String PLUGIN_MAIN = "main.lua";
  /**
   * 插件的元数据文件存放在.
   */
  static final String PLUGIN_META = "lua_plugin.yml";
  /**
   * 插件启用时调用的方法名.
   */
  static final String ENABLE_FUNCTION = "onEnable";
  /**
   * 插件卸载时调用的函数名.
   */
  static final String DISABLE_FUNCTION = "onDisable";
  /**
   * 插件配置文件的子文件夹名.
   */
  static final String CONFIG_PATH = "config";
  static final EventRegister EVENT_REGISTER = new EventRegister();
  static final TaskRegister TASK_REGISTER = new TaskRegister();
  static final CommandRegister COMMAND_REGISTER = new CommandRegister();

  /**
   * 获取命令注册器.
   * @return 命令注册器.
   */
  static CommandRegister getCommandRegister() {
    return COMMAND_REGISTER;
  }

  /**
   * 获取事件注册器.
   * @return 事件注册器.
   */
  static EventRegister getEventRegister() {
    return EVENT_REGISTER;
  }

  /**
   * 获取任务注册器.
   * @return 任务注册器.
   */
  static TaskRegister getTaskRegister() {
    return TASK_REGISTER;
  }

  /**
   * 通过脚本插件的id来卸载插件
   * @param id 脚本插件的id.
   */
  void disablePlugin(String id);

  /**
   * 卸载当前加载的所有脚本插件.
   */
  void disableAllPlugins();

  /**
   * 通过脚本插件id重新加载插件.
   * @param id 脚本插件id
   * @return 如果重新加载成功则返回true.
   * @throws IOException 当加载时没有找到对应的插件路径则抛出
   */
  boolean reloadPlugin(String id) throws IOException;

  /**
   * 加载plugins下的所有插件.
   */
  void loadPlugins();

  /**
   * 接受一个带有插件目录路径的队列, 并加载队列中的所有插件.
   * @param queue 带有插件目录路径的队列.
   */
  void loadPlugins(LinkedList<File> queue);

  /**
   * 通过插件目录名, 加载一个位于plugins目录下的插件.
   * @param pluginDir plugins目录下的插件目录名.
   */
  void loadPlugin(String pluginDir);

  /**
   * 通过LuaPlugin实例去加载一个插件.
   * @param plugin luaplugin实例.
   * @return 如果加载成功则返回true.
   */
  boolean loadPlugin(LuaPlugin plugin);

  /**
   * 通过给定的路径去获取lua函数闭包.
   * @param vars 从下标0开始依次为插件id, 全局表, 全局函数, 其中全局表可以忽略.
   * @return 返回对应路径下的lua函数闭包.
   */
  Object getClosure(String[] vars);

  /**
   * 通过给定的路径去调用lua函数闭包.
   * @param vars 从下标0开始依次为插件id, 全局表, 全局函数, 其中全局表可以忽略.
   */
  void callClosure(String[] vars);

  /**
   * 通过给定的路径与参数去调用lua函数闭包.
   * @param vars 从下标0开始依次为插件id, 全局表, 全局函数, 其中全局表可以忽略.
   * @param obj 要传给函数的参数.
   */
  void callClosure(String[] vars, Object ... obj);

  /**
   * 给定插件id与lua插件闭包实例去调用lua闭包.
   * @param id      脚本插件id
   * @param closure lua闭包在java中的实例
   */
  void callClosure(String id, Object closure);

  /**
   * 给定插件id与lua插件闭包实例去调用lua闭包.
   * @param id      lua插件id
   * @param closure lua函数对象
   * @param obj     要传给lua函数的参数.
   */
  void callClosure(String id, Object closure, Object ... obj);

  /**
   * 判断某个脚本插件是否已经加载.
   * @param id 脚本插件id.
   * @return   如果为true则代表该脚本插件已经被加载.
   */
  boolean isLoadPlugin(String id);

  /**
   * 获取脚本插件信息.
   * @param id 脚本插件id
   * @return 脚本插件信息.
   */
  String getPluginInfo(String id);
}
