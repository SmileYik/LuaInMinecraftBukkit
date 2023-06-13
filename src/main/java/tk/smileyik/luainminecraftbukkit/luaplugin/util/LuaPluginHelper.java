package tk.smileyik.luainminecraftbukkit.luaplugin.util;

import org.bukkit.plugin.Plugin;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.luaplugin.LuaPlugin;
import tk.smileyik.luainminecraftbukkit.luaplugin.mode.outside.LuaPluginManagerOutside;
import tk.smileyik.luainminecraftbukkit.util.luahelper.LuaHelper;
import tk.smileyik.luainminecraftbukkit.util.luahelper.LuaHttpHelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class LuaPluginHelper extends LuaHelper {
  /**
   * 指定脚本插件是否加载.
   * @param id 脚本插件id
   * @return 如果已经加载则返回true.
   */
  public static boolean isLoadPlugin(String id) {
    return LuaInMinecraftBukkit.getPluginManager().isLoadPlugin(id);
  }

  /**
   * 以指定id对应的函数为run方法主体创建一个Runnable子类实例
   * @param id 函数路径
   * @return LuaRunnable实例
   */
  public static LuaRunnable newLuaRunnable(String id) {
    return new LuaRunnable(id);
  }

  /**
   * 以指定id对应的函数为run方法主体创建一个Runnable子类实例
   * @param id 函数路径
   * @param obj 带入的参数.
   * @return LuaRunnable实例
   */
  public static LuaRunnable newLuaRunnable(String id, Object obj) {
    return new LuaRunnable(id, obj);
  }

  /**
   * 获取本插件实例对象.
   * @return 本插件的实例对象.
   */
  public static Plugin getPlugin() {
    return LuaInMinecraftBukkit.getInstance();
  }

  /**
   * 插件是否在Native模式下运行.
   * @return 如果是在Native模式下运行则返回true.
   */
  public static boolean isNativeMode() {
    return LuaInMinecraftBukkit.getPluginManager() instanceof LuaPluginManagerOutside;
  }

  /**
   * 以插件身份发送一个HTTP请求.
   * @param plugin Lua插件实例.
   * @param urlString 链接字符串
   * @param body 请求体，如果传入null则代表不需要请求体.
   * @param preOperation 前置操作Lua函数闭包，将会传入一个HttpURLConnection实例给闭包.
   * @param callback 一个Lua函数闭包，会将Response Code以及HTTP请求的文本结果作为字符串传递给闭包.
   * @param errorCallback 一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.
   */
  public static void httpAction(LuaPlugin plugin, String urlString, byte[] body, Object preOperation,
                                Object callback, Object errorCallback) {
    LuaHttpHelper.action(
            urlString, body,
            con -> {
              if (preOperation != null) {
                LuaInMinecraftBukkit.getPluginManager().callClosure(plugin.getId(), preOperation, con);
              }
            },
            (code, con) -> {
              if (callback != null) {
                LuaInMinecraftBukkit.getPluginManager().callClosure(plugin.getId(), callback, code, con);
              }
            },
            (e) -> {
              if (errorCallback != null) {
                LuaInMinecraftBukkit.getPluginManager().callClosure(plugin.getId(), errorCallback, e);
              }
            }
    );
  }

  /**
   * 以插件身份发送一个HTTP请求.
   * @param plugin Lua插件实例.
   * @param urlString 链接字符串
   * @param method 请求方法
   * @param body 请求体，如果传入null则代表不需要请求体.
   * @param connectTimeout 连接等待时间(毫秒).
   * @param readTimeout 读取等待时间(毫秒).
   * @param instanceFollowRedirects 是否跟随重定向.
   * @param header 需要添加的请求头，为null则代表不需要添加.
   * @param useCaches 是否使用缓存.
   * @param callback 一个Lua函数闭包，会将Response Code以及HTTP请求的文本结果作为字符串传递给闭包.
   * @param errorCallback 一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.
   */
  public static void httpAction(LuaPlugin plugin, String urlString, String method, byte[] body, int connectTimeout,
                                int readTimeout, boolean instanceFollowRedirects, Map<String, String> header,
                                boolean useCaches, Object callback, Object errorCallback) {
    LuaHttpHelper.action(
            urlString, body,
            con -> {
              con.setRequestMethod(method);
              con.setConnectTimeout(connectTimeout);
              con.setReadTimeout(readTimeout);
              con.setInstanceFollowRedirects(instanceFollowRedirects);
              con.setUseCaches(useCaches);
              if (header != null) {
                header.forEach(con::addRequestProperty);
              }
            },
            (code, con) -> {
              if (callback != null) {
                StringBuilder sb = new StringBuilder();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                  String line = null;
                  while ((line = br.readLine()) != null) {
                    sb.append(line).append('\n');
                  }
                }
                LuaInMinecraftBukkit.getPluginManager().callClosure(
                        plugin.getId(), callback, code, sb.substring(0, sb.length() - 1));
              }
            },
            (e) -> {
              if (errorCallback != null) {
                LuaInMinecraftBukkit.getPluginManager().callClosure(plugin.getId(), errorCallback, e);
              }
            }
    );
  }

  /**
   * 以插件身份发送一个HTTP请求.
   * @param plugin Lua插件实例.
   * @param urlString 链接字符串
   * @param method 请求方法
   * @param body 字符串请求体，如果传入null则代表不需要请求体.
   * @param bodyEncode 字符串请求体编码格式.
   * @param connectTimeout 连接等待时间(毫秒).
   * @param readTimeout 读取等待时间(毫秒).
   * @param instanceFollowRedirects 是否跟随重定向.
   * @param header 需要添加的请求头，为null则代表不需要添加.
   * @param useCaches 是否使用缓存.
   * @param callback 一个Lua函数闭包，会将Response Code以及HTTP请求的文本结果作为字符串传递给闭包.
   * @param errorCallback 一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.
   */
  public static void httpAction(LuaPlugin plugin, String urlString, String method, String body, String bodyEncode, int connectTimeout,
                                int readTimeout, boolean instanceFollowRedirects, Map<String, String> header,
                                boolean useCaches, Object callback, Object errorCallback) {
    try {
      httpAction(plugin, urlString, method, body == null ? null : body.getBytes(bodyEncode), connectTimeout,
              readTimeout, instanceFollowRedirects, header, useCaches, callback, errorCallback);
    } catch (UnsupportedEncodingException e) {
      if (errorCallback != null) {
        LuaInMinecraftBukkit.getPluginManager().callClosure(plugin.getId(), errorCallback, e);
      }
    }
  }

  /**
   * 以插件身份发送一个HTTP的GET请求.
   * @param plugin Lua插件实例.
   * @param urlString 链接字符串
   * @param connectTimeout 连接等待时间(毫秒).
   * @param readTimeout 读取等待时间(毫秒).
   * @param instanceFollowRedirects 是否跟随重定向.
   * @param header 需要添加的请求头，为null则代表不需要添加.
   * @param useCaches 是否使用缓存.
   * @param callback 一个Lua函数闭包，会将Response Code以及HTTP请求的文本结果作为字符串传递给闭包.
   * @param errorCallback 一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.
   */
  public static void httpGet(LuaPlugin plugin, String urlString, int connectTimeout, int readTimeout,
                             boolean instanceFollowRedirects, Map<String, String> header,
                             boolean useCaches, Object callback,
                             Object errorCallback) {
    httpAction(plugin, urlString, "GET", null, connectTimeout, readTimeout,
            instanceFollowRedirects, header, useCaches, callback, errorCallback);
  }

  /**
   * 以插件身份发送一个HTTP的GET请求.
   * @param plugin Lua插件实例.
   * @param urlString 链接字符串
   * @param connectTimeout 连接等待时间(毫秒).
   * @param readTimeout 读取等待时间(毫秒).
   * @param instanceFollowRedirects 是否跟随重定向.
   * @param useCaches 是否使用缓存.
   * @param callback 一个Lua函数闭包，会将Response Code以及HTTP请求的文本结果作为字符串传递给闭包.
   * @param errorCallback 一个Lua函数闭包，其只在运行过程中出现错误时调用，会将Exception实例传给闭包.
   */
  public static void httpGet(LuaPlugin plugin, String urlString, int connectTimeout, int readTimeout,
                             boolean instanceFollowRedirects, boolean useCaches,
                             Object callback, Object errorCallback) {
    httpAction(plugin, urlString, "GET", null, connectTimeout, readTimeout,
            instanceFollowRedirects, null, useCaches, callback, errorCallback);
  }
}
