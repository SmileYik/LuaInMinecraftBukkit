package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.block.EndGateway;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockEndGateway {
  // TODO org.bukkit.block.EndGateway START
  public LuaValue getExitLocation(LuaValue location) {
    EndGateway block = (EndGateway) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.valueOf(block.getExitLocation());
  }

  public void setExitLocation(LuaValue location, LuaValue exitLocation) {
    EndGateway block = (EndGateway) LuaValueHelper.toBlock(location).getState();
    block.setExitLocation(LuaValueHelper.toLocation(exitLocation));
  }

  public boolean isExactTeleport(LuaValue location) {
    EndGateway block = (EndGateway) LuaValueHelper.toBlock(location).getState();
    return block.isExactTeleport();
  }

  public void setExactTeleport(LuaValue location, boolean flag) {
    EndGateway block = (EndGateway) LuaValueHelper.toBlock(location).getState();
    block.setExactTeleport(flag);
  }
  // TODO org.bukkit.block.EndGateway END
}
