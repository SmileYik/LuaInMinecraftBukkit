package tk.smileyik.luainminecraftbukkit.luaplugin.util;

import java.util.logging.Logger;

public class LuaLogger {
  private final Logger logger;

  public LuaLogger(Logger logger) {
    this.logger = logger;
  }

  /**
   * 在控制台显示一条消息.
   * @param obj 要显示的内容.
   */
  public void info(Object obj) {
    logger.info(String.valueOf(obj));
  }

  /**
   * 在控制台显示一条警告.
   * @param obj 要显示的内容.
   */
  public void warning(Object obj) {
    logger.warning(String.valueOf(obj));
  }

  /**
   * 在控制台显示一条错误.
   * @param obj 要显示的内容.
   */
  public void severe(Object obj) {
    logger.severe(String.valueOf(obj));
  }
}
