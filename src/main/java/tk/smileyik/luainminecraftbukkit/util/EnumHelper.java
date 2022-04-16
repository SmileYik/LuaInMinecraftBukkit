package tk.smileyik.luainminecraftbukkit.util;

import org.bukkit.Material;
import org.bukkit.Sound;

public class EnumHelper {
  public Material toMaterial(String material) {
    return Material.matchMaterial(material);
  }

  public Sound toSound(String sound) {
    return Sound.valueOf(sound);
  }
}
