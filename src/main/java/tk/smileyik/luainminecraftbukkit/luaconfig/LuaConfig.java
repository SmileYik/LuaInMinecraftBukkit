package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;
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
    setGlobal(key, value);
    return this;
  }

  /**
   * 运行脚本.
   */
  void config() throws IOException, LuaException;
}
