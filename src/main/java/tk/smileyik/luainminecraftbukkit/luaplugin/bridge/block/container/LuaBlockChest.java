package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.block.container;

import org.bukkit.block.Chest;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockChest {
  // TODO org.bukkit.block.Chest START
  public LuaValue getBlockInventory(LuaValue location) {
    Chest block = (Chest)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return LuaValueHelper.valueOf(block.getBlockInventory());
  }
  // TODO org.bukkit.block.Chest END
}
