package tk.smileyik.luainminecraftbukkit;

import tk.smileyik.luainminecraftbukkit.luaplugin.mode.LuaVMType;
import tk.smileyik.luainminecraftbukkit.luaplugin.util.NativeLuaLoader;

import java.io.IOException;

public class PluginSetting {

  private static final boolean allowNative;

  static {
    boolean flag = false;
    try {
      NativeLuaLoader.initNativeLua(
              LuaInMinecraftBukkit.getInstance().getDataFolder());
      flag = true;
    } catch (IOException e) {
      LuaInMinecraftBukkit.log("无法使用Native模式, 切换至原生模式.");
    }
    allowNative = flag;
  }


  private LuaVMType vmType = LuaVMType.Inside;
  private boolean debug = false;

  public void run_mode(String mode) {
    try {
      vmType = LuaVMType.valueOf(mode);
    } catch (IllegalArgumentException e) {
      LuaInMinecraftBukkit.getInstance().getLogger()
              .warning("模式配置无效, 只支持 Inside(默认模式), " +
              "Outside(Native模式), " +"Hybrid(混合模式); 注意大小写");
      vmType = LuaVMType.Inside;
    }
  }

  public void debug(boolean flag) {
    debug = flag;
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
}
