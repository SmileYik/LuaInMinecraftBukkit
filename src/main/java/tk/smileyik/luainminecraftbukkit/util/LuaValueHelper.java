package tk.smileyik.luainminecraftbukkit.util;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

import java.util.*;

public class LuaValueHelper {
  public interface LuaValueCastFunction <T, V> {
    V cast(T t);
  }



  public static LuaValue valueOf(ItemStack itemStack) {
    if (itemStack == null) {
      return LuaValue.NIL;
    }
    LuaValue luaValue = LuaValue.tableOf();
    luaValue.set("amount", itemStack.getAmount());
    luaValue.set("type", itemStack.getType().name());
    luaValue.set("durability", itemStack.getDurability());
    if (itemStack.hasItemMeta()) {
      luaValue.set("meta", valueOf(itemStack.getItemMeta()));
    }
    return luaValue;
  }

  public static LuaValue valueOf(ItemMeta itemMeta) {
    if (itemMeta == null) {
      return LuaValue.NIL;
    }
    LuaValue luaValue = LuaValue.tableOf();
    if (itemMeta.hasDisplayName()) {
      luaValue.set("displayName", itemMeta.getDisplayName());
    }
    if (itemMeta.hasLocalizedName()) {
      luaValue.set("localizedName", itemMeta.getLocalizedName());
    }
    if (itemMeta.hasEnchants()) {
      luaValue.set(
              "enchants",
              asTable(
                      itemMeta.getEnchants(),
                      Enchantment::getName,
                      v -> v
              )
      );
    }
    if (itemMeta.hasLore()) {
      luaValue.set("lore", asList(itemMeta.getLore()));
    }

    luaValue.set(
            "itemFlags",
            asList(itemMeta.getItemFlags(), Enum::name)
    );
    luaValue.set("isUnbreakable", valueOf(itemMeta.isUnbreakable()));
    return luaValue;
  }

  public static LuaValue valueOf(Block block) {
    if (block == null) {
      return LuaValue.NIL;
    }
    Location location = block.getLocation();
    return toTable(
            "world", location.getWorld().getName(),
            "x", location.getBlockX(),
            "y", location.getBlockY(),
            "z", location.getBlockZ()
    );
  }

  public static LuaValue valueOf(Location location) {
    if (location == null) {
      return LuaValue.NIL;
    }
    return toTable(
            "world", location.getWorld().getName(),
            "x", location.getX(),
            "y", location.getY(),
            "z", location.getZ(),
            "pitch", location.getPitch(),
            "yaw", location.getYaw()
    );
  }

  public static LuaValue valueOf(Vector vector) {
    if (vector == null) {
      return LuaValue.NIL;
    }
    return toTable(
            "x", vector.getX(),
            "y", vector.getY(),
            "z", vector.getZ()
    );
  }

  public static LuaValue valueOf(Inventory inventory) {
    if (inventory == null) {
      return LuaValue.NIL;
    }
    LuaValue value = LuaValue.tableOf();
    value.set("type", inventory.getType().name());
    if (inventory.getLocation() != null) {
      value.set("location", valueOf(inventory.getLocation()));
    }
    value.set("items", asList(inventory));
    return value;
  }

  public static LuaValue valueOf(PotionEffect potionEffect) {
    LuaValue luaValue = LuaValue.tableOf();
    luaValue.set("amplifier", potionEffect.getAmplifier());
    luaValue.set("duration", potionEffect.getDuration());
    luaValue.set("type", potionEffect.getType().getName());
    luaValue.set("isAmbient", valueOf(potionEffect.isAmbient()));
    luaValue.set("hasParticles", valueOf(potionEffect.hasParticles()));
    luaValue.set("color", valueOf(potionEffect.getColor()));
    return luaValue;
  }

  public static LuaValue valueOf(Color color) {
    LuaValue luaValue = LuaValue.tableOf();
    luaValue.set("r", color.getRed());
    luaValue.set("g", color.getGreen());
    luaValue.set("b", color.getBlue());
    return luaValue;
  }

