package tk.smileyik.luainminecraftbukkit.util.luahelper;

import org.keplerproject.luajava.LuaException;
import org.keplerproject.luajava.LuaObject;
import org.keplerproject.luajava.LuaState;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.lib.jse.CoerceLuaToJava;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class LuaHelper {

    /**
     * 通过全类名去获取java类类型.
     * @param name 全类名
     * @return 如果类存在则返回对应的类
     * @throws ClassNotFoundException 当找不到指定路径的类则抛出.
     */
    public static Class<?> getClass(String name) throws ClassNotFoundException {
        return Class.forName(name);
    }

    public static Object newInstance(Class<?> clazz, Class[] classes, Object[] objs) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> declaredConstructor =
                (classes == null || classes.length == 0) ? clazz.getDeclaredConstructor() :
                                                           clazz.getDeclaredConstructor(classes);
        return (objs == null || objs.length == 0) ? declaredConstructor.newInstance() :
                                                    declaredConstructor.newInstance(objs);
    }

    public static Object newInstance(Constructor<?> constructor, Object[] objs) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        return (objs == null || objs.length == 0) ? constructor.newInstance() :
                                                    constructor.newInstance(objs);
    }

    /**
     * 将Lua中只含整形的表转换为java中的整形数组.
     * @param table 只含整形的表（数组）.
     * @return 转换成Java中的整形数组.
     * @throws LuaException
     */
    public static int[] toIntArray(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        int[] ans = new int[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = (int) l.getLuaObject(table, i + 1).getNumber();
        }
        return ans;
    }

    /**
     * 将Lua中只含整形的表转换为java中的整形数组.
     * @param table 只含整形的表（数组）.
     * @return 转换成Java中的整形数组.
     * @throws LuaException
     */
    public static int[] toIntArray(LuaTable table) throws LuaException {
        int size = table.length();
        int[] ans = new int[size];
        for (int i = 1; i <= size; ++i) {
            ans[i - 1] = table.get(i).toint();
        }
        return ans;
    }

    /**
     * 将Lua中只含浮点数的表转换为java中的double类型数组.
     * @param table 只含小数的表（数组）.
     * @return 转换成Java中的double类型数组.
     * @throws LuaException
     */
    public static double[] toDoubleArray(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        double[] ans = new double[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = l.getLuaObject(table, i + 1).getNumber();
        }
        return ans;
    }

    /**
     * 将Lua中只含浮点数的表转换为java中的double类型数组.
     * @param table 只含小数的表（数组）.
     * @return 转换成Java中的double类型数组.
     * @throws LuaException
     */
    public static double[] toDoubleArray(LuaTable table) throws LuaException {
        int size = table.length();
        double[] ans = new double[size];
        for (int i = 1; i <= size; ++i) {
            ans[i - 1] = table.get(i).todouble();
        }
        return ans;
    }

    /**
     * 将Lua中只含浮点数的表转换为java中的float类型数组.
     * @param table 只含小数的表（数组）.
     * @return 转换成Java中的float类型数组.
     * @throws LuaException
     */
    public static float[] toFloatArray(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        float[] ans = new float[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = (float) l.getLuaObject(table, i + 1).getNumber();
        }
        return ans;
    }

    /**
     * 将Lua中只含浮点数的表转换为java中的float类型数组.
     * @param table 只含小数的表（数组）.
     * @return 转换成Java中的float类型数组.
     * @throws LuaException
     */
    public static float[] toFloatArray(LuaTable table) throws LuaException {
        int size = table.length();
        float[] ans = new float[size];
        for (int i = 1; i <= size; ++i) {
            ans[i - 1] = table.get(i).tofloat();
        }
        return ans;
    }


    /**
     * 将Lua中只含字符串的表转换为java中的String类型数组.
     * @param table 只含字符串的表（数组）.
     * @return 转换成Java中的String类型数组.
     * @throws LuaException
     */
    public static String[] toStringArray(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        String[] ans = new String[size];
        for (int i = 0; i < size; ++i) {
            ans[i] = l.getLuaObject(table, i + 1).getString();
        }
        return ans;
    }

    /**
     * 将Lua中只含字符串的表转换为java中的String类型数组.
     * @param table 只含字符串的表（数组）.
     * @return 转换成Java中的String类型数组.
     * @throws LuaException
     */
    public static String[] toStringArray(LuaTable table) throws LuaException {
        int size = table.length();
        String[] ans = new String[size];
        for (int i = 1; i <= size; ++i) {
            ans[i - 1] = table.get(i).tojstring();
        }
        return ans;
    }

    /**
     * 将Lua中只含指定类型的表转换为java中的指定类型数组.
     * @param t 需要转换成的Java类型实例.
     * @param table 只含指定类型的表（数组）.
     * @return 转换成Java中的指定类型数组.
     * @throws LuaException
     */
    public static <T> T[] toArray(T t, LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        Object array = Array.newInstance(t.getClass(), size);
        for (int i = 0; i < size; ++i) {
            Array.set(array, i, l.getLuaObject(table, i + 1).getObject());
        }

        return (T[]) array;
    }

    /**
     * 将Lua中只含指定类型的表转换为java中的指定类型数组.
     * @param t 需要转换成的Java类型实例.
     * @param table 只含指定类型的表（数组）.
     * @return 转换成Java中的指定类型数组.
     * @throws LuaException
     */
    public static <T> T[] toArray(T t, LuaTable table) throws LuaException {
        int size = table.length();
        Object array = Array.newInstance(t.getClass(), size);
        for (int i = 1; i <= size; ++i) {
            Array.set(array, i - 1, CoerceLuaToJava.coerce(table.get(i), t.getClass()));
        }

        return (T[]) array;
    }

    /**
     * 将Lua中的表(数组)转换为java中的Object类型数组.
     * @param table 表（数组）
     * @return
     * @throws LuaException
     */
    public static Object[] toObjectArray(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        Object[] ans = new Object[size];
        for (int i = 0; i < size; ++i) {
            LuaObject luaObject = l.getLuaObject(table, i + 1);
            Object obj = null;
            if (luaObject.isJavaFunction() || luaObject.isJavaObject() || luaObject.isUserdata()) {
                obj = luaObject.getObject();
            } else if (luaObject.isBoolean()) {
                obj = luaObject.getBoolean();
            } else if (luaObject.isNumber()) {
                obj = luaObject.getNumber();
            } else if (luaObject.isString()) {
                obj = luaObject.getString();
            } else if (luaObject.isTable()) {
                obj = toObjectArray(luaObject);
            }
            ans[i] = obj;
        }
        return ans;
    }

    /**
     * 将Lua中的表(数组)转换为java中的Object类型数组.
     * @param table 表（数组）
     * @return
     */
    public static Object[] toObjectArray(LuaTable table) throws LuaException {
        int size = table.length();
        Object[] ans = new Object[size];
        for (int i = 1; i <= size; ++i) {
            ans[i - 1] = CoerceLuaToJava.coerce(table.get(i), Object.class);
        }
        return ans;
    }

    /**
     * 将Lua中的只包含字符串的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
     * @param table Lua中的表
     * @return Map<String, String>类型HashMap.
     * @throws LuaException
     */
    public static Map<String, String> toStringStringMap(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < size; i += 2) {
            map.put(l.getLuaObject(table, i).getString(), l.getLuaObject(table, i + 1).getString());
        }
        return map;
    }

    /**
     * 将Lua中的只包含字符串的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
     * @param table Lua中的表
     * @return Map<String, String>类型HashMap.
     */
    public static Map<String, String> toStringStringMap(LuaTable table) {
        int size = table.length();
        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= size; i += 2) {
            map.put(table.get(i).tojstring(), table.get(i + 1).tojstring());
        }
        return map;
    }

    /**
     * 将Lua中的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
     * @param table Lua中的表
     * @return Map<Object, Object>类型HashMap.
     */
    public static Map<Object, Object> toObjectObjectMap(LuaObject table) throws LuaException {
        LuaState l = table.getLuaState();
        int size = l.objLen(-1);
        Map<Object, Object> map = new HashMap<>();
        for (int i = 1; i < size; i += 2) {
            map.put(l.getLuaObject(table, i).getString(), l.getLuaObject(table, i + 1).getObject());
        }
        return map;
    }

    /**
     * 将Lua中的数组（下标为数字且未显式指定数字下标的Table）（如{"a", "b"}而非{2 = "b"}）转换为Java中的Map类型.
     * @param table Lua中的表
     * @return Map<Object, Object>类型HashMap.
     */
    public static Map<Object, Object> toObjectObjectMap(LuaTable table) {
        int size = table.length();
        Map<Object, Object> map = new HashMap<>();
        for (int i = 1; i <= size; i += 2) {
            map.put(
                    CoerceLuaToJava.coerce(table.get(i), Object.class),
                    CoerceLuaToJava.coerce(table.get(i + 1), Object.class)
            );
        }
        return map;
    }
}
