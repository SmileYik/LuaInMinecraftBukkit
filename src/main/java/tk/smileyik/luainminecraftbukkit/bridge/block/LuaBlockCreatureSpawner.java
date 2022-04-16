package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockCreatureSpawner {
  // TODO org.bukkit.block.CreatureSpawner START
  public void setSpawnedType(LuaValue location, String entityType) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setSpawnedType(EntityType.valueOf(entityType));
  }

  public String getSpawnedType(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getSpawnedType().name();
  }

  public int getSpawnCount(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getSpawnCount();
  }

  public void setMaxSpawnDelay(LuaValue location, int delay) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setMaxSpawnDelay(delay);
  }

  public void setMinSpawnDelay(LuaValue location, int delay) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setMinSpawnDelay(delay);
  }

  public int getMinSpawnDelay(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getMinSpawnDelay();
  }

  public int getMaxSpawnDelay(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getMaxSpawnDelay();
  }

  public void setSpawnCount(LuaValue location, int spawnCount) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setSpawnCount(spawnCount);
  }

  @Deprecated
  public void setCreatureTypeByName(LuaValue location, String name) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setCreatureTypeByName(name);
  }

  @Deprecated
  public java.lang.String getCreatureTypeName(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getCreatureTypeName();
  }

  public int getMaxNearbyEntities(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getMaxNearbyEntities();
  }

  public void setMaxNearbyEntities(LuaValue location, int maxNearByEntities) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setMaxNearbyEntities(maxNearByEntities);
  }

  public int getRequiredPlayerRange(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getRequiredPlayerRange();
  }

  public void setRequiredPlayerRange(LuaValue location, int requiredPlayerRange) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setRequiredPlayerRange(requiredPlayerRange);
  }

  public int getSpawnRange(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getSpawnRange();
  }

  public void setSpawnRange(LuaValue location, int spawnRange) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setSpawnRange(spawnRange);
  }

  public int getDelay(LuaValue location) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    return block.getDelay();
  }

  public void setDelay(LuaValue location, int delay) {
    CreatureSpawner block = (CreatureSpawner) LuaValueHelper.toBlock(location).getState();
    block.setDelay(delay);
  }
  // TODO org.bukkit.block.CreatureSpawner END
}
