package tk.smileyik.luainminecraftbukkit.bridge.block;

import org.bukkit.block.CommandBlock;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockCommandBlock {
  // TODO org.bukkit.block.CommandBlock START
  public void setCommand(LuaValue location, String command) {
    CommandBlock block = (CommandBlock) LuaValueHelper.toBlock(location).getState();
    block.setCommand(command);
  }

  public java.lang.String getName(LuaValue location) {
    CommandBlock block = (CommandBlock) LuaValueHelper.toBlock(location).getState();
    return block.getName();
  }

  public void setName(LuaValue location, String name) {
    CommandBlock block = (CommandBlock) LuaValueHelper.toBlock(location).getState();
    block.setName(name);
  }

  public String getCommand(LuaValue location) {
    CommandBlock block = (CommandBlock) LuaValueHelper.toBlock(location).getState();
    return block.getCommand();
  }
  // TODO org.bukkit.block.CommandBlock END
}
