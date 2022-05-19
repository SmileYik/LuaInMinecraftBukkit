package tk.smileyik.luainminecraftbukkit.util.luatablebuilder;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractLuaTableBuilder <T>
        implements LuaTableBuilder <T> {

  protected final Map<String, Object> table;

  protected AbstractLuaTableBuilder() {
    this.table = new HashMap<>();
  }

  /**
   * 增加一个键值对.
   *
   * @param key   LuaTable中的键名.
   * @param value 键名对应的值.
   * @return 本实例对象.
   */
  @Override
  public LuaTableBuilder<T> put(String key, Object value) {
    table.put(key, value);
    return this;
  }

  /**
   * 通过Map增加多个键值对.
   *
   * @param map 键为字符串类型的map.
   * @return 本实例对象.
   */
  @Override
  public LuaTableBuilder<T> putAll(Map<? extends String, ?> map) {
    table.putAll(map);
    return this;
  }

  /**
   * 清空当前表.
   *
   * @return 本实例对象.
   */
  @Override
  public LuaTableBuilder<T> clear() {
    table.clear();
    return this;
  }

  /**
   * 移除指定键的值.
   *
   * @param key 要移除的键名.
   * @return 本实例对象.
   */
  @Override
  public LuaTableBuilder<T> remove(String key) {
    table.remove(key);
    return this;
  }
}
