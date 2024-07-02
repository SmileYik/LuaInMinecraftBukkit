package tk.smileyik.config;

import org.keplerproject.luajava.LuaException;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfig;
import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeLuaLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class LuaConfigTest {


  String script = "entity:setAnInt(10)\n";

  static {
    try {
      NativeLuaLoader.initNativeLua(new File("/home/smileyik/workspace/idea" +
              "-space/LuaInMinecraftBukkt/src/test/resources"), null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @org.junit.jupiter.api.Test
  void scriptInsideTest() throws LuaException, IOException {
    LuaConfig config = LuaConfig.loadInsideLuaConfig(script);
    Entity entity = new Entity();
    System.out.println(entity);
    System.out.println("---------------");
    config.setGlobal("entity", entity);
    config.config();
    System.out.println(entity);
  }

  @org.junit.jupiter.api.Test
  void scriptOutsideTest() throws LuaException, IOException {
    LuaConfig config = LuaConfig.loadOutsideLuaConfig(script);
    Entity entity = new Entity();
    System.out.println(entity);
    System.out.println("---------------");
    config.setGlobal("entity", entity);
    config.config();
    System.out.println(entity);
  }

  @org.junit.jupiter.api.Test
  void fileScriptInsideTest() throws LuaException, IOException {
    LuaConfig config = LuaConfig.loadInsideLuaConfig(Paths.get("/home/smileyik" +
            "/workspace/idea-space/LuaInMinecraftBukkt/src/test/resources/lua_config_inside_test.lua"));
    Entity entity = new Entity();
    System.out.println(entity);
    System.out.println("---------------");
    config.setGlobal("entity", entity);
    config.config();
    System.out.println(entity);
  }

  @org.junit.jupiter.api.Test
  void fileScriptOutsideTest() throws LuaException, IOException {
    LuaConfig config = LuaConfig.loadOutsideLuaConfig(Paths.get("/home" +
            "/smileyik" +
            "/workspace/idea-space/LuaInMinecraftBukkt/src/test/resources" +
            "/lua_config_outside_test.lua"));
    Entity entity = new Entity();
    System.out.println(entity);
    System.out.println("---------------");
    config.setGlobal("entity", entity);
    config.config();
    System.out.println(entity);
  }
}
