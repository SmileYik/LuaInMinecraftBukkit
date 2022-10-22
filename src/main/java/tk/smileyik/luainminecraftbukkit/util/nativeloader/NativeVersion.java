package tk.smileyik.luainminecraftbukkit.util.nativeloader;

public enum NativeVersion {

  LUA_5_4("lua5.4"),
  LUAJIT_2_1_0_BETA3("luajit2.1.0_beta3");

  private final String dir;

  private NativeVersion(String dir) {
    this.dir = dir;
  }

  public String getDir() {
    return dir;
  }
}
