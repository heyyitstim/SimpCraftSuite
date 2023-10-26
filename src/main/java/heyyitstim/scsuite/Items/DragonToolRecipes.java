package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class DragonToolRecipes {

    public DragonToolRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {

        // Dragon Helmet
        ShapedRecipe dragonSwordRecipe = createDragonSword();
        ShapedRecipe dragonPickaxeRecipe = createDragonPickaxe();
        ShapedRecipe dragonShovelRecipe = createDragonShovel();
        ShapedRecipe dragonAxeRecipe = createDragonAxe();
        ShapedRecipe dragonBowRecipe = createDragonBow();

        Main.instance.getServer().addRecipe(dragonPickaxeRecipe);
        Main.instance.getServer().addRecipe(dragonSwordRecipe);
        Main.instance.getServer().addRecipe(dragonShovelRecipe);
        Main.instance.getServer().addRecipe(dragonAxeRecipe);
        Main.instance.getServer().addRecipe(dragonBowRecipe);
    }

    private ShapedRecipe createDragonPickaxe() {
        ItemStack dragonPickaxe = new ItemBuilder(Material.NETHERITE_PICKAXE)
                .setName("&dDragon Scale Pickaxe")
                .addLore("")
                .addLore("&bAbility: Smelting Touch")
                .addLore("&7Mining iron and gold ore")
                .addLore("&7will yield ingots.")
                .addLore("")
                .addLore("&d&lMAGICAL PICKAXE")
                .addStringNBT("scname", "dragon_pickaxe")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonPickaxe);

        ShapedRecipe dragonPickaxeRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_pickaxe"), dragonPickaxe);
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
                .setName("&dDragon Scale Sword")
                .addLore("")
                .addLore("&bAbility: Dragon's Breath")
                .addLore("&7Monsters in front of you")
                .addLore("&7take large knockback.")
                .addLore("")
                .addLore("&d&lMAGICAL SWORD")
                .addStringNBT("scname", "dragon_sword")
                .setCustomModelNumber(3).build();

        Main.nuggetRecipes.add(dragonSword);

        ShapedRecipe dragonSwordRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_sword"), dragonSword);
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
                .setName("&dDragon Scale Shovel")
                .addLore("")
                .addLore("&bAbility: Excavate")
                .addLore("&7Destroys blocks in")
                .addLore("&7a 3x3 area.")
                .addLore("")
                .addLore("&d&lMAGICAL SHOVEL")
                .addStringNBT("scname", "dragon_shovel")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonShovel);

        ShapedRecipe dragonShovelRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_shovel"), dragonShovel);
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
                .setName("&dDragon Scale Axe")
                .addLore("")
                .addLore("&bAbility: Tree Feller")
                .addLore("&7Can knock down entire trees")
                .addLore("&7with one swing!")
                .addLore("&8Disabled while sneaking.")
                .addLore("")
                .addLore("&d&lMAGICAL AXE")
                .addStringNBT("scname", "dragon_axe")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonAxe);

        ShapedRecipe dragonAxeRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_axe"), dragonAxe);
        dragonAxeRecipe.shape(
                " X ",
                "XZX",
                " X ");

        dragonAxeRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonAxeRecipe.setIngredient('Z', Material.NETHERITE_AXE);

        return dragonAxeRecipe;
    }

    private ShapedRecipe createDragonBow() {
        ItemStack dragonBow = new ItemBuilder(Material.BOW)
                .setName("&dDragon Scale Bow")
                .addLore("")
                .addLore("&bAbility: Dragon Hunter")
                .addLore("&7Instantly shoots!")
                .addLore("&7Deals increased damage")
                .addLore("&7to dragons.")
                .addLore("&7Shot Cooldown: &a1s")
                .addLore("")
                .addLore("&d&lMAGICAL BOW")
                .addStringNBT("scname", "dragon_bow")
                .setCustomModelNumber(1).build();

        Main.nuggetRecipes.add(dragonBow);

        ShapedRecipe dragonBowRecipe = new ShapedRecipe(NamespacedKey.minecraft("dragon_bow"), dragonBow);
        dragonBowRecipe.shape(
                " X ",
                "XZX",
                " X ");

        dragonBowRecipe.setIngredient('X', Material.IRON_NUGGET);
        dragonBowRecipe.setIngredient('Z', Material.BOW);

        return dragonBowRecipe;
    }
}
