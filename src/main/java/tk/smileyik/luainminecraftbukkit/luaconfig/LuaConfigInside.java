package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfig;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfigEntity;
import tk.smileyik.luainminecraftbukkit.luaconfig.exception.LuaConfigClosureReturnException;
import tk.smileyik.luainminecraftbukkit.luaconfig.exception.LuaConfigNotClosureException;
import tk.smileyik.luainminecraftbukkit.util.LuaValueUtil;
import tk.smileyik.luainminecraftbukkit.util.luaenvironment.LuaEnvironmentInside;
import tk.smileyik.luainminecraftbukkit.util.luatablebuilder.LuaTableBuilder;

import java.text.NumberFormat;
import java.text.ParseException;

public abstract class LuaConfigInside
        extends LuaEnvironmentInside implements LuaConfig {

  @Override
  public LuaTableBuilder<?> newTableBuilder() {
    return LuaTableBuilder.getBuilder(this);
  }

  @Override
  public void setGlobal(String key, Object value) {
    if (value instanceof LuaConfigEntity) {
      ((LuaConfigEntity) value).setLuaConfig(this);
    }
    getEnvironment().set(key, LuaValueUtil.toLuaValue(value));
  }

  @Override
  public void close() {
    // 暂时不需要, 仅对Native模式有效.
  }

  @Override
  public Object callClosureReturnObject(Object closureObj, Object... objs) {
    LuaValue value = callClosure(closureObj, objs);
    if (value == null) {
      return null;
    } else if (value.isuserdata()) {
      return value.touserdata();
    }
    throw new LuaConfigClosureReturnException(
            "尝试将一个非java对象的闭包返回结果当作java对象返回: " +
            value
    );
  }

  @Override
  public String callClosureReturnString(Object closureObj, Object... objs) {
    LuaValue value = callClosure(closureObj, objs);
    if (value == null) {
      return null;
    }
    return value.toString();
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
    LuaValue value = callClosure(closureObj, objs);
    if (value == null) {
      return false;
    } else if (value.isboolean()) {
      return value.toboolean();
    }
    throw new LuaConfigClosureReturnException(
            "尝试将一个非布尔类型对象的闭包返回结果当作布尔类型对象返回:" +
            value
    );
  }

  @Override
  public Object callClosureReturnClosure(Object closureObj, Object... objs) {
    LuaValue value = callClosure(closureObj, objs);
    if (value == null) {
      return null;
    } else if (value.isclosure()) {
      return value;
    }
    throw new LuaConfigClosureReturnException(
            "尝试将一个非闭包类型对象的闭包返回结果当作闭包类型对象返回:" +
            value
    );
  }

  private LuaValue callClosure(Object closureObj, Object... objs) {
    if (closureObj instanceof LuaClosure) {
      LuaClosure closure = (LuaClosure) closureObj;
      LuaValue ret;
      switch (objs.length) {
        case 0:
          ret = closure.call();
          break;
        case 1:
          ret = closure.call(LuaValueUtil.toLuaValue(objs[0]));
          break;
        case 2:
          ret = closure.call(
                  LuaValueUtil.toLuaValue(objs[0]),
                  LuaValueUtil.toLuaValue(objs[1])
          );
          break;
        default:
          ret = closure.call(
                  LuaValueUtil.toLuaValue(objs[0]),
                  LuaValueUtil.toLuaValue(objs[1]),
                  LuaValueUtil.toLuaValue(objs[3])
          );
          break;
      }
      if (ret == null || ret.isnil()) {
        return null;
      } else {
        return ret;
      }
    } else {
      throw new LuaConfigNotClosureException();
    }
  }
}
