package heyyitstim.scsuite.Items.Armor;

import heyyitstim.scsuite.Main;
import org.bukkit.Color;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ShapedRecipe;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class ScubaSuit {

    public ScubaSuit() {
        registerRecipes();
    }

    public void registerRecipes() {

        ShapedRecipe scubaHelmetRecipe = createScubaHelmet();
        ShapedRecipe scubaPlateRecipe = createScubaChestplate();
        ShapedRecipe scubaLeggingsRecipe = createScubaLeggings();
        ShapedRecipe scubaBootsRecipe = createScubaBoots();
        ShapedRecipe scubaBootsRecipeAlternate = createScubaBootsAlternate();

        Main.instance.getServer().addRecipe(scubaHelmetRecipe);
        Main.instance.getServer().addRecipe(scubaPlateRecipe);
        Main.instance.getServer().addRecipe(scubaLeggingsRecipe);
        Main.instance.getServer().addRecipe(scubaBootsRecipe);
        Main.instance.getServer().addRecipe(scubaBootsRecipeAlternate);
    }

    private ShapedRecipe createScubaHelmet() {
        ItemStack scubaHelmet = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&9Scuba Helmet")
                .addLore("")
                .addLore("&bFull Set Bonus: PUCS")
                .addLore("&7&o(Protective Underwater Crisis Suit)")
                .addLore("&7Breathe underwater for extended periods of time.")
                .addLore("")
                .addLore("&bPiece Bonus: Aquatic Dynamics")
                .addLore("&7Mine faster underwater!")
                .addLore("")
                .addLore("&9&lRARE HELMET")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 2, EquipmentSlot.HEAD)
                .addEnchant(Enchantment.WATER_WORKER, 1)
                .addEnchant(Enchantment.OXYGEN, 6)
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTIxMmVlYWU4MDcyZTdlNDkwMzM0YjA5MzBkOWI2NTM0NmMwMjA4OGRmMTAzZTc5MzA4Y2FlMmM3ZTRmMzY2NSJ9fX0=")
                .addStringNBT("scname", "scuba_helmet")
                .setCustomModelNumber(1).build();

        ShapedRecipe scubaHelmetRecipe = new ShapedRecipe(NamespacedKey.minecraft("scuba_helmet"), scubaHelmet);
        scubaHelmetRecipe.shape(
                "XXX",
                "XYX",
                "   ");

        scubaHelmetRecipe.setIngredient('X', Material.GOLD_BLOCK);
        scubaHelmetRecipe.setIngredient('Y', Material.HEART_OF_THE_SEA);

        return scubaHelmetRecipe;
    }

    private ShapedRecipe createScubaChestplate() {
        ItemStack scubaChestplate = new ItemBuilder(Material.GOLDEN_CHESTPLATE)
                .setName("&9Scuba Chestplate")
                .addLore("")
                .addLore("&bFull Set Bonus: PUCS")
                .addLore("&7&o(Protective Underwater Crisis Suit)")
                .addLore("&7Breathe underwater for extended periods of time.")
                .addLore("")
                .addLore("&9&lRARE CHESTPLATE")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 5, EquipmentSlot.CHEST)
                .addStringNBT("scname", "scuba_chestplate")
                .setCustomModelNumber(1).build();

        ShapedRecipe scubaChestplateRecipe = new ShapedRecipe(NamespacedKey.minecraft("scuba_chestplate"), scubaChestplate);
        scubaChestplateRecipe.shape(
                "X X",
                "XXX",
                "XXX");

        scubaChestplateRecipe.setIngredient('X', Material.GOLD_BLOCK);

        return scubaChestplateRecipe;
    }

    private ShapedRecipe createScubaLeggings() {
        ItemStack scubaLeggings = new ItemBuilder(Material.GOLDEN_LEGGINGS)
                .setName("&9Scuba Leggings")
                .addLore("")
                .addLore("&bFull Set Bonus: PUCS")
                .addLore("&7&o(Protective Underwater Crisis Suit)")
                .addLore("&7Breathe underwater for extended periods of time.")
                .addLore("")
                .addLore("&9&lRARE LEGGINGS")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 4, EquipmentSlot.LEGS)
                .addStringNBT("scname", "scuba_leggings")
                .setCustomModelNumber(1).build();

        ShapedRecipe scubaLeggingsRecipe = new ShapedRecipe(NamespacedKey.minecraft("scuba_leggings"), scubaLeggings);
        scubaLeggingsRecipe.shape(
                "XXX",
                "X X",
                "X X");

        scubaLeggingsRecipe.setIngredient('X', Material.GOLD_BLOCK);

        return scubaLeggingsRecipe;
    }

    private ShapedRecipe createScubaBoots() {
        ItemStack scubaBoots = new ItemBuilder(Material.GOLDEN_BOOTS)
                .setName("&9Scuba Boots")
                .addLore("")
                .addLore("&bFull Set Bonus: PUCS")
                .addLore("&7&o(Protective Underwater Crisis Suit)")
                .addLore("&7Breathe underwater for extended periods of time.")
                .addLore("")
                .addLore("&9&lRARE BOOTS")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 1, EquipmentSlot.FEET)
                .addStringNBT("scname", "scuba_boots")
                .setCustomModelNumber(1).build();

        ShapedRecipe scubaBootsRecipe = new ShapedRecipe(NamespacedKey.minecraft("scuba_boots"), scubaBoots);
        scubaBootsRecipe.shape(
                "   ",
                "X X",
                "X X");

        scubaBootsRecipe.setIngredient('X', Material.GOLD_BLOCK);

        return scubaBootsRecipe;
    }


    private ShapedRecipe createScubaBootsAlternate() {
        ItemStack scubaBoots = new ItemBuilder(Material.GOLDEN_BOOTS)
                .setName("&9Scuba Boots")
                .addLore("")
                .addLore("&bFull Set Bonus: PUCS")
                .addLore("&7&o(Protective Underwater Crisis Suit)")
                .addLore("&7Breathe underwater for extended periods of time.")
                .addLore("")
                .addLore("&9&lRARE BOOTS")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 1, EquipmentSlot.FEET)
                .addStringNBT("scname", "scuba_boots")
                .setCustomModelNumber(1).build();

        ShapedRecipe scubaBootsRecipeAlternate = new ShapedRecipe(NamespacedKey.minecraft("scuba_boots_alt"), scubaBoots);
        scubaBootsRecipeAlternate.shape(
                "X X",
                "X X",
                "   ");

        scubaBootsRecipeAlternate.setIngredient('X', Material.GOLD_BLOCK);

        return scubaBootsRecipeAlternate;
    }
}
