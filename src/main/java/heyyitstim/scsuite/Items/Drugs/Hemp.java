package heyyitstim.scsuite.Items.Drugs;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Hemp {

    public Hemp() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe marijuana = createMarijuana();
        Main.instance.getServer().addRecipe(marijuana);
    }

    private ShapedRecipe createMarijuana() {
        ItemStack marijuana = new ItemBuilder(Material.GREEN_DYE)
                .setName("&2Marijuana")
                .addLore("")
                .addLore("&7")
                .addLore("&7Effects:")
                .addLore("&a| &fHealth Regeneration I (10s)")
                .addLore("&c| &fHunger (60s)")
                .addLore("")
                .addLore("&a&lUNCOMMON")
                .addStringNBT("scname", "marijuana")
                .setCustomModelNumber(1).build();

        ShapedRecipe marijuanaRecipe = new ShapedRecipe(NamespacedKey.minecraft("marijuana"), marijuana);
        marijuanaRecipe.shape(
                "XXX",
                "XZX",
                "XXX");

        marijuanaRecipe.setIngredient('X', Material.CHEST);
        marijuanaRecipe.setIngredient('Z', Material.ENDER_EYE);

        return marijuanaRecipe;
    }
}
