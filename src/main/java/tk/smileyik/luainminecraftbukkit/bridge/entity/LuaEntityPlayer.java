package tk.smileyik.luainminecraftbukkit.bridge.entity;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import static tk.smileyik.luainminecraftbukkit.bridge.entity.LuaEntity.getEntity;

public class LuaEntityPlayer {
  public String getLocale(String uuid) {
    return ((Player) getEntity(uuid)).getLocale();
  }

//  public InetSocketAddress getAddress(String uuid) {
//    return ((Player) getEntity(uuid)).getAddress();
//  }

  public String getDisplayName(String uuid) {
    return ((Player) getEntity(uuid)).getDisplayName();
  }

  public void playEffect(String uuid, LuaValue location, String effect, Object arg2) {
    ((Player) getEntity(uuid)).playEffect(
            LuaValueHelper.toLocation(location),
            Effect.valueOf(effect),
            arg2
    );
  }

  @Deprecated
  public void playEffect(String uuid, LuaValue location, String effect, int arg2) {
    ((Player) getEntity(uuid)).playEffect(
            LuaValueHelper.toLocation(location),
            Effect.valueOf(effect),
            arg2
    );
  }

  public void playSound(String uuid, LuaValue location, String sound, String soundCategory, float arg3, float arg4) {
    ((Player) getEntity(uuid)).playSound(
            LuaValueHelper.toLocation(location),
            Sound.valueOf(sound),
            SoundCategory.valueOf(soundCategory),
            arg3,
            arg4
    );
  }

  public void playSound(String uuid, LuaValue location, String sound, float arg2, float arg3) {
    ((Player) getEntity(uuid)).playSound(
            LuaValueHelper.toLocation(location),
            Sound.valueOf(sound),
            arg2,
            arg3
    );
  }

  public void spawnParticle(String uuid, String particle, double arg1, double arg2, double arg3, int arg4) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle), arg1, arg2, arg3, arg4
    );
  }

  public void spawnParticle(String uuid, String particle, LuaValue location, int arg2) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle),
            LuaValueHelper.toLocation(location),
            arg2
    );
  }

  public void spawnParticle(String uuid, String particle, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6, double arg7, double arg8) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle), arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8
    );
  }

  public void spawnParticle(String uuid, String particle, LuaValue location, int arg2, double arg3, double arg4, double arg5, double arg6, Object arg7) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle),
            LuaValueHelper.toLocation(location),
            arg2, arg3, arg4, arg5, arg6, arg7
    );
  }

  public void spawnParticle(String uuid, String particle, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6, double arg7, double arg8, Object arg9) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle), arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9
    );
  }

  public void spawnParticle(String uuid, String particle, LuaValue location, int arg2, double arg3, double arg4, double arg5) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle),
            LuaValueHelper.toLocation(location),
            arg2, arg3, arg4, arg5
    );
  }

  public void spawnParticle(String uuid, String particle, LuaValue location, int arg2, double arg3, double arg4, double arg5, double arg6) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle),
            LuaValueHelper.toLocation(location),
            arg2, arg3, arg4, arg5, arg6
    );
  }

  public void spawnParticle(String uuid, String particle, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6, double arg7) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle), arg1, arg2, arg3, arg4, arg5, arg6, arg7
    );
  }

  public void spawnParticle(String uuid, String particle, LuaValue location, int arg2, double arg3, double arg4, double arg5, Object arg6) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle),
            LuaValueHelper.toLocation(location),
            arg2, arg3, arg4, arg5, arg6
    );
  }

  public void spawnParticle(String uuid, String particle, double arg1, double arg2, double arg3, int arg4, double arg5, double arg6, double arg7, Object arg8) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle), arg1, arg2, arg3, arg4, arg5, arg6, arg7
    );
  }

  public void spawnParticle(String uuid, String particle, LuaValue location, int arg2, Object arg3) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle),
            LuaValueHelper.toLocation(location),
            arg2, arg3
    );
  }

  public void spawnParticle(String uuid, String particle, double arg1, double arg2, double arg3, int arg4, Object arg5) {
    ((Player) getEntity(uuid)).spawnParticle(
            Particle.valueOf(particle), arg1, arg2, arg3, arg4, arg5
    );
  }

