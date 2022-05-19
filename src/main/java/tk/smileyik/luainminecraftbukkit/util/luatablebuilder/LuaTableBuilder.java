package tk.smileyik.luainminecraftbukkit.util.luatablebuilder;

import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironment;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentInside;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentOutside;

import java.util.Map;

public interface LuaTableBuilder <T> {
  static LuaTableBuilder<?> getBuilder(LuaEnvironment<?> luaEnvironment) {
    if (luaEnvironment instanceof LuaEnvironmentOutside) {
      return new LuaTableBuilderOutside(
              (LuaEnvironmentOutside) luaEnvironment);
    } else {
      return new LuaTableBuilderInside(
              (LuaEnvironmentInside) luaEnvironment);
    }
  }

  /**
   * 增加一个键值对.
   * @param key   LuaTable中的键名.
   * @param value 键名对应的值.
   * @return 本实例对象.
   */
  LuaTableBuilder<T> put(String key, Object value);

  /**
   * 通过Map增加多个键值对.
   * @param map 键为字符串类型的map.
   * @return 本实例对象.
   */
  LuaTableBuilder<T> putAll(Map<? extends String, ?> map);

  /**
   * 清空当前表.
   * @return 本实例对象.
   */
  LuaTableBuilder<T> clear();

  /**
   * 移除指定键的值.
   * @param key 要移除的键名.
   * @return 本实例对象.
   */
  LuaTableBuilder<T> remove(String key);

  /**
   * 建立Lua中的表.
   * @return 返回所建立的表.
   */
  T build();

  /**
   * 建立Lua中的表, 并加入到当前环境的全局变量中.
   * @param key 全局变量的变量名.
   */
  void buildGlobal(String key);
}
