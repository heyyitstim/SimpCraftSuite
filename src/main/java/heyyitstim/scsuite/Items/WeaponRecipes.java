package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
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
        ShapedRecipe enderSpoon = createEnderSpoon();

        Main.instance.getServer().addRecipe(vorpalSword);
        Main.instance.getServer().addRecipe(adornedVorpalSword);
        Main.instance.getServer().addRecipe(undeadSword);
        Main.instance.getServer().addRecipe(spiderSword);
        Main.instance.getServer().addRecipe(enderSpoon);
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
                .setCustomModelNumber(2).build();

        Main.stringRecipes.add(spiderSword);

        ShapedRecipe spiderSwordRecipe = new ShapedRecipe(new NamespacedKey(Main.instance, "spider_sword"), spiderSword);
        spiderSwordRecipe.shape(
                " X ",
                " X ",
                " Z ");

        spiderSwordRecipe.setIngredient('X', Material.WHITE_WOOL); // woven string
        spiderSwordRecipe.setIngredient('Z', Material.IRON_SWORD); // iron sword

        return spiderSwordRecipe;
    }

    private ShapedRecipe createEnderSpoon() {
        ItemStack enderSpoon = new ItemBuilder(Material.DIAMOND_SHOVEL)
                .setName("&eEnder Spoon")
                .addLore("&7+25% Base Damage")
                .addLore("&7+50% Damage to End Creatures")
                .addAttribute(Attribute.GENERIC_ATTACK_DAMAGE, "generic.attack.damage", 7, EquipmentSlot.HAND)
                .addStringNBT("scname", "ender_spoon")
                .setCustomModelNumber(1).build();

        Main.enderPearlRecipes.add(enderSpoon);

        ShapedRecipe enderSpoonRecipe = new ShapedRecipe(new NamespacedKey(Main.instance, "ender_spoon"), enderSpoon);
        enderSpoonRecipe.shape(
                " X ",
                " X ",
                " Z ");

        enderSpoonRecipe.setIngredient('X', Material.PLAYER_HEAD); // compressed shiny ender pearl
        enderSpoonRecipe.setIngredient('Z', Material.DIAMOND_SHOVEL); // diamond shovel

        return enderSpoonRecipe;
    }
}
