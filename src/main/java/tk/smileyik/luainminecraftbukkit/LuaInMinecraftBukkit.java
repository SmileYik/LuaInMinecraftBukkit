package tk.smileyik.luainminecraftbukkit;

import com.google.common.io.Files;
import org.bstats.bukkit.Metrics;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPluginManager;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class LuaInMinecraftBukkit extends JavaPlugin {
  private static LuaInMinecraftBukkit instance;
  private LuaPluginManager pluginManager;
  private boolean debug = false;

  /**
   * 是否需要打开Debug.
   */
  private void check() {
    debug = new File(getDataFolder(), "debug").isFile();
  }

  @Override
  public void onEnable() {
    instance = this;
    check();
    pluginManager = new LuaPluginManager();
    pluginManager.loadPlugins();
    Metrics metrics = new Metrics(this, 14952);
  }

  @Override
  public void onDisable() {
    pluginManager.disableAllPlugins();
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (label.equalsIgnoreCase("lua")) {
      if (!sender.isOp()) {
        return false;
      }
      if (args.length == 2) {
        if (args[0].equalsIgnoreCase("reload")) {
          try {
            sender.sendMessage("重新加载" + args[1] + "脚本结果: " + getPluginManager().reloadPlugin(args[1]));
          } catch (IOException e) {
            sender.sendMessage("重新加载" + args[1] + "脚本失败");
            throw new RuntimeException(e);
          }
          return true;
        } else if (args[0].equalsIgnoreCase("load")) {
          getPluginManager().loadPlugin(args[1]);
          sender.sendMessage("尝试加载脚本完毕.");
          return true;
        } else if (args[0].equalsIgnoreCase("unload")) {
          getPluginManager().disablePlugin(args[1]);
          sender.sendMessage("卸载脚本: " + args[1]);
          return true;
        } else if (args[0].equalsIgnoreCase("info")) {
          sender.sendMessage(getPluginManager().getPluginInfo(args[1]));
          return true;
        }
      }
      sender.sendMessage(new String[]{
              "/lua reload \t 重载插件",
              "/lua reload <脚本id> \t 重载脚本",
              "/lua load <文件夹名> \t 加载脚本",
              "/lua unload <脚本id> \t 卸载脚本",
              "/lua info <脚本id> \t 显示脚本信息"
      });
      return true;
    } else if (label.equalsIgnoreCase("luap")) {
      LuaPluginManager.getCommandRegister().dispatch(sender, command, label, args);
      return true;
    }
    return super.onCommand(sender, command, label, args);
  }

  public static void writeToFile(String str, String fileName) {
    File file = new File(instance.getDataFolder(), fileName);
    file.getParentFile().mkdirs();
    try {
      Files.write(str.getBytes(StandardCharsets.UTF_8), file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static LuaInMinecraftBukkit getInstance() {
    return instance;
  }

  /**
   * debug 日志.
   * @param message 消息, 与 String.format 方法一样.
   * @param obj 参数
   */
  public static void debug(String message, Object ... obj) {
    if (instance.debug) {
      instance.getLogger().info(String.format(message, obj));
    }
  }

  /**
   * 输出日志.
   * @param message 消息, 与 String.format 方法一样.
   * @param obj 参数
   */
  public static void log(String message, Object ... obj) {
    instance.getLogger().info(String.format(message, obj));
  }

  public static LuaPluginManager getPluginManager() {
    return instance.pluginManager;
  }

  public static boolean isDebug() {
    return instance.debug;
  }
}