//  public Scoreboard getScoreboard(String uuid) {
//    return ((Player) getEntity(uuid)).getScoreboard();
//  }

  public void setResourcePack(String uuid, String url) {
    ((Player) getEntity(uuid)).setResourcePack(url);
  }

  public void setResourcePack(String uuid, String url, byte[] hash) {
    ((Player) getEntity(uuid)).setResourcePack(url, hash);
  }

  public long getPlayerTime(String uuid) {
    return ((Player) getEntity(uuid)).getPlayerTime();
  }

//  public void sendMessage(String uuid, BaseComponent[] arg0) {
//    return ((Player) getEntity(uuid)).sendMessage();
//  }
//
//  public void sendMessage(String uuid, BaseComponent arg0) {
//    return ((Player) getEntity(uuid)).sendMessage();
//  }
//
//  public void sendMessage(String uuid, ChatMessageType arg0, BaseComponent[] arg1) {
//    return ((Player) getEntity(uuid)).sendMessage();
//  }

  public boolean getAllowFlight(String uuid) {
    return ((Player) getEntity(uuid)).getAllowFlight();
  }

  public void setAllowFlight(String uuid, boolean flag) {
    ((Player) getEntity(uuid)).setAllowFlight(flag);
  }

  public int getLevel(String uuid) {
    return ((Player) getEntity(uuid)).getLevel();
  }

  public void setLevel(String uuid, int level) {
    ((Player) getEntity(uuid)).setLevel(level);
  }

  public void kickPlayer(String uuid, String why) {
    ((Player) getEntity(uuid)).kickPlayer(why);
  }

  public boolean isSneaking(String uuid) {
    return ((Player) getEntity(uuid)).isSneaking();
  }

  public boolean isSprinting(String uuid) {
    return ((Player) getEntity(uuid)).isSprinting();
  }

  public void setSneaking(String uuid, boolean flag) {
    ((Player) getEntity(uuid)).setSneaking(flag);
  }

  public void setSprinting(String uuid, boolean flag) {
    ((Player) getEntity(uuid)).setSprinting(flag);
  }


  public void setSpectatorTarget(String uuid, String entityUUID) {
    ((Player) getEntity(uuid)).setSpectatorTarget(getEntity(entityUUID));
  }

  public int getFoodLevel(String uuid) {
    return ((Player) getEntity(uuid)).getFoodLevel();
  }

  public void updateInventory(String uuid) {
    ((Player) getEntity(uuid)).updateInventory();
  }

  public void setStatisticEntityType(String uuid, String statistic, String entityType, int arg2) {
    ((Player) getEntity(uuid)).setStatistic(
            Statistic.valueOf(statistic),
            EntityType.valueOf(entityType),
            arg2
    );
  }

  public void setStatisticMaterial(String uuid, String statistic, String material, int arg2) {
    ((Player) getEntity(uuid)).setStatistic(
            Statistic.valueOf(statistic),
            Material.valueOf(material),
            arg2
    );
  }

  public void setStatistic(String uuid, String statistic, int arg1) {
    ((Player) getEntity(uuid)).setStatistic(
            Statistic.valueOf(statistic),
            arg1
    );
  }

  public String getPlayerListName(String uuid) {
    return ((Player) getEntity(uuid)).getPlayerListName();
  }

  public String getPlayerWeather(String uuid) {
    return ((Player) getEntity(uuid)).getPlayerWeather().name();
  }

  public void setPlayerWeather(String uuid, String weatherType) {
    ((Player) getEntity(uuid)).setPlayerWeather(
            WeatherType.valueOf(weatherType)
    );
  }

  public void resetPlayerWeather(String uuid) {
    ((Player) getEntity(uuid)).resetPlayerWeather();
  }

  public void giveExp(String uuid, int exp) {
    ((Player) getEntity(uuid)).giveExp(exp);
  }

  public boolean isFlying(String uuid) {
    return ((Player) getEntity(uuid)).isFlying();
  }

  public void loadData(String uuid) {
    ((Player) getEntity(uuid)).loadData();
  }

  public void setSleepingIgnored(String uuid, boolean arg0) {
    ((Player) getEntity(uuid)).setSleepingIgnored(arg0);
  }

  public boolean isSleepingIgnored(String uuid) {
    return ((Player) getEntity(uuid)).isSleepingIgnored();
  }

