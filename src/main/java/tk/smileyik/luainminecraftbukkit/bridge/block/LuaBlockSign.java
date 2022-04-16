package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.block.Sign;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockSign {
  // TODO org.bukkit.block.Sign START
  public String getLine(LuaValue location, int index) {
    Sign block = (Sign) LuaValueHelper.toBlock(location).getState();
    return block.getLine(index);
  }

  public void setLine(LuaValue location, int index, String line) {
    Sign block = (Sign) LuaValueHelper.toBlock(location).getState();
    block.setLine(index, line);
  }

  public LuaValue getLines(LuaValue location) {
    Sign block = (Sign) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.asList(block.getLines());
  }
  // TODO org.bukkit.block.Sign END
}
