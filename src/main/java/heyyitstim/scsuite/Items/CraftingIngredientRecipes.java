package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.SkullMeta;

import javax.naming.Name;

public class CraftingIngredientRecipes {

    public CraftingIngredientRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe compressedRottenFlesh = createCompressedRottenFlesh();
        ShapedRecipe shinyEnderPearl = createShinyEnderPearl();
        ShapedRecipe compressedShinyEnderPearl = createCompressedShinyEnderPearl();
        ShapedRecipe compressedString = createCompressedString();
        ShapedRecipe packedHay = createPackedHay();
        ShapedRecipe tightlyPackedHay = createTightlyPackedHay();
        ShapedRecipe hardenedDiamond = createHardenedDiamond();
        ShapedRecipe shinySugar = createShinySugar();
        ShapedRecipe compressedSugarCane = createCompressedSugarCane();

        Main.instance.getServer().addRecipe(compressedRottenFlesh);
        Main.instance.getServer().addRecipe(shinyEnderPearl);
        Main.instance.getServer().addRecipe(compressedShinyEnderPearl);
        Main.instance.getServer().addRecipe(compressedString);
        Main.instance.getServer().addRecipe(packedHay);
        Main.instance.getServer().addRecipe(tightlyPackedHay);
        Main.instance.getServer().addRecipe(hardenedDiamond);
        Main.instance.getServer().addRecipe(shinySugar);
        Main.instance.getServer().addRecipe(compressedSugarCane);
    }

    private ShapedRecipe createCompressedRottenFlesh() {
        ItemStack compressedRottenFlesh = new ItemBuilder(Material.ROTTEN_FLESH)
                .setName("&aCompressed Rotten Flesh")
                .addGlow()
                .addStringNBT("scname", "compressed_rotten_flesh")
                .setCustomModelNumber(1).build();

        ShapedRecipe compressedRottenFleshRecipe = new ShapedRecipe(NamespacedKey.minecraft("compressed_rotten_flesh"), compressedRottenFlesh);
        compressedRottenFleshRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compressedRottenFleshRecipe.setIngredient('X', Material.ROTTEN_FLESH);

        return compressedRottenFleshRecipe;
    }

    private ShapedRecipe createShinyEnderPearl() {
        ItemStack shinyEnderPearl = new ItemBuilder(Material.ENDER_EYE)
                .setName("&aShiny Ender Pearl")
                .addGlow()
                .addStringNBT("scname", "shiny_ender_pearl")
                .setCustomModelNumber(1).build();

        ShapedRecipe shinyEnderPearlRecipe = new ShapedRecipe(NamespacedKey.minecraft("shiny_ender_pearl"), shinyEnderPearl);
        shinyEnderPearlRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        shinyEnderPearlRecipe.setIngredient('X', Material.ENDER_PEARL);

        return shinyEnderPearlRecipe;
    }

    private ShapedRecipe createCompressedShinyEnderPearl() {
        ItemStack compressedShinyEnderPearl = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&9Compacted Shiny Ender Pearl")
                .addGlow()
                .addStringNBT("scname", "compacted_shiny_ender_pearl")
                .setCustomModelNumber(1).build();

        SkullMeta meta = (SkullMeta)compressedShinyEnderPearl.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer("Cypiea"));
        compressedShinyEnderPearl.setItemMeta(meta);

        ShapedRecipe compressedShinyEnderPearlRecipe = new ShapedRecipe((NamespacedKey.minecraft("compressed_shiny_ender_pearl")), compressedShinyEnderPearl);
        compressedShinyEnderPearlRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compressedShinyEnderPearlRecipe.setIngredient('X', Material.ENDER_EYE);

        return compressedShinyEnderPearlRecipe;
    }

    private ShapedRecipe createCompressedString() {
        ItemStack compressedString = new ItemBuilder(Material.WHITE_WOOL)
                .setName("&aCompressed String")
                .addGlow()
                .addStringNBT("scname", "compressed_string")
                .setCustomModelNumber(1).build();


        ShapedRecipe compressedStringRecipe = new ShapedRecipe((NamespacedKey.minecraft("compressed_string")),compressedString);
        compressedStringRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compressedStringRecipe.setIngredient('X', Material.STRING);

        return compressedStringRecipe;
    }

    private ShapedRecipe createPackedHay() {
        ItemStack packedHay = new ItemBuilder(Material.HAY_BLOCK)
                .setName("&aPacked Hay")
                .addGlow()
                .addStringNBT("scname", "packed_hay")
                .setCustomModelNumber(1).build();

        ShapedRecipe packedHayRecipe = new ShapedRecipe((NamespacedKey.minecraft("packed_hay")), packedHay);
        packedHayRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        packedHayRecipe.setIngredient('X', Material.HAY_BLOCK);

        return packedHayRecipe;
    }
    private ShapedRecipe createTightlyPackedHay() {
        ItemStack tightlyPackedHay = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&9Tightly Packed Hay")
                .addGlow()
                .addStringNBT("scname", "tightly_packed_hay")
                .addTexture("http://textures.minecraft.net/texture/768ffd4c3d73f32d39eade310556150ba490e0d934ec4a6923c9ebbabbb9c246")
                .setCustomModelNumber(1).build();

        ShapedRecipe tightlyPackedHayRecipe = new ShapedRecipe((NamespacedKey.minecraft("tightly_packed_hay")), tightlyPackedHay);
        tightlyPackedHayRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        tightlyPackedHayRecipe.setIngredient('X', Material.HAY_BLOCK);

        return tightlyPackedHayRecipe;
    }

    private ShapedRecipe createHardenedDiamond() {
        ItemStack hardenedDiamond = new ItemBuilder(Material.DIAMOND)
                .setName("&9Hardened Diamond")
                .addGlow()
                .addStringNBT("scname", "hardened_diamond")
                .setCustomModelNumber(1).build();

        ShapedRecipe hardenedDiamondRecipe = new ShapedRecipe((NamespacedKey.minecraft("hardened_diamond")), hardenedDiamond);
        hardenedDiamondRecipe.shape(
                "XXX",
                "XYX",
                "XXX");

        hardenedDiamondRecipe.setIngredient('X', Material.DIAMOND);

        return hardenedDiamondRecipe;
    }

    private ShapedRecipe createShinySugar() {
        ItemStack shinySugar = new ItemBuilder(Material.SUGAR)
                .setName("&aShiny Sugar")
                .addGlow()
                .addStringNBT("scname", "shiny_sugar")
                .setCustomModelNumber(1).build();

        ShapedRecipe shinySugarRecipe = new ShapedRecipe((NamespacedKey.minecraft("shiny_sugar")), shinySugar);
        shinySugarRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        shinySugarRecipe.setIngredient('X', Material.SUGAR_CANE);

        return shinySugarRecipe;
    }

    private ShapedRecipe createCompressedSugarCane() {
        ItemStack compressedSugarCane = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&9Compressed Sugar Cane")
                .addGlow()
                .addStringNBT("scname", "compressed_sugar_cane")
                .addTexture("http://textures.minecraft.net/texture/f06706eecb2d558ace27abda0b0b7b801d36d17dd7a890a9520dbe522374f8a6")
                .setCustomModelNumber(1).build();

        ShapedRecipe compressedSugarCaneRecipe = new ShapedRecipe((NamespacedKey.minecraft("compressed_sugar_cane")), compressedSugarCane);
        compressedSugarCaneRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compressedSugarCaneRecipe.setIngredient('X', Material.SUGAR);

        return compressedSugarCaneRecipe;
    }
}
