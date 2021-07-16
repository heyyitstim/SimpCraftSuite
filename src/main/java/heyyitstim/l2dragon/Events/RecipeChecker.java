package heyyitstim.l2dragon.Events;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ChatUtil;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

    private final ArrayList<Material> gearToTransfer = new ArrayList<>(Arrays.asList(
            Material.NETHERITE_HELMET, Material.NETHERITE_CHESTPLATE, Material.NETHERITE_LEGGINGS, Material.NETHERITE_BOOTS,
            Material.NETHERITE_SWORD, Material.NETHERITE_PICKAXE, Material.NETHERITE_SHOVEL, Material.NETHERITE_AXE
    ));

    @EventHandler
    public void onCraft(PrepareItemCraftEvent e) {
        if (e.getRecipe() == null)
            return;

        if (Main.nuggetRecipes.contains(e.getRecipe().getResult())) {
            handleScales(e.getInventory());
        }
    }

    private void handleScales(CraftingInventory inv) {
        for (ItemStack item : inv.getMatrix()) {
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == Material.IRON_NUGGET) {
                if (!isScale(item)) {
                    inv.setResult(new ItemStack(Material.AIR));
                }
            } else if (gearToTransfer.contains(item.getType())) {
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

    private boolean isScale(ItemStack item) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore() || !item.getItemMeta().hasDisplayName()) {
            return false;
        }

        return item.getItemMeta().getDisplayName().equals(SCALE.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(SCALE.getItemMeta().getLore());
    }
}
