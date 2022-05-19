package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.entity;

import org.bukkit.entity.Damageable;

import static tk.smileyik.luainminecraftbukkit.luaplugin.bridge.entity.LuaEntity.getEntity;

public class LuaEntityDamageable {
  // TODO Damageable start

  @Deprecated
  public double getMaxHealth(String uuid) {
    return ((Damageable) getEntity(uuid)).getMaxHealth();
  }

  public double getHealth(String uuid) {
    return ((Damageable) getEntity(uuid)).getHealth();
  }

  public void setHealth(String uuid, double health) {
    ((Damageable) getEntity(uuid)).setHealth(health);
  }

  public void damage(String uuid, double damage) {
    ((Damageable) getEntity(uuid)).damage(damage);
  }

  public void damage(String uuid, double damage, String entityUUID) {
    ((Damageable) getEntity(uuid)).damage(
            damage,
            getEntity(uuid)
    );
  }

  @Deprecated
  public void setMaxHealth(String uuid, double maxHealth) {
    ((Damageable) getEntity(uuid)).setMaxHealth(maxHealth);
  }

  @Deprecated
  public void resetMaxHealth(String uuid) {
    ((Damageable) getEntity(uuid)).resetMaxHealth();
  }

  // Damageable end
}
