package tk.smileyik.config;

import org.junit.jupiter.api.Test;
import org.keplerproject.luajava.LuaException;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfig;
import tk.smileyik.luainminecraftbukkit.api.luaconfig.LuaConfigEntity;
import tk.smileyik.luainminecraftbukkit.util.NativeLuaLoader;

import java.io.File;
import java.io.IOException;

public class LuaConfigEntityTest {

  static {
    try {
      NativeLuaLoader.initNativeLua(new File("/home/miskyle/workspace/idea-space/LuaInMinecraftBukkt/src/test/resources"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static String script;

  static {
    script = String.join(
            "\n",
            "test:setExpCalculator(",
            "  function (level)",
            "    return level * 2",
            "  end",
            ")",
            "test:setExpCalculator2(",
            "  function (level)",
            "    return level * 1.5",
            "  end",
            ")",
            "test:setA(",
            "  function (level)",
            "    return true",
            "  end",
            ")",
            "test:setB(",
            "  function (level)",
            "    return 'hello'",
            "  end",
            ")",
            "test:setC(",
            "  function (level)",
            "    return test",
            "  end",
            ")",
            "test:setD(",
            "  function (d)",
            "    return function ()",
            "             return d*d",
            "           end",
            "  end",
            ")",
            "test.e = 'aaa'",
            "test.f = function (d)",
            "           return d ^ 0.5",
            "         end"
    );
  }

  @Test
  void luaConfigEntityInsideTest() throws LuaException, IOException {
    LuaConfig config = LuaConfig.loadInsideLuaConfig(script);
    TestEntity testEntity = new TestEntity();
    config.addGlobal("test", testEntity).config();
    System.out.println(testEntity.calculate(10));
    System.out.println(testEntity.calculate(20));
    System.out.println(testEntity.calculate2(10));
    System.out.println(testEntity.calculate2(20));
    System.out.println(testEntity.callA());
    System.out.println(testEntity.callB());
    System.out.println(testEntity.callC());
    System.out.println(testEntity.callD(3.14));
    System.out.println(testEntity.e);
    System.out.println(testEntity.callF(2));
  }

  @Test
  void luaConfigEntityOutsideTest() throws LuaException, IOException {
    LuaConfig config = LuaConfig.loadOutsideLuaConfig(script);
    TestEntity testEntity = new TestEntity();
    config.addGlobal("test", testEntity).config();
    System.out.println(testEntity.calculate(10));
    System.out.println(testEntity.calculate(20));
    System.out.println(testEntity.calculate2(10));
    System.out.println(testEntity.calculate2(20));
    System.out.println(testEntity.callA());
    System.out.println(testEntity.callB());
    System.out.println(testEntity.callC());
    System.out.println(testEntity.callD(3.14));
    System.out.println(testEntity.e);
    System.out.println(testEntity.callF(2));
  }
}

class TestEntity implements LuaConfigEntity {
  private LuaConfig config;
  private Object expCalculator;
  private Object expCalculator2;

  private Object a;

  private Object b;

  private Object c;

  private Object d;

  public String e;

  public Object f;

  public boolean callA() {
    return config.callClosureReturnBoolean(a);
  }

  public String callB() {
    return config.callClosureReturnString(b);
  }

  public TestEntity callC() {
    return (TestEntity) config.callClosureReturnObject(c);
  }

  public double callD(double d) {
    Object temp = config.callClosureReturnClosure(this.d, d);
    return config.callClosureReturnNumber(temp).doubleValue();
  }

  public double callF(double d) {
    return config.callClosureReturnNumber(this.f, d).doubleValue();
  }

  int calculate(int level) {
    return config.callClosureReturnNumber(
            expCalculator, level
    ).intValue();
  }

  float calculate2(int level) {
    return config.callClosureReturnNumber(
            expCalculator2, level
    ).floatValue();
  }

  public void setExpCalculator(Object expCalculator) {
    this.expCalculator = expCalculator;
  }

  public void setExpCalculator2(Object expCalculator2) {
    this.expCalculator2 = expCalculator2;
  }

  public void setA(Object a) {
    this.a = a;
  }

  public void setB(Object b) {
    this.b = b;
  }

  public void setC(Object c) {
    this.c = c;
  }

  public void setD(Object d) {
    this.d = d;
  }

  @Override
  public LuaConfig getLuaConfig() {
    return config;
  }

  @Override
  public void setLuaConfig(LuaConfig luaConfig) {
    this.config = luaConfig;
  }

  @Override
  public String toString() {
    return "TestEntity{" +
            "config=" + config +
            ", expCalculator=" + expCalculator +
            ", expCalculator2=" + expCalculator2 +
            ", a=" + a +
            ", b=" + b +
            ", c=" + c +
            '}';
  }
}
