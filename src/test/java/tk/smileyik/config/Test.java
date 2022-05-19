package tk.smileyik.config;

import org.keplerproject.luajava.LuaException;
import tk.smileyik.luainminecraftbukkit.luaconfig.LuaConfig;
import tk.smileyik.luainminecraftbukkit.luaplugin.mode.outside.NativeLuaLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Test {


  String script =
          "entity:setaString('a')\n" +
          "entity:setAnInt(10)\n" +
          "entity:setInts(helper:toIntArray({1, 2, 3, 4, 5}))\n" +
          "entity:setEntities(helper:toArray(entity, {entity, entity}))";

  static {
    try {
      NativeLuaLoader.initNativeLua(new File("/home/miskyle/workspace/idea-space/LuaInMinecraftBukkt/src/test/resources"));
    } catch (IOException e) {
      throw new RuntimeException(e);
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
    LuaConfig config = LuaConfig.loadInsideLuaConfig(Paths.get("/home/miskyle" +
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
            "/miskyle" +
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
