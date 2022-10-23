package tk.smileyik.luainminecraftbukkit.util.luatablebuilder;

import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueUtil;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentInside;

public class LuaTableBuilderInside extends AbstractLuaTableBuilder<LuaValue> {
  private final LuaEnvironmentInside luaEnvironment;

  public LuaTableBuilderInside(LuaEnvironmentInside luaEnvironment) {
    this.luaEnvironment = luaEnvironment;
  }

  /**
   * 建立Lua中的表.
   *
   * @return 返回所建立的表.
   */
  @Override
  public LuaValue build() {
    return buildLuaTable();
  }

  /**
   * 建立Lua中的表, 并加入到当前环境的全局变量中.
   *
   * @param key 全局变量的变量名.
   */
  @Override
  public void buildGlobal(String key) {
    LuaValue table = buildLuaTable();
    luaEnvironment.getEnvironment().set(key, table);
  }

  /**
   * 构建一个Lua表.
   * @return Lua中的表.
   */
  private LuaValue buildLuaTable() {
    LuaValue luaValue = LuaValue.tableOf();
    table.forEach((k, v) -> {
      luaValue.set(k, LuaValueUtil.toLuaValue(v));
    });
    return luaValue;
  }
}
