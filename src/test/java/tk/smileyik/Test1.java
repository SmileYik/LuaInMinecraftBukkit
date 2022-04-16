package tk.smileyik;

import org.bukkit.Bukkit;
import org.junit.Test;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.sql.Connection;
import java.sql.ResultSet;

public class Test1 {

  public static void main(String[] args) {
    String script = Test1.class.getResource("/hello.lua").getFile();
    Globals globals = JsePlatform.standardGlobals();
    LuaValue chunk = globals.loadfile(script);
    chunk.call(LuaValue.valueOf(script));
    Connection con;
  }

  public static void hello(String hello) {
    System.out.println("Hello, " + hello);
  }

  public void hello() {
    System.out.println("Hello !!!!");
  }
}



