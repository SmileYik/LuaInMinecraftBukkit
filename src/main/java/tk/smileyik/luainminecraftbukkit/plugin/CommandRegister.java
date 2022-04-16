package tk.smileyik.luainminecraftbukkit.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister {
  private final Map<String, String[]> commandMapper = new HashMap<>();

  public void registerCommand(String command, String id) {
    String pluginId = id.substring(0, id.indexOf("."));
    commandMapper.put(command, id.split("\\."));
  }

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
