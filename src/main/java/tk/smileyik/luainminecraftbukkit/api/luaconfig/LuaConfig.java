package tk.smileyik.luainminecraftbukkit.api.luaconfig;

import org.keplerproject.luajava.LuaException;
import tk.smileyik.luainminecraftbukkit.luaconfig.LuaConfigInsideByFile;
import tk.smileyik.luainminecraftbukkit.luaconfig.LuaConfigInsideByScript;
import tk.smileyik.luainminecraftbukkit.luaconfig.LuaConfigOutsideByFile;
import tk.smileyik.luainminecraftbukkit.luaconfig.LuaConfigOutsideByScript;
import tk.smileyik.luainminecraftbukkit.util.luatablebuilder.LuaTableBuilder;

import java.io.IOException;
import java.nio.file.Path;

public interface LuaConfig {
  /**
   * 用默认运行模式加载一个脚本配置.
   * @param script 脚本.
   * @return 一个脚本配置.
   */
  static LuaConfig loadInsideLuaConfig(String script) {
    return new LuaConfigInsideByScript(script);
  }

  /**
   * 用默认运行模式加载一个脚本配置.
   * @param path 脚本路径.
   * @return 一个脚本配置.
   */
  static LuaConfig loadInsideLuaConfig(Path path) {
    return new LuaConfigInsideByFile(path);
  }

  /**
   * 用Native原生运行模式加载一个脚本配置.
   * @param script 脚本.
   * @return 一个脚本配置.
   */
  static LuaConfig loadOutsideLuaConfig(String script) {
    return new LuaConfigOutsideByScript(script);
  }

  /**
   * 用Native原生运行模式加载一个脚本配置.
   * @param path 脚本路径.
   * @return 一个脚本配置.
   */
  static LuaConfig loadOutsideLuaConfig(Path path) {
    return new LuaConfigOutsideByFile(path);
  }

  /**
   * 构造一张Lua表.
   * @return LuaTableBuilder
   */
  LuaTableBuilder<?> newTableBuilder();

  /**
   * 增加一个全局变量.
   * @param key   全局变量名.
   * @param value 全局变量值.
   */
  void setGlobal(String key, Object value) throws LuaException;

  /**
   * 增加一个全局变量.
   * @param key   全局变量名.
   * @param value 全局变量值.
   * @return 本实例对象.
   */
  default LuaConfig addGlobal(String key, Object value) throws LuaException {
    if (value instanceof LuaConfigEntity) {
      ((LuaConfigEntity) value).setLuaConfig(this);
    }
    setGlobal(key, value);
    return this;
  }

  /**
   * 运行脚本.
   */
  void config() throws IOException, LuaException;

  /**
   * 关闭并释放LuaConfig所使用的资源.
   * 需要注意的是, 如果传入闭包, 在调用闭包时候,
   * 则必须要保持LuaConfig未被关闭.
   */
  void close();

  /**
   * 运行一个Lua闭包对象并且返回为字符串类型.
   * <p>
   *   对于默认模式有:
   *   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包.
   * </p>
   * <p>
   *   对于Native模式有:
   *   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常.
   * </p>
   * @param closureObj   由lua脚本返回的一个闭包实例对象.
   * @param objs         传递给闭包的参数.
   * @return 如果闭包返回为nil, 则此方法返回null.
   *         如果此闭包运行后返回的字符串结果.
   */
  String callClosureReturnString(Object closureObj, Object ... objs);

  /**
   * 运行一个Lua闭包对象并且返回为java对象.
   * 成功且正确的返回java对象的前提是, 在闭包
   * 中返回的对象必须是一个java对象.
   * <p>
   *   对于默认模式有:
   *   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包.
   * </p>
   * <p>
   *   对于Native模式有:
   *   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常.
   * </p>
   * @param closureObj   由lua脚本返回的一个闭包实例对象.
   * @param objs         传递给闭包的参数.
   * @return 如果闭包返回为nil, 则此方法返回null.
   *         如果此闭包运行后返回的java对象结果.
   */
  Object callClosureReturnObject(Object closureObj, Object ... objs);

  /**
   * 运行一个Lua闭包对象. 并且返回一个Number实例.
   * <p>
   *   对于默认模式有:
   *   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包.
   * </p>
   * <p>
   *   对于Native模式有:
   *   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常.
   * </p>
   * @param closureObj   由lua脚本返回的一个闭包实例对象.
   * @param objs         传递给闭包的参数.
   * @return 如果闭包返回为nil, 则此方法返回null.
   *         如果此闭包运行后返回的数字结果.
   */
  Number callClosureReturnNumber(Object closureObj, Object ... objs);

  /**
   * 运行一个Lua闭包对象. 并且返回一个布尔值.
   * <p>
   *   对于默认模式有:
   *   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包.
   * </p>
   * <p>
   *   对于Native模式有:
   *   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常.
   * </p>
   * @param closureObj   由lua脚本返回的一个闭包实例对象.
   * @param objs         传递给闭包的参数.
   * @return 如果闭包返回为nil, 则此方法返回false.
   *         如果此闭包运行后返回的布尔值结果.
   */
  boolean callClosureReturnBoolean(Object closureObj, Object ... objs);

  /**
   * 运行一个Lua闭包对象. 并且返回一个闭包.
   * <p>
   *   对于默认模式有:
   *   如果传递的参数大于3个的时候, 将只会传递前三个参数给闭包.
   * </p>
   * <p>
   *   对于Native模式有:
   *   如果在运行此闭包时, LuaConfig已经关闭, 闭包将会运行失败并抛出异常.
   * </p>
   * @param closureObj   由lua脚本返回的一个闭包实例对象.
   * @param objs         传递给闭包的参数.
   * @return 如果闭包返回为nil, 则此方法返回null.
   *         如果此闭包运行后返回的闭包结果.
   */
  Object callClosureReturnClosure(Object closureObj, Object ... objs);
}
