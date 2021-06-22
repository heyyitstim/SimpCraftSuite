package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ArmorRecipes {

    public ArmorRecipes() {
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
    }

    private ShapedRecipe createDragonHelmet() {
        ItemStack dragonHelmet = new ItemStack(Material.NETHERITE_HELMET, 1);
        ItemMeta meta = dragonHelmet.getItemMeta();
        meta.setDisplayName(ChatUtil.color("&cDragon Helmet"));
        meta.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oImbued with the power of the Ender Dragon,"),
                ChatUtil.color("you can now apply runes to this armor piece!")));
        meta.setCustomModelData(1);
        dragonHelmet.setItemMeta(meta);

        ShapedRecipe dragonHelmetRecipe = new ShapedRecipe(dragonHelmet);
        dragonHelmetRecipe.shape(
                "XXX",
                "XZX",
                "   ");

        dragonHelmetRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonHelmetRecipe.setIngredient('Z', Material.NETHERITE_HELMET);

        return dragonHelmetRecipe;
    }

    private ShapedRecipe createDragonChestplate() {
        ItemStack dragonPlate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
        ItemMeta meta = dragonPlate.getItemMeta();
        meta.setDisplayName(ChatUtil.color("&cDragon Chestplate"));
        meta.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oImbued with the power of the Ender Dragon,"),
                ChatUtil.color("you can now apply runes to this armor piece!")));
        meta.setCustomModelData(1);
        dragonPlate.setItemMeta(meta);

        ShapedRecipe dragonPlateRecipe = new ShapedRecipe(dragonPlate);
        dragonPlateRecipe.shape(
                "XXX",
                "XZX",
                "XXX");

        dragonPlateRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonPlateRecipe.setIngredient('Z', Material.NETHERITE_CHESTPLATE);

        return dragonPlateRecipe;
    }

    private ShapedRecipe createDragonLeggings() {
        ItemStack dragonLeggings = new ItemStack(Material.NETHERITE_LEGGINGS, 1);
        ItemMeta meta = dragonLeggings.getItemMeta();
        meta.setDisplayName(ChatUtil.color("&cDragon Greaves"));
        meta.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oImbued with the power of the Ender Dragon,"),
                ChatUtil.color("you can now apply runes to this armor piece!")));
        meta.setCustomModelData(1);
        dragonLeggings.setItemMeta(meta);

        ShapedRecipe dragonLeggingsRecipe = new ShapedRecipe(dragonLeggings);
        dragonLeggingsRecipe.shape(
                "XXX",
                "XZX",
                "X X");

        dragonLeggingsRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonLeggingsRecipe.setIngredient('Z', Material.NETHERITE_LEGGINGS);

        return dragonLeggingsRecipe;
    }

    private ShapedRecipe createDragonBoots() {
        ItemStack dragonBoots = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta = dragonBoots.getItemMeta();
        meta.setDisplayName(ChatUtil.color("&cDragon Boots"));
        meta.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oImbued with the power of the Ender Dragon,"),
                ChatUtil.color("you can now apply runes to this armor piece!")));
        meta.setCustomModelData(1);
        dragonBoots.setItemMeta(meta);

        ShapedRecipe dragonBootsRecipe = new ShapedRecipe(dragonBoots);
        dragonBootsRecipe.shape(
                "XZX",
                "X X",
                "   ");

        dragonBootsRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonBootsRecipe.setIngredient('Z', Material.NETHERITE_BOOTS);

        return dragonBootsRecipe;
    }

    private ShapedRecipe createDragonBootsAlternate() {
        ItemStack dragonBootsAlternate = new ItemStack(Material.NETHERITE_BOOTS, 1);
        ItemMeta meta = dragonBootsAlternate.getItemMeta();
        meta.setDisplayName(ChatUtil.color("&cDragon Boots"));
        meta.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oImbued with the power of the Ender Dragon,"),
                ChatUtil.color("you can now apply runes to this armor piece!")));
        meta.setCustomModelData(1);
        dragonBootsAlternate.setItemMeta(meta);

        ShapedRecipe dragonBootsAlternateRecipe = new ShapedRecipe(dragonBootsAlternate);
        dragonBootsAlternateRecipe.shape(
                "   ",
                "XZX",
                "X X");

        dragonBootsAlternateRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonBootsAlternateRecipe.setIngredient('Z', Material.NETHERITE_BOOTS);

        return dragonBootsAlternateRecipe;
    }
}
