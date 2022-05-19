package tk.smileyik;

import org.bukkit.Bukkit;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

public class Test1 {

  public static void main(String[] args) {
    String script = Test1.class.getResource("/hello.lua").getFile();
    Globals globals = JsePlatform.standardGlobals();
    LuaValue chunk = globals.loadfile(script);
    LuaValue call = chunk.call(LuaValue.valueOf(script));

  }

  public static void hello(String hello) {
    System.out.println("Hello, " + hello);
  }

  public static void hello2(Map<Object, Object> obj) {
    System.out.println(obj);
  }

  public void hello() {
    System.out.println("Hello !!!!");
  }
}



