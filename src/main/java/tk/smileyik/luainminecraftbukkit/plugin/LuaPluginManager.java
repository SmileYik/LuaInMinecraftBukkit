package tk.smileyik.luainminecraftbukkit.plugin;

import tk.smileyik.luainminecraftbukkit.plugin.command.CommandRegister;
import tk.smileyik.luainminecraftbukkit.plugin.event.EventRegister;
import tk.smileyik.luainminecraftbukkit.plugin.task.TaskRegister;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public interface LuaPluginManager {

  static final String PLUGIN_MAIN = "main.lua";
  static final String PLUGIN_META = "lua_plugin.yml";
  static final String ENABLE_FUNCTION = "onEnable";
  static final String DISABLE_FUNCTION = "onDisable";
  static final String CONFIG_PATH = "config";
  static final EventRegister EVENT_REGISTER = new EventRegister();
  static final TaskRegister TASK_REGISTER = new TaskRegister();
  static final CommandRegister COMMAND_REGISTER = new CommandRegister();

  static CommandRegister getCommandRegister() {
    return COMMAND_REGISTER;
  }

  static EventRegister getEventRegister() {
    return EVENT_REGISTER;
  }

  static TaskRegister getTaskRegister() {
    return TASK_REGISTER;
  }

  void disablePlugin(String id);

  void disableAllPlugins();

  boolean reloadPlugin(String id) throws IOException;

  void loadPlugins();

  void loadPlugins(LinkedList<File> queue);

  void loadPlugin(String pluginDir);

  boolean loadPlugin(LuaPlugin plugin);

  Object getClosure(String[] vars);

  void callClosure(String[] vars);

  void callClosure(String[] vars, Object ... obj);

  void callClosure(String id, Object closure);

  /**
   * 调用lua函数.
   * @param id      lua插件id
   * @param closure lua函数对象
   * @param obj     参数.
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
