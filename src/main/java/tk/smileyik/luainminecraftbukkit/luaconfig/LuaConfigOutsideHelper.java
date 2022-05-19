package tk.smileyik.luainminecraftbukkit.luaconfig;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;

import java.lang.reflect.Array;

public class LuaConfigOutsideHelper {
  public static int[] toIntArray(LuaObject table) throws LuaException {
    LuaState l = table.getLuaState();
    int size = l.objLen(-1);
    int[] ans = new int[size];
    for (int i = 0; i < size; ++i) {
      ans[i] = (int) l.getLuaObject(table, i + 1).getNumber();
    }
    return ans;
  }

  public static double[] toDoubleArray(LuaObject table) throws LuaException {
    LuaState l = table.getLuaState();
    int size = l.objLen(-1);
    double[] ans = new double[size];
    for (int i = 0; i < size; ++i) {
      ans[i] = l.getLuaObject(table, i + 1).getNumber();
    }
    return ans;
  }

  public static float[] toFloatArray(LuaObject table) throws LuaException {
    LuaState l = table.getLuaState();
    int size = l.objLen(-1);
    float[] ans = new float[size];
    for (int i = 0; i < size; ++i) {
      ans[i] = (float) l.getLuaObject(table, i + 1).getNumber();
    }
    return ans;
  }

  public static String[] toStringArray(LuaObject table) throws LuaException {
    LuaState l = table.getLuaState();
    int size = l.objLen(-1);
    String[] ans = new String[size];
    for (int i = 0; i < size; ++i) {
      ans[i] = l.getLuaObject(table, i + 1).getString();
    }
    return ans;
  }

  public static <T> T[] toArray(T t, LuaObject table) throws LuaException {
    LuaState l = table.getLuaState();
    int size = l.objLen(-1);
    Object array = Array.newInstance(t.getClass(), size);
    for (int i = 0; i < size; ++i) {
      Array.set(array, i, l.getLuaObject(table, i + 1).getObject());
    }
    return (T[]) array;
  }
}
