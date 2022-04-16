package tk.smileyik.luainminecraftbukkit.bridge.block.container;

import org.bukkit.block.Dropper;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockDropper {
  // TODO org.bukkit.block.Dropper START
  public void drop(LuaValue location) {
    Dropper block = (Dropper)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    block.drop();
  }
  // TODO org.bukkit.block.Dropper END
}
