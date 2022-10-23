package tk.smileyik.luainminecraftbukkit.luaplugin;

import tk.smileyik.luainminecraftbukkit.luaplugin.mode.hybrid.RunType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public interface LuaPlugin {
  /**
   * 获取脚本插件ID.
   * @return 插件的id.
   */
  String getId();

  /**
   * 获取脚本插件的显示名称.
   * @return 脚本插件的显示名称
   */
  String getDisplayName();

  /**
   * 获取脚本插件的作者.
   * @return 脚本插件的作者
   */
  String getAuthor();

  /**
   * 获取脚本插件的版本.
   * @return 脚本插件版本.
   */
  String getVersion();

  /**
   * 获取脚本插件的非必要依赖脚本插件id.
   * @return 非必要依赖脚本插件id.
   */
  List<String> getSoftDependents();

  /**
   * 获取脚本插件的必要依赖脚本插件id.
   * @return 必要依赖脚本插件id.
   */
  List<String> getDependents();

  /**
   * 获取脚本插件的配置目录.
   * @return 配置目录File对象.
   */
  File getConfigPath();

  /**
   * 获取脚本插件所在的目录.
   * @return 脚本插件所在的目录.
   */
  File getPluginPath();

  /**
   * 方便require方法获取脚本插件的模块路径.
   * @param module 模块名称
   * @return 返回脚本插件require所认可的模块路径.
   * @throws IOException
   */
  String getRequirePath(String module) throws IOException;

  /**
   * 获取Logger.
   * @return 返回Logger.
   */
  Logger getLogger();

  /**
   * 获取运行模式.
   * @return 当前插件的运行模式.
   */
  RunType getRunType();
}
