package tk.smileyik.luainminecraftbukkit.bridge.entity;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import tk.smileyik.luainminecraftbukkit.util.LuaValueHelper;

import static tk.smileyik.luainminecraftbukkit.bridge.entity.LuaEntity.getEntity;

public class LuaEntityHumanEntity {

  public boolean isBlocking(String uuid) {
    return ((HumanEntity) getEntity(uuid)).isBlocking();
  }

  public String getName(String uuid) {
    return ((HumanEntity) getEntity(uuid)).getName();
  }

  public void setGameMode(String uuid, String gameMode) {
    ((HumanEntity) getEntity(uuid)).setGameMode(
            GameMode.valueOf(gameMode)
    );
  }

  public GameMode getGameMode(String uuid) {
    return ((HumanEntity) getEntity(uuid)).getGameMode();
  }

  public void closeInventory(String uuid) {
    ((HumanEntity) getEntity(uuid)).closeInventory();
  }

  public boolean isSleeping(String uuid) {
    return ((HumanEntity) getEntity(uuid)).isSleeping();
  }

  public boolean isHandRaised(String uuid) {
    return ((HumanEntity) getEntity(uuid)).isHandRaised();
  }

  @Deprecated
  public String getShoulderEntityLeft(String uuid) {
    return ((HumanEntity) getEntity(uuid))
            .getShoulderEntityLeft().getUniqueId().toString();
  }

  public void setShoulderEntityLeft(String uuid, String entityUUID) {
    ((HumanEntity) getEntity(uuid)).setShoulderEntityLeft(
            getEntity(entityUUID)
    );
  }

  public String getShoulderEntityRight(String uuid) {
    return ((HumanEntity) getEntity(uuid)).getShoulderEntityRight()
            .getUniqueId().toString();
  }

  public void setShoulderEntityRight(String uuid, String entityUUID) {
    ((HumanEntity) getEntity(uuid)).setShoulderEntityRight(
            getEntity(entityUUID)
    );
  }

  public String getMainHand(String uuid) {
    return ((HumanEntity) getEntity(uuid)).getMainHand().name();
  }

  public LuaValue getItemInHand(String uuid) {
    return LuaValueHelper.valueOf(
            ((HumanEntity) getEntity(uuid)).getItemInHand()
    );
  }

  public LuaValue getInventory(String uuid) {
    return LuaValueHelper.valueOf(
            ((HumanEntity) getEntity(uuid)).getInventory()
    );
  }

  // TODO finish player inventory
//  public PlayerInventory getPlayerInventory(String uuid) {
//    return ((HumanEntity) getEntity(uuid)).getInventory();
//  }

  public void setItemInHand(String uuid, LuaValue item) {
    ((HumanEntity) getEntity(uuid)).setItemInHand(
            LuaValueHelper.toItemStack(item)
    );
  }

  public int getExpToLevel(String uuid) {
    return ((HumanEntity) getEntity(uuid)).getExpToLevel();
  }

  public LuaValue getEnderChest(String uuid) {
    return LuaValueHelper.valueOf(
            ((HumanEntity) getEntity(uuid)).getEnderChest()
    );
  }

  /**
   * 更新末影箱中的物品.
   * @param uuid 人类玩家的uuid
   * @param inv 要更新的仓库结构, 其中"items"属性是必要的.
   */
  public void updateEnderChest(String uuid, LuaValue inv) {
    ((HumanEntity) getEntity(uuid)).getEnderChest().setContents(
            LuaValueHelper.listToList(
                    inv.get("items"),
                    LuaValueHelper::toItemStack).toArray(new ItemStack[0])
    );
  }

  public boolean setWindowProperty(String uuid, String property, int arg1) {
    return ((HumanEntity) getEntity(uuid)).setWindowProperty(
            InventoryView.Property.valueOf(property),
            arg1
    );
  }

  // TODO InventoryView
//  public InventoryView getOpenInventory(String uuid) {
//    return ((HumanEntity) getEntity(uuid)).getOpenInventory();
//  }
//
//  public InventoryView openInventory(String uuid, Inventory arg0) {
//    return ((HumanEntity) getEntity(uuid)).openInventory();
//  }
//
//  public void openInventory(String uuid, InventoryView arg0) {
//    return ((HumanEntity) getEntity(uuid)).openInventory();
//  }
//
//  public InventoryView openWorkbench(String uuid, Location arg0, boolean arg1) {
//    return ((HumanEntity) getEntity(uuid)).openWorkbench();
//  }
//
//  public InventoryView openEnchanting(String uuid, Location arg0, boolean arg1) {
//    return ((HumanEntity) getEntity(uuid)).openEnchanting();
//  }
//
//  public InventoryView openMerchant(String uuid, Villager arg0, boolean arg1) {
//    return ((HumanEntity) getEntity(uuid)).openMerchant();
//  }
//
//  public InventoryView openMerchant(String uuid, Merchant arg0, boolean arg1) {
//    return ((HumanEntity) getEntity(uuid)).openMerchant();
//  }

  public LuaValue getItemOnCursor(String uuid) {
    return LuaValueHelper.valueOf(
            ((HumanEntity) getEntity(uuid)).getItemOnCursor()
    );
  }

  public void setItemOnCursor(String uuid, LuaValue item) {
    ((HumanEntity) getEntity(uuid)).setItemOnCursor(
            LuaValueHelper.toItemStack(item)
    );
  }

  public boolean hasCooldown(String uuid, String material) {
    return ((HumanEntity) getEntity(uuid)).hasCooldown(
            Material.matchMaterial(material)
    );
  }

  public int getCooldown(String uuid, String material) {
    return ((HumanEntity) getEntity(uuid)).getCooldown(
            Material.matchMaterial(material)
    );
  }

  public void setCooldown(String uuid, String material, int arg1) {
    ((HumanEntity) getEntity(uuid)).setCooldown(
            Material.matchMaterial(material),
            arg1
    );
  }

  public int getSleepTicks(String uuid) {
    return ((HumanEntity) getEntity(uuid)).getSleepTicks();
  }

  /**
   * 给玩家背包增加一个物品.
   * @param uuid 玩家uuid
   * @param item 要增加的物品
   */
  public void addItem(String uuid, LuaValue item) {
    ((HumanEntity) getEntity(uuid)).getInventory().addItem(
            LuaValueHelper.toItemStack(item)
    );
  }

  /**
   * 给玩家背包增加一个物品, 如果背包满了则会掉在地上.
   * @param uuid 玩家uuid
   * @param item 要增加的物品
   */
  public void addItemAndFullDrop(String uuid, LuaValue item) {
    HumanEntity human = ((HumanEntity) getEntity(uuid));
    human.getInventory().addItem(
            LuaValueHelper.toItemStack(item)
    ).values().forEach(it ->
            human.getWorld().dropItemNaturally(human.getLocation(), it));
  }

  public LuaValue getNativePlayerInventory(String uuid) {
    return CoerceJavaToLua.coerce(((HumanEntity) getEntity(uuid)).getInventory());
  }
}
