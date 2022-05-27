package heyyitstim.scsuite.Items.Tools;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Hammer {

    public Hammer() {
        registerRecipes();
    }

    public void registerRecipes() {

        ShapedRecipe hammerRecipe = createHammer();

        Main.instance.getServer().addRecipe(hammerRecipe);
    }

    private ShapedRecipe createHammer() {
        ItemStack hammer = new ItemBuilder(Material.DIAMOND_PICKAXE)
                .setName("&cHammer")
                .addLore("")
                .addLore("&bAbility: Tunnel")
                .addLore("&7Grants the ability to mine")
                .addLore("&7a larger than normal area.")
                .addGlow()
                .hideEnchants()
                .addStringNBT("scname", "hammer")
                .setCustomModelNumber(1).build();

        ShapedRecipe hammerRecipe = new ShapedRecipe(NamespacedKey.minecraft("hammer"), hammer);
        hammerRecipe.shape(
                "XXX",
                " Y ",
                " Y ");

        hammerRecipe.setIngredient('X', Material.DIAMOND_BLOCK);
        hammerRecipe.setIngredient('Y', Material.NETHERITE_INGOT);

        return hammerRecipe;
    }
}
