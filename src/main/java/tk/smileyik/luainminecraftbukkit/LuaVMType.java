package tk.smileyik.luainminecraftbukkit;

public enum LuaVMType {
  /**
   * 混合模式, 可以让插件指定使用Inside或Outside运行模式.
   */
  Hybrid,
  /**
   * 采用Java原生制作的LuaVM去运行.
   */
  Inside,
  /**
   * 采用原生LuaVM去运行.
   */
  Outside;
}
