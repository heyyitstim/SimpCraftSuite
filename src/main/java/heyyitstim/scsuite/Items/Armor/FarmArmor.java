package heyyitstim.scsuite.Items.Armor;

import heyyitstim.scsuite.Main;
import org.bukkit.Color;
import org.bukkit.inventory.ShapedRecipe;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class FarmArmor {

    public FarmArmor() {
        registerRecipes();
    }

    public void registerRecipes() {

        ShapedRecipe farmHelmetRecipe = createFarmHelmet();
        ShapedRecipe farmPlateRecipe = createFarmChestplate();
        ShapedRecipe farmLeggingsRecipe = createFarmLeggings();
        ShapedRecipe farmBootsRecipe = createFarmBoots();
        ShapedRecipe farmBootsRecipeAlternate = createFarmBootsAlternate();

        Main.instance.getServer().addRecipe(farmHelmetRecipe);
        Main.instance.getServer().addRecipe(farmPlateRecipe);
        Main.instance.getServer().addRecipe(farmLeggingsRecipe);
        Main.instance.getServer().addRecipe(farmBootsRecipe);
        Main.instance.getServer().addRecipe(farmBootsRecipeAlternate);
    }

    private ShapedRecipe createFarmHelmet() {
        ItemStack farmHelmet = new ItemBuilder(Material.LEATHER_HELMET)
                .setName("&aFarm Helmet")
                .addLore("")
                .addLore("&bFull Set Bonus: Farm Hand")
                .addLore("&7Hoes will not lose durability.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 2, EquipmentSlot.HEAD)
                .addStringNBT("scname", "farm_helmet")
                .setLeatherColor(Color.YELLOW)
                .setCustomModelNumber(1).build();

        ShapedRecipe farmHelmetRecipe = new ShapedRecipe(NamespacedKey.minecraft("farm_helmet"), farmHelmet);
        farmHelmetRecipe.shape(
                "XXX",
                "X X",
                "   ");

        farmHelmetRecipe.setIngredient('X', Material.HAY_BLOCK);

        return farmHelmetRecipe;
    }

    private ShapedRecipe createFarmChestplate() {
        ItemStack farmChestplate = new ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setName("&aFarm Chestplate")
                .addLore("")
                .addLore("&bFull Set Bonus: Farm Hand")
                .addLore("&7Hoes will not lose durability.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 5, EquipmentSlot.CHEST)
                .addStringNBT("scname", "farm_chestplate")
                .setLeatherColor(Color.YELLOW)
                .setCustomModelNumber(1).build();

        ShapedRecipe farmChestplateRecipe = new ShapedRecipe(NamespacedKey.minecraft("farm_chestplate"), farmChestplate);
        farmChestplateRecipe.shape(
                "X X",
                "XXX",
                "XXX");

        farmChestplateRecipe.setIngredient('X', Material.HAY_BLOCK);

        return farmChestplateRecipe;
    }

    private ShapedRecipe createFarmLeggings() {
        ItemStack farmLeggings = new ItemBuilder(Material.LEATHER_LEGGINGS)
                .setName("&aFarm Leggings")
                .addLore("")
                .addLore("&bFull Set Bonus: Farm Hand")
                .addLore("&7Hoes will not lose durability.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 4, EquipmentSlot.LEGS)
                .setLeatherColor(Color.YELLOW)
                .addStringNBT("scname", "farm_chestplate")
                .setCustomModelNumber(1).build();

        ShapedRecipe farmLeggingsRecipe = new ShapedRecipe(NamespacedKey.minecraft("farm_leggings"), farmLeggings);
        farmLeggingsRecipe.shape(
                "XXX",
                "X X",
                "X X");

        farmLeggingsRecipe.setIngredient('X', Material.HAY_BLOCK);

        return farmLeggingsRecipe;
    }

    private ShapedRecipe createFarmBoots() {
        ItemStack farmBoots = new ItemBuilder(Material.LEATHER_BOOTS)
                .setName("&aFarm Boots")
                .addLore("")
                .addLore("&bFull Set Bonus: Farm Hand")
                .addLore("&7Hoes will not lose durability.")
                .addLore("")
                .addLore("&bPiece Bonus: Light Footed")
                .addLore("&7Crops won't trample while wearing.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 1, EquipmentSlot.FEET)
                .addStringNBT("scname", "farm_boots")
                .setLeatherColor(Color.YELLOW)
                .setCustomModelNumber(1).build();

        ShapedRecipe farmBootsRecipe = new ShapedRecipe(NamespacedKey.minecraft("farm_boots"), farmBoots);
        farmBootsRecipe.shape(
                "   ",
                "X X",
                "X X");

        farmBootsRecipe.setIngredient('X', Material.HAY_BLOCK);

        return farmBootsRecipe;
    }

    private ShapedRecipe createFarmBootsAlternate() {
        ItemStack farmBoots = new ItemBuilder(Material.LEATHER_BOOTS)
                .setName("&aFarm Boots")
                .addLore("")
                .addLore("&bFull Set Bonus: Farm Hand")
                .addLore("&7Hoes will not lose durability.")
                .addLore("")
                .addLore("&bPiece Bonus: Light Footed")
                .addLore("&7Crops won't trample while wearing.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 1, EquipmentSlot.FEET)
                .addStringNBT("scname", "farm_boots")
                .setLeatherColor(Color.YELLOW)
                .setCustomModelNumber(1).build();

        ShapedRecipe farmBootsRecipeAlternate = new ShapedRecipe(NamespacedKey.minecraft("farm_boots_alt"), farmBoots);
        farmBootsRecipeAlternate.shape(
                "X X",
                "X X",
                "   ");

        farmBootsRecipeAlternate.setIngredient('X', Material.HAY_BLOCK);

        return farmBootsRecipeAlternate;
    }
}
