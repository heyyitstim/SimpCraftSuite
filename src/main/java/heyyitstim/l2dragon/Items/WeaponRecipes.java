package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ItemBuilder;
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

        Main.instance.getServer().addRecipe(vorpalSword);
        Main.instance.getServer().addRecipe(adornedVorpalSword);
        Main.instance.getServer().addRecipe(undeadSword);
    }

    private ShapedRecipe createVorpalSword() {
        ItemStack vorpalSword = new ItemBuilder(Material.NETHERITE_SWORD)
                .setName("&eVorpal Sword")
                .addLore("")
                .addLore("&7&oThrough unknown methods, this sword seems to")
                .addLore("&7&oprovide bonus chance for wither skeleton skulls!")
                .setCustomModelNumber(1).build();

        ShapedRecipe vorpalSwordRecipe = new ShapedRecipe(vorpalSword);
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
                .addLore("")
                .addLore("&7&oAn upgraded version of the vorpal sword.")
                .addLore("&7&oEven more wither skulls!")
                .setCustomModelNumber(1).build();

        ShapedRecipe adornedVorpalSwordRecipe = new ShapedRecipe(adornedVorpalSword);
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
                .addLore("")
                .addLore("&7&oMade of zombie flesh. Gross!")
                .addLore("&7&oSeems like it might do extra damage to undead...")
                .setCustomModelNumber(1234567).build();

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
}
