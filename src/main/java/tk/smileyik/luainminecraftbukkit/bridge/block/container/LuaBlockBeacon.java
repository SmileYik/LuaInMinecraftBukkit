package tk.smileyik.luainminecraftbukkit.bridge.block.container;

import org.bukkit.block.Beacon;
import org.bukkit.potion.PotionEffectType;
import org.luaj.vm2.LuaValue;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

public class LuaBlockBeacon {
  // TODO org.bukkit.block.Beacon START
  public int getTier(LuaValue location) {
    Beacon block = (Beacon) LuaValueHelper.toBlock(location).getState();
    return block.getTier();
  }

  public void setPrimaryEffect(LuaValue location, String potionEffectType) {
    Beacon block = (Beacon) LuaValueHelper.toBlock(location).getState();
    block.setPrimaryEffect(PotionEffectType.getByName(potionEffectType));
  }

  public void setSecondaryEffect(LuaValue location, String potionEffectType) {
    Beacon block = (Beacon) LuaValueHelper.toBlock(location).getState();
    block.setSecondaryEffect(PotionEffectType.getByName(potionEffectType));
  }

  public LuaValue getEntitiesInRange(LuaValue location) {
    Beacon block = (Beacon) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.asList(block.getEntitiesInRange(), k -> k.getUniqueId().toString());
  }

  public LuaValue getPrimaryEffect(LuaValue location) {
    Beacon block = (Beacon) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.valueOf(block.getPrimaryEffect());
  }

  public LuaValue getSecondaryEffect(LuaValue location) {
    Beacon block = (Beacon) LuaValueHelper.toBlock(location).getState();
    return LuaValueHelper.valueOf(block.getSecondaryEffect());
  }
  // TODO org.bukkit.block.Beacon END
}