//  public void playNote(String uuid, Location arg0, String instrument, Note arg2) {
//    return ((Player) getEntity(uuid)).playNote(
//
//    );
//  }

//  public void playNote(String uuid, Location arg0, byte arg1, byte arg2) {
//    return ((Player) getEntity(uuid)).playNote();
//  }

  public void stopSound(String uuid, String sound, String soundCategory) {
    ((Player) getEntity(uuid)).stopSound(
            Sound.valueOf(sound),
            SoundCategory.valueOf(soundCategory)
    );
  }

  public void stopSound(String uuid, String sound) {
    ((Player) getEntity(uuid)).stopSound(
            Sound.valueOf(sound)
    );
  }

  @Deprecated
  public void sendBlockChange(String uuid, LuaValue location, String material, byte arg2) {
    ((Player) getEntity(uuid)).sendBlockChange(
            LuaValueHelper.toLocation(location),
            Material.matchMaterial(material),
            arg2
    );
  }

  @Deprecated
  public void sendBlockChange(String uuid, LuaValue location, int arg1, byte arg2) {
    ((Player) getEntity(uuid)).sendBlockChange(
            LuaValueHelper.toLocation(location),
            arg1,
            arg2
    );
  }

  public boolean sendChunkChange(String uuid, LuaValue location, int arg1, int arg2, int arg3, byte[] arg4) {
    return ((Player) getEntity(uuid)).sendChunkChange(
            LuaValueHelper.toLocation(location),
            arg1,
            arg2,
            arg3,
            arg4
    );
  }

  public void sendSignChange(String uuid, LuaValue location, LuaValue strs) {
    ((Player) getEntity(uuid)).sendSignChange(
            LuaValueHelper.toLocation(location),
            LuaValueHelper.listToList(strs, LuaValue::tojstring).toArray(new String[0])
    );
  }

//  public void sendMap(String uuid, MapView arg0) {
//    return ((Player) getEntity(uuid)).sendMap();
//  }

  public void setCompassTarget(String uuid, LuaValue location) {
    ((Player) getEntity(uuid)).setCompassTarget(
            LuaValueHelper.toLocation(location)
    );
  }

  public void giveExpLevels(String uuid, int amount) {
    ((Player) getEntity(uuid)).giveExpLevels(amount);
  }

  public float getExp(String uuid) {
    return ((Player) getEntity(uuid)).getExp();
  }

  public void setExp(String uuid, float exp) {
    ((Player) getEntity(uuid)).setExp(exp);
  }

  public int getTotalExperience(String uuid) {
    return ((Player) getEntity(uuid)).getTotalExperience();
  }

  public void setTotalExperience(String uuid, int amount) {
    ((Player) getEntity(uuid)).setTotalExperience(amount);
  }

  public float getExhaustion(String uuid) {
    return ((Player) getEntity(uuid)).getExhaustion();
  }

  public void setExhaustion(String uuid, float arg0) {
    ((Player) getEntity(uuid)).setExhaustion(arg0);
  }

  public float getSaturation(String uuid) {
    return ((Player) getEntity(uuid)).getSaturation();
  }

  public void setSaturation(String uuid, float arg0) {
    ((Player) getEntity(uuid)).setSaturation(arg0);
  }

  public void setFoodLevel(String uuid, int arg0) {
    ((Player) getEntity(uuid)).setFoodLevel(arg0);
  }

  public LuaValue getBedSpawnLocation(String uuid) {
    return LuaValueHelper.valueOf(((Player) getEntity(uuid)).getBedSpawnLocation());
  }

  public void setBedSpawnLocation(String uuid, LuaValue location, boolean arg1) {
    ((Player) getEntity(uuid)).setBedSpawnLocation(
            LuaValueHelper.toLocation(location),
            arg1
    );
  }

  public void setBedSpawnLocation(String uuid, LuaValue location) {
    ((Player) getEntity(uuid)).setBedSpawnLocation(
            LuaValueHelper.toLocation(location)
    );
  }

  public void hidePlayer(String uuid, String playerName) {
    ((Player) getEntity(uuid)).hidePlayer(
            LuaInMinecraftBukkit.getInstance(),
            Bukkit.getPlayerExact(playerName)
    );
  }


  public void showPlayer(String uuid, String playerName) {
    ((Player) getEntity(uuid)).showPlayer(
            LuaInMinecraftBukkit.getInstance(),
            Bukkit.getPlayerExact(playerName)
    );
  }

  public boolean canSee(String uuid, String playerName) {
    return ((Player) getEntity(uuid)).canSee(
            Bukkit.getPlayerExact(playerName)
    );
  }

  public void setFlying(String uuid, boolean flag) {
    ((Player) getEntity(uuid)).setFlying(flag);
  }

  public void setFlySpeed(String uuid, float arg0) {
    ((Player) getEntity(uuid)).setFlySpeed(arg0);
  }

  public void setWalkSpeed(String uuid, float arg0) {
    ((Player) getEntity(uuid)).setWalkSpeed(arg0);
  }

  public float getFlySpeed(String uuid) {
    return ((Player) getEntity(uuid)).getFlySpeed();
  }

  public float getWalkSpeed(String uuid) {
    return ((Player) getEntity(uuid)).getWalkSpeed();
  }

  public void setTexturePack(String uuid, String arg0) {
    ((Player) getEntity(uuid)).setTexturePack(arg0);
  }

