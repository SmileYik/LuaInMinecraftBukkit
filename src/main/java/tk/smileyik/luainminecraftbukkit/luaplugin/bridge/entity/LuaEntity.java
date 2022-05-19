package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.entity;

import org.bukkit.Bukkit;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LuaEntity {
  private static final Map<String, Entity> uuidEntityMap = new HashMap<>();
  // TODO ADDITION START
  public static Entity getEntity(String uuid) {
    Entity entity = uuidEntityMap.get(uuid);
    return entity == null ? Bukkit.getEntity(UUID.fromString(uuid)) : entity;
  }

  public LuaValue getNativeEntity(String uuid) {
    return CoerceJavaToLua.coerce(getEntity(uuid));
  }

  public LuaValue getNativePlayer(String uuid) {
    return CoerceJavaToLua.coerce((Player) getEntity(uuid));
  }

  public boolean exist(String uuid) {
    return getEntity(uuid) == null;
  }

  public LuaValue getPlayerUUID(String player) {
    Player p = Bukkit.getPlayerExact(player);
    if (p != null) {
      String uuid = p.getUniqueId().toString();
      uuidEntityMap.put(uuid, p);
      return LuaValueHelper.valueOf(uuid);
    }
    return LuaValue.NIL;
  }
  // TODO ADDITION END

  // TODO Entity Start
  public boolean isValid(String uuid) {
    return (getEntity(uuid)).isValid();
  }

  public void remove(String uuid) {
    (getEntity(uuid)).remove();
  }

  public boolean isEmpty(String uuid) {
    return (getEntity(uuid)).isEmpty();
  }

  public LuaValue getLocation(String uuid, Location location) {
    return LuaValueHelper.valueOf(getEntity(uuid).getLocation(location));
  }

  public LuaValue getLocation(String uuid) {
    return LuaValueHelper.valueOf(getEntity(uuid).getLocation());
  }

  public String getType(String uuid) {
    return (getEntity(uuid)).getType().name();
  }

  public LuaValue getNearbyEntities(String uuid, double x, double y, double z) {
    return LuaValueHelper.asList(
            (getEntity(uuid)).getNearbyEntities(x, y, z),
            it -> it.getUniqueId().toString()
    );
  }

  public void playEffect(String uuid, String effect) {
    (getEntity(uuid)).playEffect(EntityEffect.valueOf(effect));
  }

  public String getWorld(String uuid) {
    return (getEntity(uuid)).getWorld().getName();
  }

  public double getWidth(String uuid) {
    return (getEntity(uuid)).getWidth();
  }

  public double getHeight(String uuid) {
    return (getEntity(uuid)).getHeight();
  }

  public LuaValue getVelocity(String uuid) {
    return LuaValueHelper.valueOf(getEntity(uuid).getVelocity());
  }

  public int getMaxFireTicks(String uuid) {
    return (getEntity(uuid)).getMaxFireTicks();
  }

  public LuaValue getScoreboardTags(String uuid) {
    return LuaValueHelper.asList(
            (getEntity(uuid)).getScoreboardTags()
    );
  }

  public boolean addScoreboardTag(String uuid, String tag) {
    return (getEntity(uuid)).addScoreboardTag(tag);
  }

  public boolean removeScoreboardTag(String uuid, String tag) {
    return (getEntity(uuid)).removeScoreboardTag(tag);
  }

  public boolean isSilent(String uuid) {
    return (getEntity(uuid)).isSilent();
  }

  public void setSilent(String uuid, boolean flag) {
    (getEntity(uuid)).setSilent(flag);
  }

  public boolean isInvulnerable(String uuid) {
    return (getEntity(uuid)).isInvulnerable();
  }

  public void setCustomNameVisible(String uuid, boolean flag) {
    (getEntity(uuid)).setCustomNameVisible(flag);
  }

  public String getVehicle(String uuid) {
    return (getEntity(uuid)).getVehicle().getUniqueId().toString();
  }

  public void setInvulnerable(String uuid, boolean flag) {
    (getEntity(uuid)).setInvulnerable(flag);
  }

  public void setVelocity(String uuid, LuaValue vector) {
    (getEntity(uuid)).setVelocity(LuaValueHelper.toVector(vector));
  }

  public boolean teleport(String uuid, String toEntityUUID, String teleportCause) {
    return (getEntity(uuid)).teleport(
            Bukkit.getEntity(UUID.fromString(toEntityUUID)),
            PlayerTeleportEvent.TeleportCause.valueOf(teleportCause)
    );
  }

  public boolean teleport(String uuid, LuaValue location) {
    return getEntity(uuid).teleport(LuaValueHelper.toLocation(location));
  }

  public boolean teleport(String uuid, String toEntityUUID) {
    return (getEntity(uuid)).teleport(
            Bukkit.getEntity(UUID.fromString(toEntityUUID))
    );
  }

  public boolean teleport(String uuid, LuaValue location, String teleportCause) {
    return (getEntity(uuid)).teleport(
            LuaValueHelper.toLocation(location),
            PlayerTeleportEvent.TeleportCause.valueOf(teleportCause)
    );
  }

  public boolean isOnGround(String uuid) {
    return (getEntity(uuid)).isOnGround();
  }

  public int getEntityId(String uuid) {
    return (getEntity(uuid)).getEntityId();
  }

  public int getFireTicks(String uuid) {
    return (getEntity(uuid)).getFireTicks();
  }

  public void setFireTicks(String uuid, int tick) {
    (getEntity(uuid)).setFireTicks(tick);
  }

  public boolean isDead(String uuid) {
    return (getEntity(uuid)).isDead();
  }

  public LuaValue getPassengers(String uuid) {
    return LuaValueHelper.asList(
            (getEntity(uuid)).getPassengers(),
            it -> it.getUniqueId().toString()
    );
  }

  public boolean addPassenger(String uuid, String entityUUID) {
    return (getEntity(uuid)).addPassenger(
            Bukkit.getEntity(UUID.fromString(entityUUID))
    );
  }

  public boolean removePassenger(String uuid, String entityUUID) {
    return (getEntity(uuid)).removePassenger(
            Bukkit.getEntity(UUID.fromString(entityUUID))
    );
  }

  public boolean eject(String uuid) {
    return (getEntity(uuid)).eject();
  }

  public double getFallDistance(String uuid) {
    return (getEntity(uuid)).getFallDistance();
  }

  public void setFallDistance(String uuid, double distance) {
    (getEntity(uuid)).setFallDistance((float) distance);
  }

//  public void setLastDamageCause(String uuid, org.bukkit.event.entity.EntityDamageEvent arg0) {
//    return (getEntity(uuid)).setLastDamageCause();
//  }
//
//  public org.bukkit.event.entity.EntityDamageEvent getLastDamageCause(String uuid) {
//    return (getEntity(uuid)).getLastDamageCause();
//  }

  public String getUniqueId(String uuid) {
    return (getEntity(uuid)).getUniqueId().toString();
  }

  public int getTicksLived(String uuid) {
    return (getEntity(uuid)).getTicksLived();
  }

  public void setTicksLived(String uuid, int tick) {
    (getEntity(uuid)).setTicksLived(tick);
  }

  public boolean isInsideVehicle(String uuid) {
    return (getEntity(uuid)).isInsideVehicle();
  }

  public boolean leaveVehicle(String uuid) {
    return (getEntity(uuid)).leaveVehicle();
  }

  public boolean isCustomNameVisible(String uuid) {
    return (getEntity(uuid)).isCustomNameVisible();
  }

  public void setGlowing(String uuid, boolean flag) {
    (getEntity(uuid)).setGlowing(flag);
  }

  public boolean isGlowing(String uuid) {
    return (getEntity(uuid)).isGlowing();
  }

  public boolean hasGravity(String uuid) {
    return (getEntity(uuid)).hasGravity();
  }

  public void setGravity(String uuid, boolean flag) {
    (getEntity(uuid)).setGravity(flag);
  }

  public int getPortalCooldown(String uuid) {
    return (getEntity(uuid)).getPortalCooldown();
  }

  public void setPortalCooldown(String uuid, int cooldown) {
    (getEntity(uuid)).setPortalCooldown(cooldown);
  }

  public String getPistonMoveReaction(String uuid) {
    return (getEntity(uuid)).getPistonMoveReaction().name();
  }
}
