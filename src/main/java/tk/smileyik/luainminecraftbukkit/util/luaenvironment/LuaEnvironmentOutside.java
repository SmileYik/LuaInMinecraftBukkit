package tk.smileyik.luainminecraftbukkit.util.luaenvironment;

import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;

public class LuaEnvironmentOutside implements LuaEnvironment<LuaState> {
  private final LuaState luaState;

  public LuaEnvironmentOutside(LuaState luaState) {
    this.luaState = luaState;
  }

  protected LuaEnvironmentOutside() {
    luaState = LuaStateFactory.newLuaState();
    luaState.openLibs();
  }

  @Override
  public LuaState getEnvironment() {
    return luaState;
  }
}
