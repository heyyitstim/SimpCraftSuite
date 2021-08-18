package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
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
                .addLore("&bAbility: Saving Grace")
                .addLore("&7&oInstantly teleports you to your spawn point.")
                .addLore("&c&oShatters after one use.")
                .addGlow()
                .addStringNBT("scname", "ender_bed")
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
                .addLore("&bAbility: Saving Grace")
                .addLore("&7On death, this item will sacrifice itself")
                .addLore("&7to save you from death by void.")
                .addLore("&c&oShatters after one use.")
                .addStringNBT("scname", "void_crystal")
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
