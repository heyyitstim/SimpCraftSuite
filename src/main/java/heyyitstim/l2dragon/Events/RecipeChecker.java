package heyyitstim.l2dragon.Events;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ChatUtil;
import heyyitstim.l2dragon.Util.ItemBuilder;
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

    private static final ItemStack SCALE = new ItemBuilder(Material.IRON_NUGGET)
            .setName("&cDragon Scale")
            .addLore("")
            .addLore("&7&oTaken from a slain dragon, this")
            .addLore("&7&oscale hums with magical energy.")
            .addGlow()
            .build();

    private static final ItemStack COMPRESSEDROTTENFLESH = new ItemBuilder(Material.ROTTEN_FLESH)
            .setName("&aCompressed Rotten Flesh")
            .addLore("")
            .addLore("&7&oVery tightly packed meat.")
            .addGlow()
            .build();

    private static final ItemStack SHININGENDERPEARL = new ItemBuilder(Material.ENDER_PEARL)
            .setName("&aShining Ender Pearl")
            .addLore("")
            .addLore("&7&oYou can feel this object pulsing with")
            .addLore("&7&oan arcane energy you don't understand.")
            .addGlow()
            .build();

    private final ArrayList<Material> gearToTransfer = new ArrayList<>(Arrays.asList(
            Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS,
            Material.NETHERITE_SWORD, Material.NETHERITE_PICKAXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_AXE
    ));

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if (e.getRecipe() == null)
            return;

        if (Main.nuggetRecipes.contains(e.getRecipe().getResult())) {
            handleCustomItems(e.getInventory(), Material.IRON_NUGGET, SCALE, true);
            return;
        }

        if (Main.enderPearlRecipes.contains((e.getRecipe().getResult()))) {
            handleCustomItems(e.getInventory(), Material.ENDER_PEARL, SHININGENDERPEARL, false);
            return;
        }

        if (Main.rottenFleshRecipes.contains((e.getRecipe().getResult()))) {
            handleCustomItems(e.getInventory(), Material.ROTTEN_FLESH, COMPRESSEDROTTENFLESH, false);
            return;
        }

        if (isItem(e.getRecipe().getResult(), SHININGENDERPEARL)) {
            handleItemStacks(e.getInventory(), Material.ENDER_PEARL, 16);
        }
    }

    @EventHandler
    public void pickedUp(CraftItemEvent e) {
        if (e.getRecipe() == null)
            return;

        if (isItem(e.getRecipe().getResult(), SHININGENDERPEARL)) {
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

    private void handleItemStacks(CraftingInventory inv, ItemStack compareTo, int amount) {
        Material toCheck = compareTo.getType();
        for (ItemStack item : inv.getMatrix()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == toCheck) {
                if (item.getAmount() != amount || !isItem(item, compareTo)) {
                    inv.setResult(new ItemStack(Material.AIR));
                }
            }
        }
    }

    private void handleCustomItems(CraftingInventory inv, Material toCheck, ItemStack compareTo, boolean transfer) {
        for (ItemStack item : inv.getMatrix()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == toCheck) {
                if (!isItem(item, compareTo)) {
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

    private boolean isItem(ItemStack item, ItemStack compareTo) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore() || !item.getItemMeta().hasDisplayName())
            return false;

        return item.getItemMeta().getDisplayName().equals(compareTo.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(compareTo.getItemMeta().getLore());
    }
}
