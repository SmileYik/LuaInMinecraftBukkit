package tk.smileyik.luainminecraftbukkit.bridge.entity;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.UUID;

import static tk.smileyik.luainminecraftbukkit.bridge.entity.LuaEntity.getEntity;

public class LuaEntityLiving {
  // TODO Living Entity Start

  public boolean isCollidable(String uuid) {
    return ((LivingEntity) getEntity(uuid)).isCollidable();
  }

  // TODO EntityEquipment
//  public org.bukkit.inventory.EntityEquipment getEquipment(String uuid) {
//    return ((LivingEntity) getEntity(uuid)).getEquipment();
//  }

  public boolean hasLineOfSight(String uuid, String entityUUID) {
    return ((LivingEntity) getEntity(uuid)).hasLineOfSight(
            Bukkit.getEntity(UUID.fromString(entityUUID))
    );
  }

  public double getEyeHeight(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getEyeHeight();
  }

  public double getEyeHeight(String uuid, boolean flag) {
    return ((LivingEntity) getEntity(uuid)).getEyeHeight(flag);
  }

  public LuaValue getEyeLocation(String uuid) {
    return LuaValueHelper.valueOf(((LivingEntity) getEntity(uuid)).getEyeLocation());
  }

  public LuaValue getLineOfSight(String uuid, LuaValue materials, int arg1) {
    return LuaValueHelper.asList(((LivingEntity) getEntity(uuid)).getLineOfSight(
            LuaValueHelper.listToSet(materials, k -> Material.matchMaterial(k.tojstring())),
            arg1
    ), LuaValueHelper::valueOf);
  }

  public LuaValue getTargetBlock(String uuid, LuaValue materials, int arg1) {
    return LuaValueHelper.valueOf(((LivingEntity) getEntity(uuid)).getTargetBlock(
            LuaValueHelper.listToSet(materials, k -> Material.matchMaterial(k.tojstring())),
            arg1
    ));
  }

  public LuaValue getLastTwoTargetBlocks(String uuid, LuaValue materials, int arg1) {
    return LuaValueHelper.asList(((LivingEntity) getEntity(uuid)).getLastTwoTargetBlocks(
            LuaValueHelper.listToSet(materials, k -> Material.matchMaterial(k.tojstring())),
            arg1
    ), LuaValueHelper::valueOf);
  }

  public int getRemainingAir(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getRemainingAir();
  }

  public void setRemainingAir(String uuid, int ticks) {
    ((LivingEntity) getEntity(uuid)).setRemainingAir(ticks);
  }

  public int getMaximumAir(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getMaximumAir();
  }

  public void setMaximumAir(String uuid, int ticks) {
    ((LivingEntity) getEntity(uuid)).setMaximumAir(ticks);
  }

  public int getMaximumNoDamageTicks(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getMaximumNoDamageTicks();
  }

  public void setMaximumNoDamageTicks(String uuid, int ticks) {
    ((LivingEntity) getEntity(uuid)).setMaximumNoDamageTicks(ticks);
  }

  public double getLastDamage(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getLastDamage();
  }

  public void setLastDamage(String uuid, double damage) {
    ((LivingEntity) getEntity(uuid)).setLastDamage(damage);
  }

  public int getNoDamageTicks(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getNoDamageTicks();
  }

  public void setNoDamageTicks(String uuid, int ticks) {
    ((LivingEntity) getEntity(uuid)).setNoDamageTicks(ticks);
  }

  /**
   * 获取该实体的杀手
   * @param uuid 目标实体
   * @return 杀手的玩家名
   */
  public String getKiller(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getKiller().getName();
  }

  // TODO 药水
  public boolean addPotionEffect(String uuid, LuaValue effect) {
    return ((LivingEntity) getEntity(uuid)).addPotionEffect(
            LuaValueHelper.toPotionEffect(effect)
    );
  }

  public boolean addPotionEffect(String uuid, LuaValue effect, boolean flag) {
    return ((LivingEntity) getEntity(uuid)).addPotionEffect(
            LuaValueHelper.toPotionEffect(effect),
            flag
    );
  }

  public boolean addPotionEffects(String uuid, LuaValue effects) {
    return ((LivingEntity) getEntity(uuid)).addPotionEffects(
            LuaValueHelper.listToList(effects, LuaValueHelper::toPotionEffect)
    );
  }

  public boolean hasPotionEffect(String uuid, String potionEffectType) {
    return ((LivingEntity) getEntity(uuid)).hasPotionEffect(
            PotionEffectType.getByName(potionEffectType)
    );
  }

  public LuaValue getPotionEffect(String uuid, String potionEffectType) {
    return LuaValueHelper.valueOf(((LivingEntity) getEntity(uuid)).getPotionEffect(
            PotionEffectType.getByName(potionEffectType)
    ));
  }

  public void removePotionEffect(String uuid, String potionEffectType) {
    ((LivingEntity) getEntity(uuid)).removePotionEffect(
            PotionEffectType.getByName(potionEffectType)
    );
  }

  public LuaValue getActivePotionEffects(String uuid) {
    return LuaValueHelper.asList(
            ((LivingEntity) getEntity(uuid)).getActivePotionEffects(),
            LuaValueHelper::valueOf
    );
  }

  public boolean getRemoveWhenFarAway(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getRemoveWhenFarAway();
  }

  public void setRemoveWhenFarAway(String uuid, boolean remove) {
    ((LivingEntity) getEntity(uuid)).setRemoveWhenFarAway(remove);
  }

  public void setCanPickupItems(String uuid, boolean pickup) {
    ((LivingEntity) getEntity(uuid)).setCanPickupItems(pickup);
  }

  public boolean getCanPickupItems(String uuid) {
    return ((LivingEntity) getEntity(uuid)).getCanPickupItems();
  }

  public boolean isLeashed(String uuid) {
    return ((LivingEntity) getEntity(uuid)).isLeashed();
  }

  public String getLeashHolder(String uuid) {
    return ((LivingEntity) getEntity(uuid))
            .getLeashHolder().getUniqueId().toString();
  }

  public boolean setLeashHolder(String uuid, String entityUUID) {
    return ((LivingEntity) getEntity(uuid)).setLeashHolder(
            Bukkit.getEntity(UUID.fromString(entityUUID))
    );
  }

  public boolean isGliding(String uuid) {
    return ((LivingEntity) getEntity(uuid)).isGliding();
  }

  public void setGliding(String uuid, boolean flag) {
    ((LivingEntity) getEntity(uuid)).setGliding(flag);
  }

  public void setAI(String uuid, boolean flag) {
    ((LivingEntity) getEntity(uuid)).setAI(flag);
  }

  public boolean hasAI(String uuid) {
    return ((LivingEntity) getEntity(uuid)).hasAI();
  }

  public void setCollidable(String uuid, boolean flag) {
    ((LivingEntity) getEntity(uuid)).setCollidable(flag);
  }

  // TODO Living Entity End
}
