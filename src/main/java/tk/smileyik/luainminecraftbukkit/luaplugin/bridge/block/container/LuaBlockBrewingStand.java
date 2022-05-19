package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.block.container;

import org.bukkit.block.BrewingStand;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockBrewingStand {
  // TODO org.bukkit.block.BrewingStand START
  public int getBrewingTime(LuaValue location) {
    BrewingStand block = (BrewingStand)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.getBrewingTime();
  }

  public void setBrewingTime(LuaValue location, int arg0) {
    BrewingStand block = (BrewingStand)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    block.setBrewingTime(arg0);
  }

  public void setFuelLevel(LuaValue location, int arg0) {
    BrewingStand block = (BrewingStand)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    block.setFuelLevel(arg0);
  }

  public int getFuelLevel(LuaValue location) {
    BrewingStand block = (BrewingStand)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.getFuelLevel();
  }
  // TODO org.bukkit.block.BrewingStand END
}
