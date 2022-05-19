package tk.smileyik.luainminecraftbukkit.luaconfig;

import tk.smileyik.luainminecraftbukkit.util.LuaValueUtil;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentInside;
import tk.smileyik.luainminecraftbukkit.util.luatablebuilder.LuaTableBuilder;

public abstract class LuaConfigInside
        extends LuaEnvironmentInside implements LuaConfig {

  @Override
  public LuaTableBuilder<?> newTableBuilder() {
    return LuaTableBuilder.getBuilder(this);
  }

  @Override
  public void setGlobal(String key, Object value) {
    getEnvironment().set(key, LuaValueUtil.toLuaValue(value));
  }
}
