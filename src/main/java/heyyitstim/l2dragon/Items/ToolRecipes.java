package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ToolRecipes {

    public ToolRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {

        // Dragon Helmet
        ShapedRecipe dragonSwordRecipe = createDragonSword();
        ShapedRecipe dragonPickaxeRecipe = createDragonPickaxe();
        ShapedRecipe dragonShovelRecipe = createDragonShovel();
        ShapedRecipe dragonAxeRecipe = createDragonAxe();

        Main.instance.getServer().addRecipe(dragonPickaxeRecipe);
        Main.instance.getServer().addRecipe(dragonSwordRecipe);
        Main.instance.getServer().addRecipe(dragonShovelRecipe);
        Main.instance.getServer().addRecipe(dragonAxeRecipe);
    }

    private ShapedRecipe createDragonPickaxe() {
        ItemStack dragonPickaxe = new ItemBuilder(Material.NETHERITE_PICKAXE)
                .setName("&cDragon Pickaxe")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("you can now apply runes to this pickaxe!")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonPickaxe);

        ShapedRecipe dragonPickaxeRecipe = new ShapedRecipe(dragonPickaxe);
        dragonPickaxeRecipe.shape(
                " X ",
                "XZX",
                " X ");

        dragonPickaxeRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonPickaxeRecipe.setIngredient('Z', Material.NETHERITE_PICKAXE);

        return dragonPickaxeRecipe;
    }

    private ShapedRecipe createDragonSword() {
        ItemStack dragonSword = new ItemBuilder(Material.NETHERITE_SWORD)
                .setName("&cDragon Sword")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("you can now apply runes to this sword!")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonSword);

        ShapedRecipe dragonSwordRecipe = new ShapedRecipe(dragonSword);
        dragonSwordRecipe.shape(
                " X ",
                "XZX",
                " X ");

        dragonSwordRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonSwordRecipe.setIngredient('Z', Material.NETHERITE_SWORD);

        return dragonSwordRecipe;
    }

    private ShapedRecipe createDragonShovel() {
        ItemStack dragonShovel = new ItemBuilder(Material.NETHERITE_SHOVEL)
                .setName("&cDragon Shovel")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("you can now apply runes to this shovel!")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonShovel);

        ShapedRecipe dragonShovelRecipe = new ShapedRecipe(dragonShovel);
        dragonShovelRecipe.shape(
                " X ",
                "XZX",
                " X ");

        dragonShovelRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonShovelRecipe.setIngredient('Z', Material.NETHERITE_SHOVEL);

        return dragonShovelRecipe;
    }

    private ShapedRecipe createDragonAxe() {
        ItemStack dragonAxe = new ItemBuilder(Material.NETHERITE_AXE)
                .setName("&cDragon Axe")
                .addLore("")
                .addLore("&7&oImbued with the power of the Ender Dragon,")
                .addLore("you can now apply runes to this axe!")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonAxe);

        ShapedRecipe dragonAxeRecipe = new ShapedRecipe(dragonAxe);
        dragonAxeRecipe.shape(
                " X ",
                "XZX",
                " X ");

        dragonAxeRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonAxeRecipe.setIngredient('Z', Material.NETHERITE_AXE);

        return dragonAxeRecipe;
    }
}
