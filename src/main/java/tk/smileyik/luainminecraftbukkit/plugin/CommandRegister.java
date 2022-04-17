package tk.smileyik.luainminecraftbukkit.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {
  private final Map<String, String[]> commandMapper = new HashMap<>();

  /**
   * 注册一个指令.
   * @param command 要注册的指令.
   * @param id 闭包id.
   */
  public void registerCommand(String command, String id) {
    String pluginId = id.substring(0, id.indexOf("."));
    commandMapper.put(command, id.split("\\."));
  }

  /**
   * 指令分发.
   * @param sender 指令发送者.
   * @param command 指令.
   * @param label 指令.
   * @param args 指令.
   */
  public void dispatch(CommandSender sender, Command command, String label, String[] args) {
    if (args.length >= 1) {
      label = args[0];
      if (commandMapper.containsKey(label)) {
        LuaInMinecraftBukkit.getPluginManager().callClosure(
                commandMapper.get(label),

                LuaValueHelper.toTable(
                        "isPlayer", sender instanceof Player,
                        "sender", sender,
                        "args", LuaValueHelper.asList(args)
                )
        );
      }
    }
  }
}
