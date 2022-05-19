package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.block.container;

import org.bukkit.block.ShulkerBox;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockShulkerBox {
  // TODO org.bukkit.block.ShulkerBox START
  public String getColor(LuaValue location) {
    ShulkerBox block = (ShulkerBox)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.getColor().name();
  }
  // TODO org.bukkit.block.ShulkerBox END
}
