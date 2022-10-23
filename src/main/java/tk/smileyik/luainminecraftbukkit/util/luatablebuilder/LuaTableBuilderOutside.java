package tk.smileyik.luainminecraftbukkit.util.luatablebuilder;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentOutside;

public class LuaTableBuilderOutside extends AbstractLuaTableBuilder<LuaObject> {
  private final LuaEnvironmentOutside luaEnvironment;

  public LuaTableBuilderOutside(LuaEnvironmentOutside luaEnvironment) {
    this.luaEnvironment = luaEnvironment;
  }

  /**
   * 建立Lua中的表.
   *
   * @return 返回所建立的表.
   */
  @Override
  public LuaObject build() {
    buildTable();
    return luaEnvironment.getEnvironment().getLuaObject(-1);
  }

  /**
   * 建立Lua中的表, 并加入到当前环境的全局变量中.
   *
   * @param key 全局变量的变量名.
   */
  @Override
  public void buildGlobal(String key) {
    buildTable();
    luaEnvironment.getEnvironment().setGlobal(key);
  }


  /**
   * 将table中的所有键值对加入到LuaState中.
   */
  private void buildTable() {
    LuaState luaState = luaEnvironment.getEnvironment();
    luaState.newTable();
    table.forEach((k, v) -> {
      luaState.pushString(k);
      try {
        luaState.pushObjectValue(v);
      } catch (LuaException e) {
        luaState.pop(-2);
        throw new RuntimeException(e);
      }
      luaState.setTable(-3);
    });
  }
}
