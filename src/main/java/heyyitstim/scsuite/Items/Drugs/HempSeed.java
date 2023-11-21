package heyyitstim.scsuite.Items.Drugs;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class HempSeed {

    public HempSeed() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe hempSeed = createHempSeed();
        Main.instance.getServer().addRecipe(hempSeed);
    }

    private ShapedRecipe createHempSeed() {
        ItemStack hempSeed = new ItemBuilder(Material.WHEAT_SEEDS)
                .setName("&2Hemp Seed")
                .addLore("")
                .addLore("&a&lUNCOMMON")
                .addStringNBT("scname", "hempSeed")
                .setCustomModelNumber(1).build();

        ShapedRecipe hempSeedRecipe = new ShapedRecipe(NamespacedKey.minecraft("hemp_seed"), hempSeed);
        hempSeedRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        hempSeedRecipe.setIngredient('X', Material.MOSS_BLOCK);
        hempSeedRecipe.setIngredient('Y', Material.BONE_MEAL);
        hempSeedRecipe.setIngredient('Z', Material.NETHER_STAR);

        return hempSeedRecipe;
    }
}
