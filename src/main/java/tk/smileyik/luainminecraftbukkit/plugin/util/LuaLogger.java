package tk.smileyik.luainminecraftbukkit.plugin.util;

import java.util.logging.Logger;

public class LuaLogger {
  private final Logger logger;

  public LuaLogger(Logger logger) {
    this.logger = logger;
  }

  public void info(Object obj) {
    logger.info(String.valueOf(obj));
  }

  public void warning(Object obj) {
    logger.warning(String.valueOf(obj));
  }

  public void severe(Object obj) {
    logger.severe(String.valueOf(obj));
  }
}
