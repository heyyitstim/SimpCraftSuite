package heyyitstim.scsuite.Events.ArmorEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ScubaArmorHandler implements Listener {

    private boolean checkArmor(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chest = player.getInventory().getChestplate();
        ItemStack legs = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        if (!isGoldenArmor(helmet) || !isGoldenArmor(chest) || !isGoldenArmor(legs) || !isGoldenArmor(boots)) { return false; }

        if (!NBTUtil.isItem("scname", "scuba_helmet", helmet)) { return false; }
        if (!NBTUtil.isItem("scname", "scuba_chestplate", chest)) { return false; }
        if (!NBTUtil.isItem("scname", "scuba_leggings", legs)) { return false; }
        if (!NBTUtil.isItem("scname", "scuba_boots", boots)) { return false; }

        return true;
    }

    private boolean isGoldenArmor(ItemStack item) {
        if (item == null) { return false; }
        return item.getType() == Material.GOLDEN_HELMET || item.getType() == Material.GOLDEN_CHESTPLATE || item.getType() == Material.GOLDEN_LEGGINGS || item.getType() == Material.GOLDEN_BOOTS;
    }

    private void giveWaterBreathing(Player player) {
        if (checkArmor(player)) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 7*24*60*60*20, 0));
        }
    }

    @EventHandler
    private void onEquip(InventoryClickEvent e) {
        if (e.getInventory() instanceof CraftingInventory) {

            Player player = (Player)e.getWhoClicked();

            if (e.getSlot() == 39) {

                InventoryAction action = e.getAction();

                if (action == InventoryAction.PLACE_ALL || action == InventoryAction.PICKUP_ALL || action == InventoryAction.SWAP_WITH_CURSOR) {

                    if (checkArmor(player)) {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        return;
                    }

                    giveWaterBreathing(player);
                }
            }
        }
    }

    public boolean isArmor(ItemStack item) {
        return NBTUtil.isItem("scname", "scuba_helmet", item);
    }
}
