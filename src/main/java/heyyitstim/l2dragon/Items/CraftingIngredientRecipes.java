package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftingIngredientRecipes {

    public CraftingIngredientRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe compressedRottenFlesh = createCompressedRottenFlesh();
        ShapedRecipe shiningEnderPearl = createShiningEnderPearl();

        Main.instance.getServer().addRecipe(compressedRottenFlesh);
        Main.instance.getServer().addRecipe(shiningEnderPearl);
    }

    private ShapedRecipe createCompressedRottenFlesh() {
        ItemStack compressedRottenFlesh = new ItemBuilder(Material.ROTTEN_FLESH)
                .setName("&aCompressed Rotten Flesh")
                .addLore("")
                .addLore("&7&oVery tightly packed meat.")
                .setCustomModelNumber(1).build();

        ShapedRecipe compressedRottenFleshRecipe = new ShapedRecipe(compressedRottenFlesh);
        compressedRottenFleshRecipe.shape(
                " X ",
                " X ",
                " X ");

        compressedRottenFleshRecipe.setIngredient('X', Material.ROTTEN_FLESH);

        return compressedRottenFleshRecipe;
    }

    private ShapedRecipe createShiningEnderPearl() {
        ItemStack shiningEnderPearl = new ItemBuilder(Material.ENDER_PEARL)
                .setName("&aShining Ender Pearl")
                .addLore("")
                .addLore("&7&oYou can feel this object pulsing with")
                .addLore("&7&oan arcane energy you don't understand.")
                .setCustomModelNumber(1).build();

        ShapedRecipe shiningEnderPearlRecipe = new ShapedRecipe(shiningEnderPearl);
        shiningEnderPearlRecipe.shape(
                " X ",
                " X ",
                " X ");

        shiningEnderPearlRecipe.setIngredient('X', Material.ENDER_PEARL);

        return shiningEnderPearlRecipe;
    }
}
