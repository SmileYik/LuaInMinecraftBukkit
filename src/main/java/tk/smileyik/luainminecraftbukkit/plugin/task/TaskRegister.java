package tk.smileyik.luainminecraftbukkit.plugin.task;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.plugin.LuaPlugin;

import java.util.*;
import java.util.concurrent.Callable;

public class TaskRegister {
  private final BukkitScheduler scheduler;
  private final LuaInMinecraftBukkit plugin;

  private final Map<String, Set<Integer>> timers = new HashMap<>();

  public TaskRegister() {
    plugin = LuaInMinecraftBukkit.getInstance();
    scheduler = plugin.getServer().getScheduler();
  }

  public BukkitTask runTask(LuaPlugin luaPlugin, String functionId) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    });
  }

  public BukkitTask runTask(LuaPlugin luaPlugin, String functionId, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    });
  }

  public BukkitTask runTask(LuaPlugin luaPlugin, Object function) {
    if (function instanceof String) {
      return runTask(luaPlugin, (String) function);
    }
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    });
  }

  public BukkitTask runTask(LuaPlugin luaPlugin, Object function, Object obj) {
    if (function instanceof String) {
      return runTask(luaPlugin, (String) function, obj);
    }
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    });
  }

  public BukkitTask runTaskAsync(LuaPlugin luaPlugin, String functionId) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    });
  }

  public BukkitTask runTaskAsync(LuaPlugin luaPlugin, String functionId, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    });
  }

  public BukkitTask runTaskAsync(LuaPlugin luaPlugin, Object function) {
    if (function instanceof String) {
      return runTaskAsync(luaPlugin, (String) function);
    }
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    });
  }

  public BukkitTask runTaskAsync(LuaPlugin luaPlugin, Object function, Object obj) {
    if (function instanceof String) {
      return runTaskAsync(luaPlugin, (String) function, obj);
    }
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    });
  }

  public BukkitTask runTaskLater(LuaPlugin luaPlugin, String functionId, int delay) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay);
  }

  public BukkitTask runTaskLater(LuaPlugin luaPlugin, String functionId, int delay, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay);
  }

  public BukkitTask runTaskLater(LuaPlugin luaPlugin, Object function, int delay) {
    if (function instanceof String) {
      return runTaskLater(luaPlugin, (String) function, delay);
    }
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    }, delay);
  }

  public BukkitTask runTaskLater(LuaPlugin luaPlugin, Object function, int delay, Object obj) {
    if (function instanceof String) {
      return runTaskLater(luaPlugin, (String) function, delay, obj);
    }
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    }, delay);
  }

  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin, String functionId, int delay) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay);
  }

  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin, String functionId, int delay, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay);
  }

  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin, Object function, int delay) {
    if (function instanceof String) {
      return runTaskLaterAsync(luaPlugin, (String) function, delay);
    }
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    }, delay);
  }

  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin, Object function, int delay, Object obj) {
    if (function instanceof String) {
      return runTaskLaterAsync(luaPlugin, (String) function, delay, obj);
    }
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    }, delay);
  }

  public BukkitTask runTimer(LuaPlugin luaPlugin, String functionId, int delay, int period) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimer(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimer(LuaPlugin luaPlugin, String functionId, int delay, int period, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimer(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimer(LuaPlugin luaPlugin, Object function, int delay, int period) {
    if (function instanceof String) {
      return runTimer(luaPlugin, (String) function, delay, period);
    }
    BukkitTask task = scheduler.runTaskTimer(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimer(LuaPlugin luaPlugin, Object function, int delay, int period, Object obj) {
    if (function instanceof String) {
      return runTimer(luaPlugin, (String) function, delay, period, obj);
    }
    BukkitTask task = scheduler.runTaskTimer(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimerAsync(LuaPlugin luaPlugin, String functionId, int delay, int period) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimerAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimerAsync(LuaPlugin luaPlugin, String functionId, int delay, int period, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimerAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimerAsync(LuaPlugin luaPlugin, Object function, int delay, int period) {
    if (function instanceof String) {
      return runTimerAsync(luaPlugin, (String) function, delay, period);
    }
    BukkitTask task = scheduler.runTaskTimerAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public BukkitTask runTimerAsync(LuaPlugin luaPlugin, Object function, int delay, int period, Object obj) {
    if (function instanceof String) {
      return runTimerAsync(luaPlugin, (String) function, delay, period, obj);
    }
    BukkitTask task = scheduler.runTaskTimerAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  public void cancel(int id) {
    scheduler.cancelTask(id);
    timers.values().forEach(it -> it.remove(id));
  }

  public void cancelAll(LuaPlugin plugin) {
    cancelAll(plugin.getId());
  }

  public void cancelAll(String id) {
    Set<Integer> integers = timers.get(id);
    if (integers != null) {
      integers.forEach(scheduler::cancelTask);
      integers.clear();
    }
  }

  private void addTimer(LuaPlugin luaPlugin, BukkitTask task) {
    if (!timers.containsKey(luaPlugin.getId())) {
      timers.put(luaPlugin.getId(), new HashSet<>());
    }
    timers.get(luaPlugin.getId()).add(task.getTaskId());
  }
}
