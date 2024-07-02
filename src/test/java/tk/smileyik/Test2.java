package tk.smileyik;

import org.junit.jupiter.api.Test;
import org.keplerproject.luajava.Console;
import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeLuaLoader;
import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeVersion;

import java.io.File;
import java.io.IOException;

public class Test2 {
    @Test
    public void a() throws IOException {
        NativeLuaLoader.initNativeLua(
                new File("/run/media/smileyik/H/Workspace/Idea-space/LuaInMinecraftBukkt/src/test/resources/"),
                NativeVersion.LUA_5_4
        );
        Console.main(new String[]{});
    }
}
