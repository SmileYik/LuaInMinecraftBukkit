package tk.smileyik.luainminecraftbukkit;

import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeLuaLoader;
import tk.smileyik.luainminecraftbukkit.util.nativeloader.NativeVersion;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Locale;

public class PluginSetting {

  private static boolean allowNative;
  private static NativeVersion nativeVersion = NativeVersion.LUA_5_4;
  private static final File LIB_LOCK = new File(
          LuaInMinecraftBukkit.getInstance().getDataFolder(),
          "lib.lock"
  );

  private LuaVMType vmType = LuaVMType.Inside;
  private boolean debug = false;

  public void run_mode(String mode) {
    try {
      vmType = LuaVMType.valueOf(mode);
    } catch (IllegalArgumentException e) {
      LuaInMinecraftBukkit.getInstance().getLogger()
              .warning("模式配置无效, 只支持 Inside(默认模式), " +
              "Outside(Native模式), " + "Hybrid(混合模式); 注意大小写");
      vmType = LuaVMType.Inside;
    }
  }

  public void debug(boolean flag) {
    debug = flag;
  }

  public void native_version(String version) {
    try {
      nativeVersion =
              NativeVersion.valueOf(version.toUpperCase(Locale.ROOT));
    } catch (IllegalArgumentException e) {
      nativeVersion = NativeVersion.LUA_5_4;
      LuaInMinecraftBukkit.getInstance().getLogger()
              .warning("native_version配置无效, 将默认使用" + nativeVersion + ", " +
                      "此配置项仅支持如下参数: " + Arrays.toString(NativeVersion.values()));
    }
  }

  public void loadNativeLib() {
    try {
      if (getNowNativeVersion() != nativeVersion) {
        // change lib
        LuaInMinecraftBukkit.log("检测到lua版本改变, 正在准备切换版本...");
        NativeLuaLoader.deleteLibs(
                LuaInMinecraftBukkit.getInstance().getDataFolder()
        );
      }
      NativeLuaLoader.initNativeLua(
              LuaInMinecraftBukkit.getInstance().getDataFolder(), nativeVersion
      );
      LuaInMinecraftBukkit.log("版本已加载: %s", nativeVersion.toString());
      allowNative = true;
      Files.write(
              LIB_LOCK.toPath(),
              nativeVersion.toString().getBytes(StandardCharsets.UTF_8),
              StandardOpenOption.WRITE,
              StandardOpenOption.CREATE,
              StandardOpenOption.TRUNCATE_EXISTING
      );
    } catch (IOException e) {
      LuaInMinecraftBukkit.log("无法使用Native模式, 切换至原生模式.");
      allowNative = false;
    }
  }

  public LuaVMType getVmType() {
    return vmType;
  }

  public boolean isDebug() {
    return debug;
  }

  public static boolean isAllowNative() {
    return allowNative;
  }

  private NativeVersion getNowNativeVersion() {
    if (!LIB_LOCK.exists()) {
      return null;
    }
    try {
      String s = new String(Files.readAllBytes(LIB_LOCK.toPath())).toUpperCase();
      return NativeVersion.valueOf(s);
    } catch (Exception e) {
      return null;
    }
  }
}