  public static LuaValue valueOf(String val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(double val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(float val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(short val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(byte val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(boolean val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(long val) {
    return LuaValue.valueOf(val);
  }

  public static LuaValue valueOf(byte[] val) {
    return LuaValue.valueOf(val);
  }


  public static LuaValue valueOf(Object obj) {
    if (obj == null) {
      return LuaValue.NIL;
    } else if (obj instanceof LuaValue) {
      return (LuaValue) obj;
    } else if (obj instanceof String) {
      return LuaValue.valueOf((String) obj);
    } else if (obj instanceof Integer) {
      return LuaValue.valueOf((int) obj);
    } else if (obj instanceof Double) {
      return LuaValue.valueOf((double) obj);
    } else if (obj instanceof Float) {
      return LuaValue.valueOf((double) obj);
    } else if (obj instanceof Boolean) {
      return LuaValue.valueOf((boolean) obj);
    } else if (obj instanceof byte[]) {
      return LuaValue.valueOf((byte[]) obj);
    } else if (obj instanceof ItemStack) {
      return valueOf((ItemStack) obj);
    } else if (obj instanceof Block) {
      return valueOf((Block) obj);
    } else if (obj instanceof Location) {
      return valueOf((Location) obj);
    } else if (obj instanceof Vector) {
      return valueOf((Vector) obj);
    } else if (obj instanceof Inventory) {
      return valueOf((Inventory) obj);
    } else if (obj instanceof Color) {
      return valueOf((Color) obj);
    } else if (obj instanceof PotionEffect) {
      return valueOf((PotionEffect) obj);
    }
    return CoerceJavaToLua.coerce(obj);
  }

  public static PotionEffect toPotionEffect(LuaValue luaValue) {
    if (luaValue.isnil()) {
      return null;
    }

    boolean ambient = true;
    boolean particles = true;
    Color color = null;

    LuaValue luaAmbient = luaValue.get("ambient");
    LuaValue luaParticles = luaValue.get("particles");
    LuaValue luaColor = luaValue.get("color");

    if (!luaAmbient.isnil()) {
      ambient = luaAmbient.toboolean();
    }

    if (!luaParticles.isnil()) {
      particles = luaParticles.toboolean();
    }

    if (!luaColor.isnil()) {
      color = toColor(luaColor);
    }

    return new PotionEffect(
            PotionEffectType.getByName(luaValue.get("type").tojstring()),
            luaValue.get("duration").toint(),
            luaValue.get("amplifier").toint(),
            ambient,
            particles
    );
  }

  public static Color toColor(LuaValue value) {
    if (value.isnil()) {
      return null;
    }
    return Color.fromRGB(
            value.get("r").toint(),
            value.get("g").toint(),
            value.get("b").toint()
    );
  }

  public static Vector toVector(LuaValue value) {
    if (value.isnil()) {
      return null;
    }
    return new Vector(
            value.get("x").tofloat(),
            value.get("y").tofloat(),
            value.get("z").tofloat()
    );
  }

  public static Location toLocation(LuaValue value) {
    if (value.isnil()) {
      return null;
    }
    return new Location(
            Bukkit.getWorld(value.get("world").tojstring()),
            value.get("x").todouble(),
            value.get("y").todouble(),
            value.get("z").todouble(),
            value.get("pitch").tofloat(),
            value.get("yaw").tofloat()
    );
  }

  public static Block toBlock(LuaValue value) {
    if (value.isnil()) {
      return null;
    }
    return Bukkit.getWorld(value.get("world").tojstring()).getBlockAt(
            value.get("x").toint(),
            value.get("y").toint(),
            value.get("z").toint()
    );
  }

  public static ItemStack toItemStack(LuaValue value) {
    if (value.isnil()) {
      return null;
    }
    LuaValue amount = value.get("amount");
    LuaValue type = value.get("type");
    LuaValue durability = value.get("durability");
    ItemStack item;
    int jAmount = 1;
    if (!amount.isnil()) {
      jAmount = amount.toint();
    }
    if (durability.isnil()) {
      item = new ItemStack(Material.valueOf(type.tojstring()), jAmount);
    } else {
      item = new ItemStack(Material.valueOf(type.tojstring()), jAmount, durability.toshort());
    }
    LuaValue meta = value.get("meta");
    if (meta.isnil()) {
      return item;
    }
    ItemMeta itemMeta = item.getItemMeta();
    toItemMeta(itemMeta, value);
    item.setItemMeta(itemMeta);
    return item.clone();
  }

  public static void toItemMeta(ItemMeta itemMeta, LuaValue value) {
    if (value.isnil()) {
      return;
    }
    LuaValue displayName = value.get("displayName");
    LuaValue localizedName = value.get("localizedName");
    LuaValue enchants = value.get("enchants");
    LuaValue lore = value.get("lore");
    LuaValue itemFlags = value.get("itemFlags");
    LuaValue isUnbreakable = value.get("isUnbreakable");

    if (!displayName.isnil()) {
      itemMeta.setDisplayName(displayName.tojstring());
    }
    if (!localizedName.isnil()) {
      itemMeta.setLocalizedName(localizedName.tojstring());
    }
    if (!enchants.isnil()) {
      LuaValue k = LuaValue.NIL;
      while (true) {
        Varargs n = enchants.next(k);
        if ((k = n.arg1()).isnil()) {
          break;
        }
        LuaValue v = n.arg(2);
        itemMeta.addEnchant(
                Enchantment.getByName(k.tojstring()),
                v.toint(),
                true
        );
      }
    }
    if (!lore.isnil()) {
      itemMeta.setLore(listToList(lore, LuaValue::tojstring));
    }
    if (!itemFlags.isnil()) {
      int size = itemFlags.length();
      for (int i = 0; i < size; ++i) {
        itemMeta.addItemFlags(ItemFlag.valueOf(itemFlags.arg(i).tojstring()));
      }
    }
    if (!isUnbreakable.isnil()) {
      itemMeta.setUnbreakable(isUnbreakable.toboolean());
    }
  }


  public static <T, V> LuaValue asList(Iterable<T> iterable, LuaValueCastFunction<T, V> function) {
    List<LuaValue> list = new ArrayList<>();
    iterable.forEach(it -> list.add(valueOf(function.cast(it))));
    return LuaValue.listOf(list.toArray(new LuaValue[0]));
  }

  public static LuaValue asList(Object[] objects) {
    List<LuaValue> list = new ArrayList<>();
    for (Object obj : objects) {
      list.add(valueOf(obj));
    }
    return LuaValue.listOf(list.toArray(new LuaValue[0]));
  }
  public static <T> LuaValue asList(Iterable<T> iterable) {
    List<LuaValue> list = new ArrayList<>();
    iterable.forEach(it -> list.add(valueOf(it)));
    return LuaValue.listOf(list.toArray(new LuaValue[0]));
  }

  public static <K, V> LuaValue asTable(Map<K, V> map,
                                        LuaValueCastFunction<K, String> castK,
                                        LuaValueCastFunction<V, Object> castV) {
    LuaValue value = LuaValue.tableOf();
    map.forEach((itK, itV) -> value.set(
            castK.cast(itK),
            valueOf(castV.cast(itV))
    ));
    return value;
  }

  public static <V> List<V> listToList(LuaValue value, LuaValueCastFunction<LuaValue, V> kCastToVFunction) {
    List<V> list = new ArrayList<>();
    int size = value.length();
    for (int i = 0; i < size; ++i) {
      list.add(kCastToVFunction.cast(value.get(i)));
    }
    return list;
  }

  public static <V> Set<V> listToSet(LuaValue value, LuaValueCastFunction<LuaValue, V> kCastToVFunction) {
    Set<V> set = new HashSet<>();
    int size = value.length();
    for (int i = 0; i < size; ++i) {
      set.add(kCastToVFunction.cast(value.get(i)));
    }
    return set;
  }

  public static LuaValue toTable(Object ... objs) {
    if ((objs.length & 0x1) != 0) {
      throw new RuntimeException("提供的参数必须为偶数个");
    }
    LuaValue value = LuaValue.tableOf();
    for (int i = 1; i < objs.length; i += 2) {
      value.set(objs[i - 1].toString(), valueOf(objs[i]));
    }
    return value;
  }
}
