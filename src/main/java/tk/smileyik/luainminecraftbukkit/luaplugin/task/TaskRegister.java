package tk.smileyik.luainminecraftbukkit.luaplugin.task;

import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.luaplugin.LuaPlugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TaskRegister {
  private final BukkitScheduler scheduler;
  private final LuaInMinecraftBukkit plugin;

  private final Map<String, Set<Integer>> timers = new HashMap<>();

  public TaskRegister() {
    plugin = LuaInMinecraftBukkit.getInstance();
    scheduler = plugin.getServer().getScheduler();
  }

  /**
   * 在服务器下一刻运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTask(LuaPlugin luaPlugin, String functionId) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    });
  }

  /**
   * 在服务器下一刻运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTask(LuaPlugin luaPlugin, String functionId, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    });
  }

  /**
   * 在服务器下一刻运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTask(LuaPlugin luaPlugin, Object function) {
    if (function instanceof String) {
      return runTask(luaPlugin, (String) function);
    }
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    });
  }

  /**
   * 在服务器下一刻运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTask(LuaPlugin luaPlugin, Object function, Object obj) {
    if (function instanceof String) {
      return runTask(luaPlugin, (String) function, obj);
    }
    return scheduler.runTask(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    });
  }

  /**
   * 运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskAsync(LuaPlugin luaPlugin, String functionId) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    });
  }

  /**
   * 运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskAsync(LuaPlugin luaPlugin,
                                 String functionId, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    });
  }

  /**
   * 运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskAsync(LuaPlugin luaPlugin, Object function) {
    if (function instanceof String) {
      return runTaskAsync(luaPlugin, (String) function);
    }
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    });
  }

  /**
   * 运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskAsync(LuaPlugin luaPlugin,
                                 Object function, Object obj) {
    if (function instanceof String) {
      return runTaskAsync(luaPlugin, (String) function, obj);
    }
    return scheduler.runTaskAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    });
  }

  /**
   * 延迟运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLater(LuaPlugin luaPlugin,
                                 String functionId, int delay) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay);
  }

  /**
   * 延迟运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLater(LuaPlugin luaPlugin,
                                 String functionId, int delay, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay);
  }

  /**
   * 延迟运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLater(LuaPlugin luaPlugin,
                                 Object function, int delay) {
    if (function instanceof String) {
      return runTaskLater(luaPlugin, (String) function, delay);
    }
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    }, delay);
  }

  /**
   * 延迟运行一个任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLater(LuaPlugin luaPlugin,
                                 Object function, int delay, Object obj) {
    if (function instanceof String) {
      return runTaskLater(luaPlugin, (String) function, delay, obj);
    }
    return scheduler.runTaskLater(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    }, delay);
  }

  /**
   * 延迟运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin,
                                      String functionId, int delay) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay);
  }

  /**
   * 延迟运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin,
                                      String functionId, int delay, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay);
  }

  /**
   * 延迟运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin,
                                      Object function, int delay) {
    if (function instanceof String) {
      return runTaskLaterAsync(luaPlugin, (String) function, delay);
    }
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function);
    }, delay);
  }

  /**
   * 延迟运行一个异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTaskLaterAsync(LuaPlugin luaPlugin,
                                      Object function, int delay, Object obj) {
    if (function instanceof String) {
      return runTaskLaterAsync(luaPlugin, (String) function, delay, obj);
    }
    return scheduler.runTaskLaterAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager()
              .callClosure(luaPlugin.getId(), function, obj);
    }, delay);
  }

  /**
   * 运行一个重复运行的任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimer(LuaPlugin luaPlugin,
                             String functionId, int delay, int period) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimer(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  /**
   * 运行一个重复运行的任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimer(LuaPlugin luaPlugin, String functionId,
                             int delay, int period, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimer(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  /**
   * 运行一个重复运行的任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimer(LuaPlugin luaPlugin,
                             Object function, int delay, int period) {
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

  /**
   * 运行一个重复运行的任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimer(LuaPlugin luaPlugin, Object function,
                             int delay, int period, Object obj) {
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

  /**
   * 运行一个重复运行的任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimerAsync(LuaPlugin luaPlugin,
                                  String functionId, int delay, int period) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimerAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  /**
   * 运行一个重复运行的异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param functionId 函数id.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimerAsync(LuaPlugin luaPlugin, String functionId,
                                  int delay, int period, Object obj) {
    functionId = String.format("%s.%s", luaPlugin.getId(), functionId);
    String[] vars = functionId.split("\\.");
    BukkitTask task = scheduler.runTaskTimerAsynchronously(plugin, () -> {
      LuaInMinecraftBukkit.getPluginManager().callClosure(vars, obj);
    }, delay, period);
    addTimer(luaPlugin, task);
    return task;
  }

  /**
   * 运行一个重复运行的异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimerAsync(LuaPlugin luaPlugin,
                                  Object function, int delay, int period) {
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

  /**
   * 运行一个重复运行的异步任务.
   * @param luaPlugin  脚本插件实例.
   * @param function   脚本函数.
   * @param delay      延迟刻数.
   * @param period     重复间隔刻数.
   * @param obj        运行时要给函数传入的参数.
   * @return 一个包含任务id的BukkitTask.
   */
  public BukkitTask runTimerAsync(LuaPlugin luaPlugin, Object function,
                                  int delay, int period, Object obj) {
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

  /**
   * 通过BukkitTask的id去取消一个任务.
   * @param id BukkitTask中的id.
   */
  public void cancel(int id) {
    scheduler.cancelTask(id);
    timers.values().forEach(it -> it.remove(id));
  }

  /**
   * 取消一个脚本插件中的所有的任务.
   * @param plugin 脚本插件实例.
   */
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
