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
        ShapedRecipe shinySugarCane = createShinySugarCane();
        ShapedRecipe compressedShinySugarCane = createCompressedShinySugarCane();

        Main.instance.getServer().addRecipe(compressedRottenFlesh);
        Main.instance.getServer().addRecipe(shinyEnderPearl);
        Main.instance.getServer().addRecipe(compressedShinyEnderPearl);
        Main.instance.getServer().addRecipe(compressedString);
        Main.instance.getServer().addRecipe(packedHay);
        Main.instance.getServer().addRecipe(tightlyPackedHay);
        Main.instance.getServer().addRecipe(hardenedDiamond);
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

        SkullMeta meta = (SkullMeta)packedHay.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer("Cypiea"));
        packedHay.setItemMeta(meta);

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
                .setCustomModelNumber(1).build();

        SkullMeta meta = (SkullMeta)tightlyPackedHay.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer("Cypiea"));
        tightlyPackedHay.setItemMeta(meta);

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

    private ShapedRecipe createShinySugarCane() {
        ItemStack shinySugarCane = new ItemBuilder(Material.SUGAR_CANE)
                .setName("&aShiny Sugar Cane")
                .addGlow()
                .addStringNBT("scname", "shiny_sugar_cane")
                .setCustomModelNumber(1).build();

        ShapedRecipe shinySugarCaneRecipe = new ShapedRecipe((NamespacedKey.minecraft("shiny_sugar_cane")), shinySugarCane);
        shinySugarCaneRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        shinySugarCaneRecipe.setIngredient('X', Material.SUGAR_CANE);

        return shinySugarCaneRecipe;
    }

    private ShapedRecipe createCompressedShinySugarCane() {
        ItemStack compressedShinySugarCane = new ItemBuilder(Material.SUGAR_CANE)
                .setName("&9Compressed Shiny Sugar Cane")
                .addGlow()
                .addStringNBT("scname", "compressed_shiny_sugar_cane")
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjA2NzA2ZWVjYjJkNTU4YWNlMjdhYmRhMGIwYjdiODAxZDM2ZDE3ZGQ3YTg5MGE5NTIwZGJlNTIyMzc0ZjhhNiJ9fX0=")
                .setCustomModelNumber(1).build();

        ShapedRecipe compressedShinySugarCaneRecipe = new ShapedRecipe((NamespacedKey.minecraft("compressed_shiny_sugar_cane")), compressedShinySugarCane);
        compressedShinySugarCaneRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compressedShinySugarCaneRecipe.setIngredient('X', Material.SUGAR_CANE);

        return compressedShinySugarCaneRecipe;
    }
}
