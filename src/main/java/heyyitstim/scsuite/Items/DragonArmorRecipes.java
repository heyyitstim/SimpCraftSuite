package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class DragonArmorRecipes {

    public DragonArmorRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {

        // Dragon Helmet
        ShapedRecipe dragonHelmetRecipe = createDragonHelmet();
        // Dragon Chestplate
        ShapedRecipe dragonPlateRecipe = createDragonChestplate();
        // Dragon Leggings
        ShapedRecipe dragonLeggingsRecipe = createDragonLeggings();
        // Dragon Boots
        ShapedRecipe dragonBootsRecipe = createDragonBoots();
        // Dragon Boots Alternate
        ShapedRecipe dragonBootsAlternateRecipe = createDragonBootsAlternate();

        Main.instance.getServer().addRecipe(dragonHelmetRecipe);
        Main.instance.getServer().addRecipe(dragonPlateRecipe);
        Main.instance.getServer().addRecipe(dragonLeggingsRecipe);
        Main.instance.getServer().addRecipe(dragonBootsRecipe);
        Main.instance.getServer().addRecipe(dragonBootsAlternateRecipe);
    }

    private ShapedRecipe createDragonHelmet() {
        ItemStack dragonHelmet = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&dDragon Scale Helmet")
                .addLore("")
                .addLore("&d&lMAGICAL HELMET")
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGMxZTJkNGJkMzllYTI1M2RkYTZhMzZmNmJjMzUyZjY5ZWYxNjlmYWNjMmI3Njc3OThjMTgxNmFhZjcwZjQ5OCJ9fX0=")
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.HEAD)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 4, EquipmentSlot.HEAD)
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 5, EquipmentSlot.HEAD)
                .addStringNBT("scname", "dragon_helmet")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonHelmet);

        ShapedRecipe dragonHelmetRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_helmet"), dragonHelmet);
        dragonHelmetRecipe.shape(
                "XXX",
                "XZX",
                "   ");

        dragonHelmetRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonHelmetRecipe.setIngredient('Z', Material.NETHERITE_HELMET);

        return dragonHelmetRecipe;
    }

    private ShapedRecipe createDragonChestplate() {
        ItemStack dragonPlate = new ItemBuilder(Material.LEATHER_CHESTPLATE)
                .setName("&dDragon Scale Chestplate")
                .addLore("")
                .addLore("&d&lMAGICAL CHESTPLATE")
                .setLeatherColor(Color.BLACK)
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.CHEST)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 4, EquipmentSlot.CHEST)
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 10, EquipmentSlot.CHEST)
                .addStringNBT("scname", "dragon_chestplate")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonPlate);

        ShapedRecipe dragonPlateRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_chestplate"), dragonPlate);
        dragonPlateRecipe.shape(
                "XXX",
                "XZX",
                "XXX");

        dragonPlateRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonPlateRecipe.setIngredient('Z', Material.NETHERITE_CHESTPLATE);

        return dragonPlateRecipe;
    }

    private ShapedRecipe createDragonLeggings() {
        ItemStack dragonLeggings = new ItemBuilder(Material.LEATHER_LEGGINGS)
                .setName("&dDragon Scale Greaves")
                .addLore("")
                .addLore("&d&lMAGICAL LEGGINGS")
                .setLeatherColor(Color.BLACK)
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.LEGS)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 4, EquipmentSlot.LEGS)
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 8, EquipmentSlot.LEGS)
                .addStringNBT("scname", "dragon_leggings")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonLeggings);

        ShapedRecipe dragonLeggingsRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_leggings"), dragonLeggings);
        dragonLeggingsRecipe.shape(
                "XXX",
                "XZX",
                "X X");

        dragonLeggingsRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonLeggingsRecipe.setIngredient('Z', Material.NETHERITE_LEGGINGS);

        return dragonLeggingsRecipe;
    }

    private ShapedRecipe createDragonBoots() {
        ItemStack dragonBoots = new ItemBuilder(Material.LEATHER_BOOTS)
                .setName("&dDragon Scale Boots")
                .addLore("")
                .addLore("&d&lMAGICAL BOOTS")
                .setLeatherColor(Color.BLACK)
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 4, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 5, EquipmentSlot.FEET)
                .addStringNBT("scname", "dragon_boots")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonBoots);

        ShapedRecipe dragonBootsRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_boots"), dragonBoots);
        dragonBootsRecipe.shape(
                "XZX",
                "X X",
                "   ");

        dragonBootsRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonBootsRecipe.setIngredient('Z', Material.NETHERITE_BOOTS);

        return dragonBootsRecipe;
    }

    private ShapedRecipe createDragonBootsAlternate() {
        ItemStack dragonBootsAlternate = new ItemBuilder(Material.LEATHER_BOOTS)
                .setName("&dDragon Scale Boots")
                .addLore("")
                .addLore("&d&lMAGICAL BOOTS")
                .setLeatherColor(Color.BLACK)
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 4, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 5, EquipmentSlot.FEET)
                .addStringNBT("scname", "dragon_boots_alternate")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonBootsAlternate);

        ShapedRecipe dragonBootsAlternateRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_boots_alt"), dragonBootsAlternate);
        dragonBootsAlternateRecipe.shape(
                "   ",
                "XZX",
                "X X");

        dragonBootsAlternateRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonBootsAlternateRecipe.setIngredient('Z', Material.NETHERITE_BOOTS);

        return dragonBootsAlternateRecipe;
    }
}
