package tk.smileyik.luainminecraftbukkit.bridge.block.container;

import org.bukkit.block.Dispenser;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockDispenser {
  // TODO org.bukkit.block.Dispenser START

  /**
   * 获取方块远程发射源
   * @param location 目的方块位置.
   * @return 返回方块所在位置
   */
  public LuaValue getBlockProjectileSource(LuaValue location) {
    Dispenser block = (Dispenser)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return LuaValueHelper.valueOf(block.getBlockProjectileSource().getBlock());
  }

  public boolean dispense(LuaValue location) {
    Dispenser block = (Dispenser)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.dispense();
  }
  // TODO org.bukkit.block.Dispenser END
}
