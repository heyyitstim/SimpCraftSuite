package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
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
        ItemStack dragonHelmet = new ItemBuilder(Material.NETHERITE_HELMET)
                .setName("&cDragon Scale Helmet")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("&7&oyou can now apply runes to this armor piece!")
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 3, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 5, EquipmentSlot.FEET)
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
        ItemStack dragonPlate = new ItemBuilder(Material.NETHERITE_CHESTPLATE)
                .setName("&cDragon Scale Chestplate")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("&7&oyou can now apply runes to this armor piece!")
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.CHEST)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 3, EquipmentSlot.CHEST)
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
        ItemStack dragonLeggings = new ItemBuilder(Material.NETHERITE_LEGGINGS)
                .setName("&cDragon Scale Greaves")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("&7&oyou can now apply runes to this armor piece!")
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.LEGS)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 3, EquipmentSlot.LEGS)
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
        ItemStack dragonBoots = new ItemBuilder(Material.NETHERITE_BOOTS)
                .setName("&cDragon Scale Boots")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("&7&oyou can now apply runes to this armor piece!")
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 3, EquipmentSlot.FEET)
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
        ItemStack dragonBootsAlternate = new ItemBuilder(Material.NETHERITE_BOOTS)
                .setName("&cDragon Scale Boots")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("&7&oyou can now apply runes to this armor piece!")
                .addAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE, "generic.knockback.resistance", .2, EquipmentSlot.FEET)
                .addAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS, "generic.armor.toughness", 3, EquipmentSlot.FEET)
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
