package tk.smileyik.luainminecraftbukkit.luaplugin.event;

import org.bukkit.Bukkit;
import org.bukkit.event.*;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.luaplugin.LuaPlugin;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.*;

public class EventRegister {
  private static final Map<String,
          List<LuaEvent<? extends Event>>> events = new HashMap<>();
  private static final Properties EVENT_MAPPER = new Properties();
  public static final EventPriority[] PRIORITIES = {
          EventPriority.LOWEST,
          EventPriority.LOW,
          EventPriority.NORMAL,
          EventPriority.HIGH,
          EventPriority.HIGHEST,
          EventPriority.MONITOR
  };

  static {
    // 加载事件名与全类名映射
    try {
      EVENT_MAPPER.load(
              EventRegister.class
                      .getResourceAsStream("/events.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * 注册事件.
   * @param listener 监听器
   * @param priority 优先级, 范围为[0, 5], 不再此区间内则为正常默认等级.
   */
  private void registerEvent(LuaEvent<? extends Event> listener, int priority) {
    if (priority >= 0 && priority <= 5 && priority != 2) {
      try {
        Method[] methods = listener.getClass().getDeclaredMethods();
        EventHandler handler = null;
        for (Method method : methods) {
          if (method.getName().equals("event")) {
            handler = method.getDeclaredAnnotation(EventHandler.class);
          }
        }
        if (handler == null) {
          methods = listener.getClass().getMethods();
          for (Method method : methods) {
            if (method.getName().equals("event")) {
              handler = method.getDeclaredAnnotation(EventHandler.class);
            }
          }
        }

        if (handler != null) {
          InvocationHandler invocationHandler =
                  Proxy.getInvocationHandler(handler);
          Field memberValues =
                  invocationHandler.getClass()
                          .getDeclaredField("memberValues");
          memberValues.setAccessible(true);
          ((Map) memberValues.get(invocationHandler))
                  .put("priority", PRIORITIES[priority]);
          LuaInMinecraftBukkit.debug(
                  "注册事件优先级: %s; 闭包: %s",
                  handler.priority(),
                  listener.getId()
          );
        }
      } catch (Exception e) {
        // 恢复默认优先级
      }
    }
    if (!events.containsKey(listener.getPluginId())) {
      events.put(listener.getPluginId(), new ArrayList<>());
    }
    events.get(listener.getPluginId()).add(listener);
    Bukkit.getServer().getPluginManager().registerEvents(
            listener, LuaInMinecraftBukkit.getInstance());
  }

  /**
   * 注册监听事件.
   * @param event 要注册的事件.
   * @param id 闭包id
   * @param priority 优先级, 范围为[0, 5], 不再此区间内则为正常默认等级.
   */
  @Deprecated
  public void registerListener(String event, String id, int priority) {
    register(event, id, priority);
    LuaInMinecraftBukkit.log(
            "eventRegister:registerListener 即将被弃用, " +
                    "请使用event:register");
  }

  private Class<?> getClass(String event) throws ClassNotFoundException {
    String classPath;
    if (EVENT_MAPPER.containsKey(event)) {
      classPath = EVENT_MAPPER.getProperty(event);
    } else {
      classPath = event.startsWith(".") ?
              ("tk.smileyik.luainminecraftbukkit.bridge.event" + event) : event;
    }
    return Class.forName(classPath);
  }

  /**
   * 注册监听事件.
   * @param event 要注册的事件名.
   * @param id 闭包id
   * @param priority 优先级, 范围为[0, 5], 不再此区间内则为正常默认等级.
   */
  public void register(String event, String id, int priority) {
    LuaEvent<? extends Event> listener = null;
    try {
      listener = (LuaEvent<? extends Event>) getClass(event)
              .getDeclaredConstructor(String.class)
              .newInstance(id);

      registerEvent(listener, priority);
    } catch (Exception e) {
      LuaInMinecraftBukkit.log("注册%s事件失败! id: %s", event, id);
      e.printStackTrace();
    }
  }

  /**
   * 创建一个事件监听器.
   * @param plugin   脚本插件实例.
   * @param closure  脚本函数
   * @param event    事件名
   * @param priority 优先级, 范围为[0, 5], 不再此区间内则为正常默认等级.
   */
  public String register(LuaPlugin plugin,
                         Object closure, String event, int priority) {
    LuaEvent<? extends Event> listener = null;
    try {
      listener = (LuaEvent<? extends Event>) getClass(event)
              .getDeclaredConstructor(String.class)
              .newInstance(plugin.getId());
      listener.setClosure(closure);
      String id = String.format(
              "%s.%s.%s", plugin.getId(), event, listener.getId());
      listener.setId(id);
      registerEvent(listener, priority);
      return id;
    } catch (Exception e) {
      LuaInMinecraftBukkit.log(
              "注册%s事件失败! id: %s", event, plugin.getId());
      e.printStackTrace();
    }
    return null;
  }

  /**
   * 移除插件脚本用指定id注册的事件.
   * @param id 注册事件所用的id.
   */
  public void unregisterEvent(String id) {
    String pluginId = id.split("\\.")[0];
    if (events.containsKey(pluginId)) {
      List<LuaEvent<? extends Event>> luaEvents = events.get(pluginId);
      for (LuaEvent<? extends Event> luaEvent : luaEvents) {
        if (luaEvent.getId().equals(id)) {
          HandlerList.unregisterAll(luaEvent);
          luaEvents.remove(luaEvent);
          break;
        }
      }
    }
  }

  /**
   * 移除插件脚本所有注册的事件.
   * @param pluginId 插件脚本id
   */
  public void unregisterAll(String pluginId) {
    if (events.containsKey(pluginId)) {
      List<LuaEvent<? extends Event>> luaEvents = events.get(pluginId);
      for (LuaEvent<? extends Event> luaEvent : luaEvents) {
        HandlerList.unregisterAll(luaEvent);
      }
      luaEvents.clear();
    }
  }


}
