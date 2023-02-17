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
        //ShapedRecipe pocketChest = createPocketChest();

        Main.instance.getServer().addRecipe(enderBed);
        Main.instance.getServer().addRecipe(voidCrystal);
        //Main.instance.getServer().addRecipe(pocketChest);
    }

    private ShapedRecipe createEnderBed() {
        ItemStack enderBed = new ItemBuilder(Material.PURPLE_BED)
                .setName("&5Ender Bed")
                .addLore("")
                .addLore("&bAbility: Instant Transmission")
                .addLore("&7Instantly teleports you to your spawn point.")
                .addLore("&c&oShatters after one use.")
                .addLore("")
                .addLore("&e&lEPIC")
                .addGlow()
                .addStringNBT("scname", "ender_bed")
                .setCustomModelNumber(1).build();

        Main.enderPearlRecipes.add(enderBed);

        ShapedRecipe enderBedRecipe = new ShapedRecipe(NamespacedKey.minecraft("ender_bed"), enderBed);
        enderBedRecipe.shape(
                "   ",
                "XXX",
                "YYY");

        enderBedRecipe.setIngredient('X', Material.PLAYER_HEAD); // compacted ender pearl
        enderBedRecipe.setIngredient('Y', Material.END_STONE); // end stone

        return enderBedRecipe;
    }

    private ShapedRecipe createVoidCrystal() {
        ItemStack voidCrystal = new ItemBuilder(Material.NETHER_STAR)
                .setName("&5Void Crystal")
                .addLore("")
                .addLore("&bAbility: Saving Grace")
                .addLore("&7Upon falling into the void, this item")
                .addLore("&7will sacrifice itself to save")
                .addLore("&7you from death.")
                .addLore("&c&oShatters after one use.")
                .addLore("")
                .addLore("&e&lEPIC")
                .addStringNBT("scname", "void_crystal")
                .setCustomModelNumber(1).build();

        Main.enderPearlRecipes.add(voidCrystal);

        ShapedRecipe voidCrystalRecipe = new ShapedRecipe(NamespacedKey.minecraft("void_crystal"), voidCrystal);
        voidCrystalRecipe.shape(
                "XXX",
                "XZX",
                "XXX");

        voidCrystalRecipe.setIngredient('X', Material.PLAYER_HEAD); // compacted ender pearl
        voidCrystalRecipe.setIngredient('Z', Material.NETHER_STAR);

        return voidCrystalRecipe;
    }
}
