package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class WeaponRecipes {

    public WeaponRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe vorpalSword = createVorpalSword();
        ShapedRecipe adornedVorpalSword = createAdornedVorpalSword();
        ShapedRecipe undeadSword = createUndeadSword();
        ShapedRecipe spiderSword = createSpiderSword();
        ShapedRecipe enderSword = createEnderSword();

        Main.instance.getServer().addRecipe(vorpalSword);
        Main.instance.getServer().addRecipe(adornedVorpalSword);
        Main.instance.getServer().addRecipe(undeadSword);
        Main.instance.getServer().addRecipe(spiderSword);
        Main.instance.getServer().addRecipe(enderSword);
    }

    private ShapedRecipe createVorpalSword() {
        ItemStack vorpalSword = new ItemBuilder(Material.NETHERITE_SWORD)
                .setName("&eVorpal Sword")
                .addLore("&7+5% Wither Skull Chance")
                .addStringNBT("scname", "vorpal_sword")
                .setCustomModelNumber(1).build();

        ShapedRecipe vorpalSwordRecipe = new ShapedRecipe(NamespacedKey.minecraft("vorpal_sword"), vorpalSword);
        vorpalSwordRecipe.shape(
                " X ",
                " X ",
                " Z ");

        vorpalSwordRecipe.setIngredient('X', Material.NETHER_STAR);
        vorpalSwordRecipe.setIngredient('Z', Material.NETHERITE_INGOT);

        return vorpalSwordRecipe;
    }

    private ShapedRecipe createAdornedVorpalSword() {
        ItemStack adornedVorpalSword = new ItemBuilder(Material.NETHERITE_SWORD)
                .setName("&9Adorned Vorpal Sword")
                .addLore("&7+10% Wither Skull Chance")
                .addStringNBT("scname", "adorned_vorpal_sword")
                .setCustomModelNumber(2).build();

        Main.nuggetRecipes.add(adornedVorpalSword);

        ShapedRecipe adornedVorpalSwordRecipe = new ShapedRecipe(NamespacedKey.minecraft("adorned_vorpal_sword"), adornedVorpalSword);
        adornedVorpalSwordRecipe.shape(
                " X ",
                "XZX",
                " X ");

        adornedVorpalSwordRecipe.setIngredient('X', Material.IRON_NUGGET); // dragon scales
        adornedVorpalSwordRecipe.setIngredient('Z', Material.NETHERITE_SWORD); // vorpal sword

        return adornedVorpalSwordRecipe;
    }

    private ShapedRecipe createUndeadSword() {
        ItemStack undeadSword = new ItemBuilder(Material.IRON_SWORD)
                .setName("&eUndead Sword")
                .addLore("&7+50% Damage to Undead")
                .addStringNBT("scname", "undead_sword")
                .setCustomModelNumber(1).build();

        Main.rottenFleshRecipes.add(undeadSword);

        ShapedRecipe undeadSwordRecipe = new ShapedRecipe(new NamespacedKey(Main.instance, "undead_sword"), undeadSword);
        undeadSwordRecipe.shape(
                " X ",
                " X ",
                " Z ");

        undeadSwordRecipe.setIngredient('X', Material.ROTTEN_FLESH); // compressed rotten flesh
        undeadSwordRecipe.setIngredient('Z', Material.IRON_SWORD); // vorpal sword

        return undeadSwordRecipe;
    }

    private ShapedRecipe createSpiderSword() {
        ItemStack spiderSword = new ItemBuilder(Material.IRON_SWORD)
                .setName("&eSpider Sword")
                .addLore("&7+50% Damage to Spiders")
                .addStringNBT("scname", "spider_sword")
                .setCustomModelNumber(1).build();

        Main.stringRecipes.add(spiderSword);

        ShapedRecipe spiderSwordRecipe = new ShapedRecipe(new NamespacedKey(Main.instance, "spider_sword"), spiderSword);
        spiderSwordRecipe.shape(
                " X ",
                " X ",
                " Z ");

        spiderSwordRecipe.setIngredient('X', Material.STRING); // woven string
        spiderSwordRecipe.setIngredient('Z', Material.IRON_SWORD); // iron sword

        return spiderSwordRecipe;
    }

    private ShapedRecipe createEnderSword() {
        ItemStack enderSword = new ItemBuilder(Material.IRON_SWORD)
                .setName("&eEnder Sword")
                .addLore("&7+50% Damage to End Creatures")
                .addStringNBT("scname", "ender_sword")
                .setCustomModelNumber(1).build();

        Main.enderPearlRecipes.add(enderSword);

        ShapedRecipe enderSwordRecipe = new ShapedRecipe(new NamespacedKey(Main.instance, "ender_sword"), enderSword);
        enderSwordRecipe.shape(
                " X ",
                " X ",
                " Z ");

        enderSwordRecipe.setIngredient('X', Material.PLAYER_HEAD); // compacted ender pearl
        enderSwordRecipe.setIngredient('Z', Material.IRON_SWORD); // iron sword

        return enderSwordRecipe;
    }
}
