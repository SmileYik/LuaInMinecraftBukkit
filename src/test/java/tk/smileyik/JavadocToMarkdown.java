package tk.smileyik;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class JavadocToMarkdown {

  private static class Doc {
    private String comment;
    private LinkedHashMap<String, String> params = new LinkedHashMap<>();
    private String returnDes;
    private String methodName;
    private LinkedHashMap<String, String> paramsName = new LinkedHashMap<>();
    private String returnType;

    @Override
    public String toString() {
      return "Doc{" +
              "comment='" + comment + '\'' +
              ", params=" + params +
              ", returnDes='" + returnDes + '\'' +
              ", methodName='" + methodName + '\'' +
              ", paramsName=" + paramsName +
              ". returnType=" + returnType +
              '}';
    }
  }


  public static void main(String[] args) throws IOException {
    String outName = "LuaPluginHelper.md";
    String file = "/run/media/smileyik/H/Workspace/Idea-space/LuaInMinecraftBukkt/src/main/java/tk/smileyik/luainminecraftbukkit/luaplugin/util/LuaPluginHelper.java";
    List<String> strings = Files.readAllLines(Paths.get(file));

    List<String> aPart = new ArrayList<>();
    boolean flag = false;
    for (String str : strings) {
      if (flag) {
        String out = aPart.remove(aPart.size() - 1);
        aPart.add(out + str);
        if (str.lastIndexOf(')') != -1) {
          flag = false;
          toMarkdown(aPart);
          aPart = new ArrayList<>();
        }
      } else if (aPart.size() == 0) {
        if (str.replace(" ", "").startsWith("/*")) {
          aPart.add(str.substring(str.lastIndexOf('*') + 1));
        }
      } else {
        aPart.add(str.substring(str.indexOf('*') + 1));
        if (str.replace(" ", "").endsWith("*/")) {
          flag = true;
          aPart.add("");
        }
      }
    }

    File f = new File("/run/media/smileyik/H/Workspace/Idea-space/LuaInMinecraftBukkt/docs", outName);
    if (!f.getParentFile().exists()) {
      f.getParentFile().mkdirs();
    }

    Files.write(f.toPath(), outStr.getBytes(),
            StandardOpenOption.WRITE, StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING);
  }

  public static void toMarkdown(List<String> list) {
    String comment = "";
    int i = 0;
    int lastAt = 0;
    List<String> out = new ArrayList<>();
    for (String str : list) {
      String raw = str.replace(" ", "");
      if (raw.startsWith("@")) {
        out.add(String.join("", list.subList(lastAt, i)));
        lastAt = i;
      } else if (raw.endsWith("/")) {
        break;
      }
      ++i;
    }
    if (lastAt != i) {
      out.add(String.join("", list.subList(lastAt, i)));
    }
    out.add(list.get(list.size() - 1));
    Doc doc = new Doc();
    doc.comment = out.get(0);
    for (i = 1; i < out.size() - 1; ++i) {
      String str = out.get(i);
      String raw = str.substring(str.indexOf('@'));
      if (raw.startsWith("@return")) {
        doc.returnDes = raw.substring(raw.indexOf(' ') + 1);
      } else if (raw.startsWith("@param")) {
        raw = raw.substring(raw.indexOf(' ') + 1);
        doc.params.put(
                raw.substring(0, raw.indexOf(' ')),
                raw.substring(raw.indexOf(' ') + 1)
        );
      }
    }
    String str = out.get(out.size() - 1);
    System.out.println(out);
    String paramsName = str.substring(
            str.lastIndexOf('('),
            str.lastIndexOf(')')
    );
    paramsName = paramsName.substring(1);
    String[] paramsNames = paramsName.split(",");
    System.out.println(Arrays.toString(paramsNames));
    for (String p : paramsNames) {
      if (p.isEmpty()) {
        continue;
      }
      String pa = p.substring(p.lastIndexOf(' ') + 1);
      String paType = p.substring(0, p.lastIndexOf(' '));
      doc.paramsName.put(pa, paType);
    }
    String tmp = str.substring(
            0,
            str.lastIndexOf('(')
    );
    String name = tmp.substring(
            tmp.lastIndexOf(' ') + 1
    );
    tmp = tmp.substring(0, tmp.lastIndexOf(' '));
    doc.returnType = tmp.substring(tmp.lastIndexOf(' ') + 1);
    doc.methodName = name;
    System.out.println(doc);
    toMarkdown(doc);
  }

  static String template;

  static {
    try {
      template = new String(Files.readAllBytes(Paths.get("/run/media/smileyik/H/Workspace/Idea-space/LuaInMinecraftBukkt/src/test/resources/markdown.template")));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static String outStr = "";

  public static void toMarkdown(Doc doc){
    List<String> p_p_t = new ArrayList<>();
    List<String> p_pt_pd = new ArrayList<>();
    for (Map.Entry<String, String> kv : doc.paramsName.entrySet()) {
      p_p_t.add(String.format("%s:%s", kv.getKey(), kv.getValue()).replace(" ", ""));
      p_pt_pd.add(String.format("|%s|**%s**|%s|", kv.getKey(), kv.getValue(),
              doc.params.get(kv.getKey())).replace(" ", ""));
    }


    String str = template
            .replace("${method_name}", doc.methodName)
            .replace("${p:p_t,}", String.join(", ", p_p_t))
            .replace("${comment}", doc.comment)
            .replace("${return_type}", doc.returnType)
            .replace("${return_des}", doc.returnDes == null ? "" : doc.returnDes)
            .replace("${|p|pt|pd|}", String.join("\n", p_pt_pd));
    outStr += "\n" + str;
  }
}
