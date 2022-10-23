package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfig;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfigEntity;
import tk.smileyik.luainminecraftbukkit.api.luatablebuilder.LuaTableBuilder;
import tk.smileyik.luainminecraftbukkit.luaconfig.exception.LuaConfigClosedException;
import tk.smileyik.luainminecraftbukkit.luaconfig.exception.LuaConfigClosureReturnException;
import tk.smileyik.luainminecraftbukkit.luaconfig.exception.LuaConfigNotClosureException;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentOutside;

import java.text.NumberFormat;
import java.text.ParseException;

public abstract class LuaConfigOutside
        extends LuaEnvironmentOutside implements LuaConfig {
  private boolean close = false;
  @Override
  public LuaTableBuilder<?> newTableBuilder() {
    return LuaTableBuilder.getBuilder(this);
  }

  @Override
  public void setGlobal(String key, Object value) throws LuaException {
    if (value instanceof LuaConfigEntity) {
      ((LuaConfigEntity) value).setLuaConfig(this);
    }
    getEnvironment().pushObjectValue(value);
    getEnvironment().setGlobal(key);
  }

  @Override
  public void close() {
    getEnvironment().close();
    close = true;
  }

  @Override
  public Object callClosureReturnObject(Object closureObj, Object... objs) {
    return callClosure(closureObj, objs);
  }

  @Override
  public String callClosureReturnString(Object closureObj, Object... objs) {
    return callClosure(closureObj, objs).toString();
  }

  @Override
  public Number callClosureReturnNumber(Object closureObj, Object... objs) {
    String value = callClosureReturnString(closureObj, objs);
    if (value == null) {
      return null;
    }
    try {
      return NumberFormat.getInstance().parse(value);
    } catch (ParseException e) {
      throw new LuaConfigClosureReturnException(
              "尝试将一个非数字类型对象的闭包返回结果当作数字类型对象返回:" +
              e.getMessage()
      );
    }
  }

  @Override
  public boolean callClosureReturnBoolean(Object closureObj, Object... objs) {
    Object obj = callClosure(closureObj, objs);
    if (obj == null) {
      return false;
    }
    return (boolean) obj;
  }

  @Override
  public Object callClosureReturnClosure(Object closureObj, Object... objs) {
    return callClosure(closureObj, objs);
  }

  public Object callClosure(Object closureObj, Object... objs) {
    if (close) {
      throw new LuaConfigClosedException();
    } else if (closureObj instanceof LuaObject) {
      LuaObject closure = (LuaObject) closureObj;
      if (!closure.isFunction()) {
        throw new LuaConfigNotClosureException();
      }
      Object[] returns;
      try {
        returns = closure.call(objs, 1);
      } catch (LuaException e) {
        throw new RuntimeException(e);
      }
      if (returns == null || returns.length == 0) {
        return null;
      }
      return returns[0];
    } else {
      throw new LuaConfigNotClosureException();
    }
  }
}
