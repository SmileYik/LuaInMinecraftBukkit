package tk.smileyik;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import tk.smileyik.luainminecraftbukkit.luaplugin.util.NativeLuaLoader;

import java.io.File;
import java.io.IOException;

public class NativeTest1 {

  public static void main(String[] args) throws IOException, LuaException {
    NativeLuaLoader.initNativeLua(new File("/home/miskyle/workspace/idea-space/LuaInMinecraftBukkt/src/test/resources"));
    LuaState luaState = LuaStateFactory.newLuaState();
    luaState.openLibs();
    luaState.LloadFile("/home/miskyle/workspace/idea-space/LuaInMinecraftBukkt/src/test/resources/native_test1.lua");
    luaState.pcall(0, 0, 0);
    System.out.println(luaState.getLuaObject("a").call(new Object[]{}));

  }
}
