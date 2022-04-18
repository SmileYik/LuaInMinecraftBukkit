package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.Material;
import org.bukkit.block.*;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.LuaInMinecraftBukkit;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

public class LuaBlock {
  // TODO BLOCK BEGIN

  public byte getLightFromSky(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getLightFromSky();
  }

  public boolean breakNaturally(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.breakNaturally();
  }

  public boolean breakNaturally(LuaValue location, LuaValue tool) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.breakNaturally(LuaValueHelper.toItemStack(tool));
  }

  public boolean isBlockFaceIndirectlyPowered(LuaValue location, String blockFace) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.isBlockFaceIndirectlyPowered(BlockFace.valueOf(blockFace));
  }

  public LuaValue getDrops(LuaValue location, LuaValue tool) {
    Block block = LuaValueHelper.toBlock(location);

    assert block != null;
    return LuaValueHelper.asList(
            block.getDrops(LuaValueHelper.toItemStack(tool))
    );
  }

  public LuaValue getDrops(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return LuaValueHelper.asList(
            block.getDrops()
    );
  }

  public boolean isBlockPowered(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.isBlockPowered();
  }

  public byte getLightFromBlocks(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getLightFromBlocks();
  }

  public byte getData(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getData();
  }

  public void setType(LuaValue location, String material) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    block.setType(Material.matchMaterial(material));
  }

  public void setType(LuaValue location, String material, boolean applyPhysic) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    block.setType(Material.matchMaterial(material), applyPhysic);
  }

  public boolean isEmpty(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.isEmpty();
  }

  public LuaValue getLocation(LuaValue location, LuaValue loc) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return LuaValueHelper.valueOf(block.getLocation(LuaValueHelper.toLocation(loc)));
  }

  public LuaValue getLocation(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return LuaValueHelper.valueOf(block.getLocation());
  }

  public String getType(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getType().name();
  }

  public int getY(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getY();
  }

  public String getBiome(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getBiome().name();
  }

  public void setBiome(LuaValue location, String biome) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    block.setBiome(Biome.valueOf(biome));
  }

  public double getTemperature(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getTemperature();
  }

  public double getHumidity(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getHumidity();
  }

  public String getWorld(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getWorld().getName();
  }

  public int getX(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getX();
  }

  public int getZ(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getZ();
  }

  public boolean isLiquid(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.isLiquid();
  }

  public LuaValue getRelative(LuaValue location, int modX, int modY, int modZ) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return LuaValueHelper.valueOf(block.getRelative(modX, modY, modZ));
  }

  public LuaValue getRelative(LuaValue location, String blockFace) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return LuaValueHelper.valueOf(block.getRelative(BlockFace.valueOf(blockFace)));
  }

  public LuaValue getRelative(LuaValue location, String blockFace, int distance) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return LuaValueHelper.valueOf(block.getRelative(BlockFace.valueOf(blockFace), distance));
  }

  public int getBlockPower(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getBlockPower();
  }

  public int getBlockPower(LuaValue location, String blockFace) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getBlockPower(BlockFace.valueOf(blockFace));
  }

  public String getPistonMoveReaction(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getPistonMoveReaction().name();
  }


  // TODO CHUNK
//  public org.bukkit.Chunk getChunk(LuaValue location) {
//    Block block = LuaValueHelper.toBlock(location);
//    assert block != null;
//    return block.getChunk();
//  }

  public byte getLightLevel(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    assert block != null;
    return block.getLightLevel();
  }

  public boolean isBlockIndirectlyPowered(LuaValue location) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    assert block != null;
    return block.isBlockIndirectlyPowered();
  }

  public boolean isBlockFacePowered(LuaValue location, String blockFace) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.isBlockFacePowered(BlockFace.valueOf(blockFace));
  }

  public String getFace(LuaValue location, LuaValue other) {
    Block block = LuaValueHelper.toBlock(location);
    assert block != null;
    return block.getFace(LuaValueHelper.toBlock(other)).name();
  }
  // TODO BLOCK END

  // TODO org.bukkit.block.FlowerPot START

//  public org.bukkit.material.MaterialData getContents(LuaValue location) {
//    FlowerPot block = (FlowerPot) LuaValueHelper.toBlock(location).getState();
//    assert block != null;
//    return block.getContents();
//  }
//
//  public void setContents(LuaValue location, org.bukkit.material.MaterialData arg0) {
//    FlowerPot block = (FlowerPot) LuaValueHelper.toBlock(location).getState();
//    assert block != null;
//    return block.setContents();
//  }

  // TODO org.bukkit.block.FlowerPot END



  public void getBlockMethods() {
    List<Class<?>> list = Arrays.asList(
            Sign.class,
            CreatureSpawner.class,
            CommandBlock.class,
            Structure.class,
            Jukebox.class,
            DaylightDetector.class,
            EnchantingTable.class,
            Bed.class,
            EnderChest.class,
            Skull.class,
            Container.class,
            Hopper.class,
            Furnace.class,
            Beacon.class,
            Dropper.class,
            ShulkerBox.class,
            Chest.class,
            Dispenser.class,
            BrewingStand.class,
            Banner.class,
            EndGateway.class,
            Comparator.class
    );
    StringBuilder sb = new StringBuilder();

    list.forEach(it -> {
      sb.append("\n\n  // TODO ").append(it.getTypeName()).append(" START");
      getBlockMethods(sb, it);
      sb.append("\n\n  // TODO ").append(it.getTypeName()).append(" END\n");
    });
    LuaInMinecraftBukkit.writeToFile(sb.toString(), "out.txt");
  }
  public void getBlockMethods(StringBuilder sb, Class<?> entityClass) {
    String className = entityClass.getSimpleName();
    for (Method declaredMethod : entityClass.getDeclaredMethods()) {
      String name = declaredMethod.getName();
      String returnType = declaredMethod.getReturnType().getTypeName();
      sb.append("\n  public ").append(returnType).append(" ").append(name).append("(LuaValue location");
      for (Parameter parameter : declaredMethod.getParameters()) {
        sb.append(", ").append(parameter.getType().getTypeName()).append(" ").append(parameter.getName());
      }
      sb.append(") { \n    ").append(className).append(" block = (").append(className).append(") LuaValueHelper.toBlock(location).getState();\n    ")
              .append("return block.").append(name).append("();\n  }\n");
    }
  }


}
