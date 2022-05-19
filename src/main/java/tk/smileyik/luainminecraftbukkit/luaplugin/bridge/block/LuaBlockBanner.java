package tk.smileyik.luainminecraftbukkit.luaplugin.bridge.block;

import org.bukkit.DyeColor;
import org.bukkit.block.Banner;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import java.util.Objects;

public class LuaBlockBanner {
  // TODO org.bukkit.block.Banner START
  public String getBaseColor(LuaValue location) {
    Banner block = (Banner)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.getBaseColor().name();
  }

  public void setBaseColor(LuaValue location, String dyeColor) {
    Banner block = (Banner)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    block.setBaseColor(DyeColor.valueOf(dyeColor));
  }

//  public java.util.List getPatterns(LuaValue location) {
//    Banner block = (Banner) LuaValueHelper.toBlock(location).getState();
//    return block.getPatterns();
//  }
//
//  public void setPatterns(LuaValue location, java.util.List arg0) {
//    Banner block = (Banner) LuaValueHelper.toBlock(location).getState();
//    return block.setPatterns();
//  }
//
//  public void addPattern(LuaValue location, org.bukkit.block.banner.Pattern arg0) {
//    Banner block = (Banner) LuaValueHelper.toBlock(location).getState();
//    return block.addPattern();
//  }

  public int numberOfPatterns(LuaValue location) {
    Banner block = (Banner)
            Objects.requireNonNull(LuaValueHelper.toBlock(location)).getState();
    return block.numberOfPatterns();
  }

//  public void setPattern(LuaValue location, int arg0, org.bukkit.block.banner.Pattern arg1) {
//    Banner block = (Banner) LuaValueHelper.toBlock(location).getState();
//    return block.setPattern();
//  }
//
//  public org.bukkit.block.banner.Pattern getPattern(LuaValue location, int arg0) {
//    Banner block = (Banner) LuaValueHelper.toBlock(location).getState();
//    return block.getPattern();
//  }
//
//  public org.bukkit.block.banner.Pattern removePattern(LuaValue location, int arg0) {
//    Banner block = (Banner) LuaValueHelper.toBlock(location).getState();
//    return block.removePattern();
//  }
  // TODO org.bukkit.block.Banner END
}
