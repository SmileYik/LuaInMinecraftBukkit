package tk.smileyik.luainminecraftbukkit.bridge.entity;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LuaEntityHelper {

  public static void start() {
    try {
      ZipFile zipFile = new ZipFile(new File("/home/miskyle/workspace/idea-space/LuaInMinecraftBukkt/server/cache/patched_1.12.2.jar"));
      Enumeration<? extends ZipEntry> entries = zipFile.entries();
      while (entries.hasMoreElements()) {
        ZipEntry zipEntry = entries.nextElement();
        String str = (String) zipEntry.toString();
        if (str.startsWith("org/bukkit/entity")) {
          if (str.split("/").length == 4) {
            String name = zipEntry.getName();
            if (name.contains("$")) {
              continue;
            }
            str = str.substring(0, str.length() - 6);
            str = str.replace("/", ".");
            System.out.println(str);
            try {
              main(Class.forName(str));
            } catch (ClassNotFoundException e) {
              e.printStackTrace();
            }
          }

        }

      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    Package pac = Package.getPackage("org.bukkit.entity");
    for (Class<?> declaredClass : pac.getClass().getDeclaredClasses()) {
      System.out.println(declaredClass);
    }
  }

  public static void main(Class<?> entityClass) {
    StringBuilder sb = new StringBuilder();
    for (Method declaredMethod : entityClass.getDeclaredMethods()) {
      String name = declaredMethod.getName();
      String returnType = declaredMethod.getReturnType().getSimpleName();
      sb.append("\n  public ").append(returnType).append(" ").append(name).append("(String uuid");
      for (Parameter parameter : declaredMethod.getParameters()) {
        sb.append(", ").append(parameter.getType().getSimpleName()).append(" ").append(parameter.getName());
      }
      sb.append(") { \n    ").append("return ((").append(entityClass.getSimpleName()).append(") getEntity(uuid)).").append(name).append("();\n  }\n");
    }
    LuaInMinecraftBukkit.writeToFile(sb.toString(), entityClass.getSimpleName() + ".txt");

  }
}
