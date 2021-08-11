package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class UtilityItemRecipes {

    public UtilityItemRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe enderBed = createEnderBed();
        ShapedRecipe voidCrystal = createVoidCrystal();

        Main.instance.getServer().addRecipe(enderBed);
        Main.instance.getServer().addRecipe(voidCrystal);
    }

    private ShapedRecipe createEnderBed() {
        ItemStack enderBed = new ItemBuilder(Material.PURPLE_BED)
                .setName("&5Ender Bed")
                .addLore("")
                .addLore("&7&oInstantly teleports the user to their spawn.")
                .addLore("&7&oBreaks after one use.")
                .addGlow()
                .setCustomModelNumber(1).build();

        Main.enderPearlRecipes.add(enderBed);

        ShapedRecipe enderBedRecipe = new ShapedRecipe(NamespacedKey.minecraft("ender_bed"), enderBed);
        enderBedRecipe.shape(
                "   ",
                "XXX",
                "YYY");

        enderBedRecipe.setIngredient('X', Material.ENDER_PEARL); // shining ender pearl
        enderBedRecipe.setIngredient('Y', Material.END_STONE); // end stone

        return enderBedRecipe;
    }

    private ShapedRecipe createVoidCrystal() {
        ItemStack voidCrystal = new ItemBuilder(Material.NETHER_STAR)
                .setName("&6Void Crystal")
                .addLore("")
                .addLore("&7&oA sentient object that will sacrifice itself to")
                .addLore("&7&oprotect you from the ever-hungry void!")
                .addLore("&7&oShatters after one use.")
                .setCustomModelNumber(1).build();

        Main.enderPearlRecipes.add(voidCrystal);

        ShapedRecipe voidCrystalRecipe = new ShapedRecipe(NamespacedKey.minecraft("void_crystal"), voidCrystal);
        voidCrystalRecipe.shape(
                "XXX",
                "XZX",
                "XXX");

        voidCrystalRecipe.setIngredient('X', Material.ENDER_PEARL); // shining ender pearl
        voidCrystalRecipe.setIngredient('Z', Material.NETHER_STAR);

        return voidCrystalRecipe;
    }
}
