package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class WeaponRecipes {

    public WeaponRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe vorpalSword = createVorpalSword();

        Main.instance.getServer().addRecipe(vorpalSword);
    }

    private ShapedRecipe createVorpalSword() {
        ItemStack vorpalSword = new ItemBuilder(Material.NETHERITE_SWORD)
                .setName("&aVorpal Sword")
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
                .setName("&aAdorned Vorpal Sword")
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
}