//  public void setScoreboard(String uuid, Scoreboard arg0) {
//    return ((Player) getEntity(uuid)).setScoreboard();
//  }

  public boolean isHealthScaled(String uuid) {
    return ((Player) getEntity(uuid)).isHealthScaled();
  }

  public void setHealthScaled(String uuid, boolean arg0) {
    ((Player) getEntity(uuid)).setHealthScaled(arg0);
  }

  public void setHealthScale(String uuid, double arg0) {
    ((Player) getEntity(uuid)).setHealthScale(arg0);
  }

  public double getHealthScale(String uuid) {
    return ((Player) getEntity(uuid)).getHealthScale();
  }

  public String getSpectatorTarget(String uuid) {
    return ((Player) getEntity(uuid)).getSpectatorTarget().getUniqueId().toString();
  }

  public void resetTitle(String uuid) {
    ((Player) getEntity(uuid)).resetTitle();
  }

//  public AdvancementProgress getAdvancementProgress(String uuid, Advancement arg0) {
//    return ((Player) getEntity(uuid)).getAdvancementProgress();
//  }

  public void sendTitle(String uuid, String arg0, String arg1, int arg2, int arg3, int arg4) {
    ((Player) getEntity(uuid)).sendTitle(
            arg0, arg1, arg2, arg3, arg4
    );
  }

  public void sendTitle(String uuid, String arg0, String arg1) {
    ((Player) getEntity(uuid)).sendTitle(arg0, arg1);
  }

  public void awardAchievement(String uuid, String arg0) {
    ((Player) getEntity(uuid)).awardAchievement(Achievement.valueOf(arg0));
  }

  public void removeAchievement(String uuid, String arg0) {
    ((Player) getEntity(uuid)).removeAchievement(Achievement.valueOf(arg0));
  }

  public boolean hasAchievement(String uuid, String arg0) {
    return ((Player) getEntity(uuid)).hasAchievement(Achievement.valueOf(arg0));
  }

  public void incrementStatistic(String uuid, String statistic, String entityType, int arg2) {
    ((Player) getEntity(uuid)).incrementStatistic(
            Statistic.valueOf(statistic),
            EntityType.valueOf(entityType),
            arg2
    );
  }

  public void incrementStatisticMaterial(String uuid, String statistic, String material) {
    ((Player) getEntity(uuid)).incrementStatistic(
            Statistic.valueOf(statistic),
            Material.valueOf(material)
    );
  }

  public void incrementStatistic(String uuid, String statistic, int arg1) {
    ((Player) getEntity(uuid)).incrementStatistic(
            Statistic.valueOf(statistic),
            arg1
    );
  }

  public void incrementStatistic(String uuid, String statistic) {
    ((Player) getEntity(uuid)).incrementStatistic(
            Statistic.valueOf(statistic)
    );
  }

  public void incrementStatisticEntity(String uuid, String statistic, String entityType) {
    ((Player) getEntity(uuid)).incrementStatistic(
            Statistic.valueOf(statistic),
            EntityType.valueOf(entityType)
    );
  }

  public void incrementStatisticMaterial(String uuid, String statistic, String material, int arg2) {
    ((Player) getEntity(uuid)).incrementStatistic(
            Statistic.valueOf(statistic),
            Material.matchMaterial(material)
    );
  }

  public void decrementStatisticMaterial(String uuid, String statistic, String material, int arg2) {
    ((Player) getEntity(uuid)).decrementStatistic(
            Statistic.valueOf(statistic),
            Material.matchMaterial(material)
    );
  }

  public void decrementStatistic(String uuid, String statistic, int arg1) {
    ((Player) getEntity(uuid)).decrementStatistic(
            Statistic.valueOf(statistic),
            arg1
    );
  }

  public void decrementStatistic(String uuid, String statistic, String entityType, int arg2) {
    ((Player) getEntity(uuid)).decrementStatistic(
            Statistic.valueOf(statistic),
            EntityType.valueOf(entityType),
            arg2
    );
  }

  public void decrementStatistic(String uuid, String statistic) {
    ((Player) getEntity(uuid)).decrementStatistic(
            Statistic.valueOf(statistic)
    );
  }

  public void decrementStatisticEntityType(String uuid, String statistic, String entityType) {
    ((Player) getEntity(uuid)).decrementStatistic(
            Statistic.valueOf(statistic),
            EntityType.valueOf(entityType)
    );
  }

  public void decrementStatisticMaterial(String uuid, String statistic, String material) {
    ((Player) getEntity(uuid)).decrementStatistic(
            Statistic.valueOf(statistic),
            Material.matchMaterial(material)
    );
  }

  public int getStatisticEntity(String uuid, String statistic, String entityType) {
    return ((Player) getEntity(uuid)).getStatistic(
            Statistic.valueOf(statistic),
            EntityType.valueOf(entityType)
    );
  }

  public int getStatisticMaterial(String uuid, String statistic, String material) {
    return ((Player) getEntity(uuid)).getStatistic(
            Statistic.valueOf(statistic),
            Material.matchMaterial(material)
    );
  }

  public int getStatistic(String uuid, String statistic) {
    return ((Player) getEntity(uuid)).getStatistic(
            Statistic.valueOf(statistic)
    );
  }

  public void setPlayerTime(String uuid, long arg0, boolean arg1) {
    ((Player) getEntity(uuid)).setPlayerTime(arg0, arg1);
  }

  public long getPlayerTimeOffset(String uuid) {
    return ((Player) getEntity(uuid)).getPlayerTimeOffset();
  }

  public boolean isPlayerTimeRelative(String uuid) {
    return ((Player) getEntity(uuid)).isPlayerTimeRelative();
  }

  public void resetPlayerTime(String uuid) {
    ((Player) getEntity(uuid)).resetPlayerTime();
  }

  public void setDisplayName(String uuid, String arg0) {
    ((Player) getEntity(uuid)).setDisplayName(arg0);
  }

  public void sendRawMessage(String uuid, String arg0) {
    ((Player) getEntity(uuid)).sendRawMessage(arg0);
  }

  public void chat(String uuid, String arg0) {
    ((Player) getEntity(uuid)).chat(arg0);
  }

  public LuaValue getCompassTarget(String uuid) {
    return LuaValueHelper.valueOf(((Player) getEntity(uuid)).getCompassTarget());
  }

  public void setPlayerListName(String uuid, String arg0) {
    ((Player) getEntity(uuid)).setPlayerListName(arg0);
  }

  public boolean performCommand(String uuid, String arg0) {
    return ((Player) getEntity(uuid)).performCommand(arg0);
  }

  public void saveData(String uuid) {
    ((Player) getEntity(uuid)).saveData();
  }

}
