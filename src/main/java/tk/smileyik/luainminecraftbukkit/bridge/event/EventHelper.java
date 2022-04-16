package tk.smileyik.luainminecraftbukkit.bridge.event;

import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EventHelper {
  public static void start() {
    try {
      Map<String, String> map = new HashMap<>();
      ZipFile zipFile = new ZipFile(new File("/home/miskyle/workspace/idea-space/LuaInMinecraftBukkt/server/cache/patched_1.12.2.jar"));
      Enumeration<? extends ZipEntry> entries = zipFile.entries();
      while (entries.hasMoreElements()) {
        ZipEntry zipEntry = entries.nextElement();
        String str = (String) zipEntry.toString();
        if (str.startsWith("org/bukkit/event") && str.endsWith(".class")) {
          StringBuilder sb = new StringBuilder();
          String pak = str.substring(0, str.length() - 6).replace("/", ".");
          String root = "tk.smileyik.luainminecraftbukkit.bridge.event";
          String full = root + pak.substring("org/bukkit/event".length());
          String first = full.substring(0, full.lastIndexOf("."));
          String second = full.substring(full.lastIndexOf(".") + 1);
          String filePath = str.substring("org/bukkit/event".length());
          if (filePath.lastIndexOf("/") == -1) {
            filePath += "/";
          }
          filePath = filePath.substring(0, filePath.lastIndexOf("/")) + "/Lua" + second + ".java";

          sb.append("package ").append(first).append(";\n\n");
          sb.append("import org.bukkit.event.EventHandler;\n")
                          .append("import ").append(pak).append(";\n")
                          .append("import tk.smileyik.luainminecraftbukkit.plugin.LuaEvent;\n\n");

          sb.append("public class Lua").append(second).append(" extends LuaEvent<").append(second).append("> {\n\n");
          sb.append("  public Lua").append(second).append("(String id) {super(id);}\n\n");
          sb.append("  @EventHandler\n");
          sb.append("  public void event(").append(second).append(" e) {super.event(e);}\n");
          sb.append("}");

          String fullLuaClass = first + ".Lua" + second;
          String fullBukkitClass = second;
          map.put(fullBukkitClass, fullLuaClass);
          toProperties(map);

          // LuaInMinecraftBukkit.writeToFile(sb.toString(), "test/" + filePath);
        }
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void toProperties(Map<String, String> map) throws IOException {
    Properties properties = new Properties();
    map.forEach(properties::setProperty);
    properties.store(new FileWriter("events.properties"), "events");
  }
}
