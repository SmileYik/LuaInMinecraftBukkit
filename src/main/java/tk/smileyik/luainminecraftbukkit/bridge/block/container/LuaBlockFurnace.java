package tk.smileyik.luainminecraftbukkit.bridge.block.container;

import org.bukkit.block.Furnace;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockFurnace {
  // TODO org.bukkit.block.Furnace START
  public short getCookTime(LuaValue location) {
    Furnace block = (Furnace)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.getCookTime();
  }

  public void setCookTime(LuaValue location, short time) {
    Furnace block = (Furnace)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    block.setCookTime(time);
  }

  public short getBurnTime(LuaValue location) {
    Furnace block = (Furnace)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.getBurnTime();
  }

  public void setBurnTime(LuaValue location, short time) {
    Furnace block = (Furnace)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    block.setBurnTime(time);
  }
  // TODO org.bukkit.block.Furnace END
}
