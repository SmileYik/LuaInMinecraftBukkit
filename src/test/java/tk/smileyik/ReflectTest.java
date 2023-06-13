package tk.smileyik;

import org.junit.jupiter.api.Test;
import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaState;
import org.keplerproject.luajava.LuaStateFactory;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.lib.jse.JsePlatform;
import tk.smileyik.luainminecraftbukkit.util.luahelper.LuaHelper;
import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeLuaLoader;
import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeVersion;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

public class ReflectTest {

    void prevTest(NativeVersion version) {
        File file = new File("test");
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            NativeLuaLoader.initNativeLua(file, version);
            Files.copy(ReflectTest.class.getResourceAsStream("/httpdemo.lua"),
                    new File(file, "httpdemo.lua").toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void postTest() {
        try {
            File file = new File("test");
            Arrays.stream(file.listFiles()).forEachOrdered(File::delete);
            file.delete();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void httpGetNative54Test() throws IOException, LuaException {
        System.out.println("Start Test httpGetNative54Test");
        prevTest(NativeVersion.LUA_5_4);
        LuaState luaState = LuaStateFactory.newLuaState();
        luaState.openLibs();
        luaState.pushObjectValue(LuaHelper.class);
        luaState.setGlobal("helper");
        luaState.LloadFile(new File("test/httpdemo.lua").getCanonicalPath());
        luaState.pcall(0, 0, 0);
        luaState.close();
        postTest();
    }

    @Test
    public void httpGetNativeJitTest() throws IOException, LuaException {
        System.out.println("Start Test httpGetNativeJitTest");
        prevTest(NativeVersion.LUAJIT_2_1_0_BETA3);
        LuaState luaState = LuaStateFactory.newLuaState();
        luaState.openLibs();
        luaState.pushObjectValue(LuaHelper.class);
        luaState.setGlobal("helper");
        luaState.LloadFile(new File("test/httpdemo.lua").getCanonicalPath());
        luaState.pcall(0, 0, 0);
        luaState.close();
        postTest();
    }

    @Test
    public void httpGetTest() {
        System.out.println("Start Test httpGetTest");
        prevTest(NativeVersion.LUA_5_4);
        Globals globals = JsePlatform.standardGlobals();
        globals.set("helper", CoerceJavaToLua.coerce(LuaHelper.class));
        LuaValue chunk = globals.loadfile("test/httpdemo.lua");
        LuaValue call = chunk.call();
        postTest();
    }
}
