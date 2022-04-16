package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.Bukkit;
import org.bukkit.SkullType;
import org.bukkit.block.BlockFace;
import org.bukkit.block.Skull;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.UUID;

public class LuaBlockSkull {
  // TODO org.bukkit.block.Skull START
  public boolean hasOwner(LuaValue location) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    return block.hasOwner();
  }

  /**
   * 获取骷髅头的玩家UUID.
   * @param location 骷髅头所在的位置.
   * @return 骷髅头所属于的玩家的UUID.
   */
  public String getOwningPlayer(LuaValue location) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    return block.getOwningPlayer().getUniqueId().toString();
  }

  public void setOwningPlayer(LuaValue location, String playerUUID) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    block.setOwningPlayer(Bukkit.getOfflinePlayer(UUID.fromString(playerUUID)));
  }

  /**
   *
   * @param location
   * @param name
   * @return
   */
  public boolean setOwner(LuaValue location, java.lang.String name) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    return block.setOwner(name);
  }

  public String getOwner(LuaValue location) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    return block.getOwner();
  }

  public String getSkullType(LuaValue location) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    return block.getSkullType().name();
  }

  public void setSkullType(LuaValue location, String skullType) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    block.setSkullType(SkullType.valueOf(skullType));
  }

  public void setSkullRotation(LuaValue location, String blockFace) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    block.setRotation(BlockFace.valueOf(blockFace));
  }

  public String getRotation(LuaValue location) {
    Skull block = (Skull) LuaValueHelper.toBlock(location).getState();
    return block.getRotation().name();
  }
  // TODO org.bukkit.block.Skull END

}
