package tk.smileyik.luainminecraftbukkit.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class ResourceToFile {
  public static void saveResourceToFile(String resource, File to) {
    try (BufferedInputStream bis =
                 new BufferedInputStream(Objects.requireNonNull(
                         ResourceToFile.class.getResourceAsStream(resource)));
         BufferedOutputStream bos =
                 new BufferedOutputStream(Files.newOutputStream(to.toPath()))) {
      byte[] bytes = new byte[8192];
      int len;
      while ((len = bis.read(bytes)) != -1) {
        bos.write(bytes, 0, len);
      }
      bos.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
