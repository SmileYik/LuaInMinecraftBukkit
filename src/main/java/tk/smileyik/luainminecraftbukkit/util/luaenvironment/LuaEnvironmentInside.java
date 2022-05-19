package tk.smileyik.luainminecraftbukkit.util.luaenvironment;

import org.luaj.vm2.Globals;
import org.luaj.vm2.lib.jse.JsePlatform;

public class LuaEnvironmentInside implements LuaEnvironment<Globals> {
  private final Globals globals;

  public LuaEnvironmentInside(Globals globals) {
    this.globals = globals;
  }

  protected LuaEnvironmentInside() {
    globals = JsePlatform.standardGlobals();
  }

  @Override
  public Globals getEnvironment() {
    return globals;
  }
}
