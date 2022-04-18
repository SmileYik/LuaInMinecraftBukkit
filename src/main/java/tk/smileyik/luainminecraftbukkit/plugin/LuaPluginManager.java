package tk.smileyik.luainminecraftbukkit.plugin;

import tk.smileyik.luainminecraftbukkit.plugin.command.CommandRegister;
import tk.smileyik.luainminecraftbukkit.plugin.event.EventRegister;
import tk.smileyik.luainminecraftbukkit.plugin.inside.LuaPluginManagerInside;

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

  static final CommandRegister COMMAND_REGISTER = new CommandRegister();

  static CommandRegister getCommandRegister() {
    return LuaPluginManagerInside.COMMAND_REGISTER;
  }

  static EventRegister getEventRegister() {
    return LuaPluginManagerInside.EVENT_REGISTER;
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

  boolean isLoadPlugin(String id);

  String getPluginInfo(String id);
}
