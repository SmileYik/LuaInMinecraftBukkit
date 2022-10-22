package tk.smileyik.luajava;

import org.keplerproject.luajava.LuaState;

public class MyLuaState {

  private static synchronized native int _luaRegistryIndex();

  public static void initMyLuaState() {
    // 加载寄存器索引
    LuaState.LUA_REGISTRYINDEX = _luaRegistryIndex();
  }
}
