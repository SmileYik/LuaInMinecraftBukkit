package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.block;

import org.bukkit.block.Structure;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.block.structure.UsageMode;
import org.bukkit.util.BlockVector;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockStructure {
  // TODO org.bukkit.block.Structure START
  public void setIgnoreEntities(LuaValue location, boolean flag) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setIgnoreEntities(flag);
  }

  public void setShowAir(LuaValue location, boolean flag) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setShowAir(flag);
  }

  public boolean isShowAir(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.isShowAir();
  }

  public void setBoundingBoxVisible(LuaValue location, boolean flag) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setBoundingBoxVisible(flag);
  }

  public boolean isBoundingBoxVisible(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.isBoundingBoxVisible();
  }

  public void setIntegrity(LuaValue location, float integrity) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setIntegrity(integrity);
  }

  public float getIntegrity(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getIntegrity();
  }

  public LuaValue getRelativePosition(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.valueOf(block.getRelativePosition());
  }

  public java.lang.String getStructureName(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getStructureName();
  }

  public void setStructureName(LuaValue location, java.lang.String name) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setStructureName(name);
  }

  public java.lang.String getAuthor(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getAuthor();
  }

  public void setAuthor(LuaValue location, java.lang.String author) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setAuthor(author);
  }

//  public void setAuthor(LuaValue location, String authorUUID) {
//    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
//    return block.setAuthor();
//  }

  public void setRelativePosition(LuaValue location, LuaValue blockVector) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setRelativePosition(new BlockVector(LuaValueHelper.toVector(blockVector)));
  }

  public LuaValue getStructureSize(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.valueOf(block.getStructureSize());
  }

  public void setStructureSize(LuaValue location, LuaValue blockVector) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setStructureSize(new BlockVector(LuaValueHelper.toVector(blockVector)));
  }

  public void setMirror(LuaValue location, String mirror) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setMirror(Mirror.valueOf(mirror));
  }

  public String getMirror(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getMirror().name();
  }

  public void setUsageMode(LuaValue location, String usageMode) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setUsageMode(UsageMode.valueOf(usageMode));
  }

  public String getUsageMode(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getUsageMode().name();
  }

  public boolean isIgnoreEntities(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.isIgnoreEntities();
  }

  public void setSeed(LuaValue location, long seed) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setSeed(seed);
  }

  public void setMetadata(LuaValue location, String metadata) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setMetadata(metadata);
  }

  public java.lang.String getMetadata(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getMetadata();
  }

  public long getSeed(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getSeed();
  }

  public void setRotation(LuaValue location, String structureRotation) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    block.setRotation(StructureRotation.valueOf(structureRotation));
  }

  public String getStructureRotation(LuaValue location) {
    Structure block = (Structure) LuaValueHelper.toBlock(location).getState();
    return block.getRotation().name();
  }
  // TODO org.bukkit.block.Structure END
}
