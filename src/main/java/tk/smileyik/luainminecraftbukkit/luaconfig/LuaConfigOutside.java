package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentOutside;
import tk.smileyik.luainminecraftbukkit.util.luatablebuilder.LuaTableBuilder;

public abstract class LuaConfigOutside
        extends LuaEnvironmentOutside implements LuaConfig {
  @Override
  public LuaTableBuilder<?> newTableBuilder() {
    return LuaTableBuilder.getBuilder(this);
  }

  @Override
  public void setGlobal(String key, Object value) throws LuaException {
    getEnvironment().pushObjectValue(value);
    getEnvironment().setGlobal(key);
  }
}
