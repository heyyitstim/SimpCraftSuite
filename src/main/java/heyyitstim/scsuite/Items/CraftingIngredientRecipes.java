package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
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
        ShapedRecipe compactedEnderPearl = createCompactedEnderPearl();
        ShapedRecipe compressedString = createCompressedString();
        ShapedRecipe packedHay = createPackedHay();
        ShapedRecipe shinySugar = createShinySugar();
        ShapedRecipe compressedSugarCane = createCompressedSugarCane();

        Main.instance.getServer().addRecipe(compressedRottenFlesh);
        Main.instance.getServer().addRecipe(shinyEnderPearl);
        Main.instance.getServer().addRecipe(compactedEnderPearl);
        Main.instance.getServer().addRecipe(compressedString);
        Main.instance.getServer().addRecipe(packedHay);
        Main.instance.getServer().addRecipe(shinySugar);
        Main.instance.getServer().addRecipe(compressedSugarCane);
    }

    private ShapedRecipe createCompressedRottenFlesh() {
        ItemStack compressedRottenFlesh = new ItemBuilder(Material.ROTTEN_FLESH)
                .setName("&aCompressed Rotten Flesh")
                //.addGlow()
                .addEnchant(Enchantment.WATER_WORKER, 1)
                .hideEnchants()
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
                //.addGlow()
                .addEnchant(Enchantment.WATER_WORKER, 1)
                .hideEnchants()
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

    private ShapedRecipe createCompactedEnderPearl() {
        ItemStack compactedEnderPearl = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&9Compacted Ender Pearl")
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWNiN2MyMWNjNDNkYzE3Njc4ZWU2ZjE2NTkxZmZhYWIxZjYzN2MzN2Y0ZjZiYmQ4Y2VhNDk3NDUxZDc2ZGI2ZCJ9fX0=")
                .addStringNBT("scname", "compacted_ender_pearl")
                .setCustomModelNumber(1)
                .build();

        /*SkullMeta meta = (SkullMeta)compactedEnderPearl.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer("Cypiea"));
        compactedEnderPearl.setItemMeta(meta);*/

        ShapedRecipe compactedEnderPearlRecipe = new ShapedRecipe((NamespacedKey.minecraft("compacted_ender_pearl")), compactedEnderPearl);
        compactedEnderPearlRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compactedEnderPearlRecipe.setIngredient('X', Material.ENDER_EYE);

        return compactedEnderPearlRecipe;
    }

    private ShapedRecipe createCompressedString() {
        ItemStack compressedString = new ItemBuilder(Material.WHITE_WOOL)
                .setName("&aCompressed String")
                //.addGlow()
                .addEnchant(Enchantment.WATER_WORKER, 1)
                .hideEnchants()
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
        ItemStack packedHay = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&9Packed Hay")
                .addStringNBT("scname", "tightly_packed_hay")
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY4ZmZkNGMzZDczZjMyZDM5ZWFkZTMxMDU1NjE1MGJhNDkwZTBkOTM0ZWM0YTY5MjNjOWViYmFiYmI5YzI0NiJ9fX0=")
                .setCustomModelNumber(1).build();

        ShapedRecipe packedHayRecipe = new ShapedRecipe((NamespacedKey.minecraft("packed_hay")), packedHay);
        packedHayRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        packedHayRecipe.setIngredient('X', Material.HAY_BLOCK);

        return packedHayRecipe;
    }

    private ShapedRecipe createShinySugar() {
        ItemStack shinySugar = new ItemBuilder(Material.SUGAR)
                .setName("&aShiny Sugar")
                //.addGlow()
                .addEnchant(Enchantment.WATER_WORKER, 1)
                .hideEnchants()
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
        ItemStack compressedSugarCane = new ItemBuilder(Material.SUGAR_CANE)
                .setName("&9Compressed Sugar Cane")
                .addStringNBT("scname", "compressed_sugar_cane")
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODYyNGJhY2I1ZjE5ODZlNjQ3N2FiY2U0YWU3ZGNhMTgyMGE1MjYwYjYyMzNiNTViYTFkOWJhOTM2Yzg0YiJ9fX0=")
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
