package heyyitstim.scsuite.Events;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipeChecker implements Listener {

    private final ArrayList<Material> gearToTransfer = new ArrayList<>(Arrays.asList(
            Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS,
            Material.NETHERITE_SWORD, Material.NETHERITE_PICKAXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_AXE
    ));

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if (e.getRecipe() == null)
            return;

        if (Main.nuggetRecipes.contains(e.getRecipe().getResult())) {
            handleCustomItems(e.getInventory(), Material.IRON_NUGGET, "dragon_scale", true);
        }

        if (Main.enderPearlRecipes.contains((e.getRecipe().getResult()))) {
            handleCustomItems(e.getInventory(), Material.ENDER_PEARL, "shiny_ender_pearl", false);
        }

        if (Main.rottenFleshRecipes.contains((e.getRecipe().getResult()))) {
            handleCustomItems(e.getInventory(), Material.ROTTEN_FLESH, "compressed_rotten_flesh", false);
        }

        if (isItem(e.getRecipe().getResult(), "shiny_ender_pearl")) {
            handleItemStacks(e.getInventory(), Material.ENDER_PEARL, 16);
        }

        if (isItem(e.getRecipe().getResult(), "compacted_shiny_ender_pearl")) {
            handleItemStacks(e.getInventory(), Material.ENDER_EYE, 16, "shiny_ender_pearl");
        }

        if (isItem(e.getRecipe().getResult(), "compressed_rotten_flesh")) {
            handleItemStacks(e.getInventory(), Material.ROTTEN_FLESH, 64);
        }

        if (isItem(e.getRecipe().getResult(), "compressed_string")) {
            handleItemStacks(e.getInventory(), Material.STRING, 64);
        }

        if (isItem(e.getRecipe().getResult(), "compressed_rotten_flesh")) {
            handleItemStacks(e.getInventory(), Material.ROTTEN_FLESH, 64);
        }

        if (isItem(e.getRecipe().getResult(), "compressed_shiny_sugar_cane")) {
            handleItemStacks(e.getInventory(), Material.SUGAR, 1, "shiny_sugar_cane");
        }
    }

    @EventHandler
    public void pickedUp(CraftItemEvent e) {
        if (e.getRecipe().getResult() == null) {
            e.setCancelled(true);
            return;
        }

        if (isItem(e.getRecipe().getResult(), "shining_ender_pearl")) {
            for (ItemStack item : e.getInventory().getMatrix())
                item.setAmount(0);
        }

        if (isItem(e.getRecipe().getResult(), "compacted_shining_ender_pearl")) {
            for (ItemStack item : e.getInventory().getMatrix())
                item.setAmount(0);
        }

        if (isItem(e.getRecipe().getResult(), "compressed_rotten_flesh")) {
            for (ItemStack item : e.getInventory().getMatrix())
                item.setAmount(0);
        }

        if (isItem(e.getRecipe().getResult(), "compressed_string")) {
            for (ItemStack item : e.getInventory().getMatrix())
                item.setAmount(0);
        }
    }

    private void handleItemStacks(CraftingInventory inv, Material compareTo, int amount) {
        for (ItemStack item : inv.getMatrix()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == compareTo) {
                if (item.getAmount() != amount) {
                    inv.setResult(new ItemStack(Material.AIR));
                }
            }
        }
    }

    private void handleItemStacks(CraftingInventory inv, Material compareTo, int amount, String tag) {
        for (ItemStack item : inv.getMatrix()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == compareTo) {
                if (item.getAmount() != amount || !isItem(item, tag)) {
                    inv.setResult(new ItemStack(Material.AIR));
                }
            }
        }
    }

    private void handleCustomItems(CraftingInventory inv, Material toCheck, String tag, boolean transfer) {
        for (ItemStack item : inv.getMatrix()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == toCheck) {
                if (!isItem(item, tag)) {
                    inv.setResult(new ItemStack(Material.AIR));
                }
            } else if (transfer && gearToTransfer.contains(item.getType())) {
                ItemMeta meta = item.getItemMeta();
                Damageable damagedOriginal = (Damageable) meta;

                ItemStack crafting = inv.getResult();

                if (crafting == null) {
                    return;
                }

                ItemMeta craftingMeta = crafting.getItemMeta();
                Damageable damagedNew = (Damageable) craftingMeta;
                damagedNew.setDamage(damagedOriginal.getDamage());

                if (meta.hasEnchants()) {
                    meta.getEnchants().forEach((enchantment, integer) -> craftingMeta.addEnchant(enchantment, integer, true));
                }

                crafting.setItemMeta(craftingMeta);
            }
        }
    }

    private boolean isItem(ItemStack item, String compareTo) {
        return NBTUtil.isItem("scname", compareTo, item);
    }
}