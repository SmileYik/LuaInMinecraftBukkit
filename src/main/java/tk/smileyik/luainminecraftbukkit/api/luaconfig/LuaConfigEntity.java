package tk.smileyik.luainminecraftbukkit.api.luaconfig;

/**
 * 如果需要自己的实体类能够有运行闭包的能力,
 * 则可以用实体类实现本接口, 获取正在配置该
 * 实体类的LuaConfig, 并且利用其运行脚本
 * 所返回出来的闭包.
 */
public interface LuaConfigEntity {
  /**
   * 获取 LuaConfig.
   * @return LuaConfig对象.
   */
  LuaConfig getLuaConfig();

  /**
   * 设置 LuaConfig.
   * @param luaConfig 要传入的LuaConfig实例.
   */
  void setLuaConfig(LuaConfig luaConfig);
}
