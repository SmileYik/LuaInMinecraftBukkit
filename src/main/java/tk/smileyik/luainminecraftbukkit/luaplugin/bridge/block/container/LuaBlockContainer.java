package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.block.container;

import org.bukkit.block.Container;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockContainer {
  // TODO org.bukkit.block.Container START

  /**
   * 获取方块的快照物品仓库.
   * @param location 方块位置
   * @return 结构化的物品仓库.
   */
  public LuaValue getSnapshotInventory(LuaValue location) {
    Container block = (Container)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return LuaValueHelper.valueOf(block.getSnapshotInventory());
  }

  /**
   * 获取方块物品仓库.
   * @param location 方块位置
   * @return 结构化的物品仓库.
   */
  public LuaValue getInventory(LuaValue location) {
    Container block = (Container)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return LuaValueHelper.valueOf(block.getInventory());
  }

  /**
   * 更新容器方块的仓库中的物品.
   * @param location 容器方块的位置
   * @param inv 结构化的仓库, 其中"items"键是必须的.
   */
  public void updateInventory(LuaValue location, LuaValue inv) {
    Container block = (Container)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    Inventory inventory = block.getInventory();
    LuaValue items = inv.get("items");
    if (!items.isnil()) {
      inventory.setContents(LuaValueHelper.listToList(
              items, LuaValueHelper::toItemStack
      ).toArray(new ItemStack[0]));
    }
  }
  // TODO org.bukkit.block.Container END
}
