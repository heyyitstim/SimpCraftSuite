package heyyitstim.l2dragon.Events;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeChecker implements Listener {

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
            System.out.println(inv.getMatrix());
            if (item == null || item.getType() == Material.AIR) continue;
            if (item.getType() == Material.IRON_NUGGET) {
                if (!item.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.color("&cDragon Scale"))) {
                    inv.setResult(new ItemStack(Material.AIR));
                }
            } else {
                ItemMeta meta = item.getItemMeta();

                if (meta.hasEnchants()) {
                    ItemStack crafting = inv.getResult();
                    ItemMeta craftingMeta = crafting.getItemMeta();

                    meta.getEnchants().forEach((enchantment, integer) -> craftingMeta.addEnchant(enchantment, integer, true));

                    crafting.setItemMeta(meta);
                }
            }
        }
    }
}
