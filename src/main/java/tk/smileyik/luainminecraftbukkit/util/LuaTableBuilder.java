package tk.smileyik.luainminecraftbukkit.util;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

import java.util.Map;

public class LuaTableBuilder {
  private final LuaState luaState;
  public LuaTableBuilder(LuaState luaState) {
    this.luaState = luaState;
    luaState.newTable();
  }

  public LuaTableBuilder put(String key, Object value) {
    luaState.pushString(key);
    try {
      luaState.pushObjectValue(value);
    } catch (LuaException e) {
      luaState.pop(-2);
      throw new RuntimeException(e);
    }
    luaState.setTable(-3);
    return this;
  }

  public LuaTableBuilder putAll(Map<? extends String, ?> m) {
    m.forEach(this::put);
    return this;
  }

  public LuaTableBuilder clear() {
    luaState.pop(-1);
    luaState.newTable();
    return this;
  }

  public LuaObject build() {
    return luaState.getLuaObject(-1);
  }

  public void buildGlobal(String name) {
    luaState.setGlobal(name);
  }
}
