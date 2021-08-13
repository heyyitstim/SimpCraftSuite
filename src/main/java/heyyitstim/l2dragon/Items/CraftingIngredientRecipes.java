package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class CraftingIngredientRecipes {

    public CraftingIngredientRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe compressedRottenFlesh = createCompressedRottenFlesh();
        ShapedRecipe shiningEnderPearl = createShiningEnderPearl();
        // ShapedRecipe compactedShiningEnderPearl = createCompactedShiningEnderPearl();

        Main.instance.getServer().addRecipe(compressedRottenFlesh);
        Main.instance.getServer().addRecipe(shiningEnderPearl);
    }

    private ShapedRecipe createCompressedRottenFlesh() {
        ItemStack compressedRottenFlesh = new ItemBuilder(Material.ROTTEN_FLESH)
                .setName("&aCompressed Rotten Flesh")
                .addLore("")
                .addLore("&7&oVery tightly packed meat.")
                .addGlow()
                .setCustomModelNumber(1).build();

        ShapedRecipe compressedRottenFleshRecipe = new ShapedRecipe(NamespacedKey.minecraft("compressed_flesh"), compressedRottenFlesh);
        compressedRottenFleshRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compressedRottenFleshRecipe.setIngredient('X', Material.ROTTEN_FLESH);

        return compressedRottenFleshRecipe;
    }

    private ShapedRecipe createShiningEnderPearl() {
        ItemStack shiningEnderPearl = new ItemBuilder(Material.ENDER_PEARL)
                .setName("&aShining Ender Pearl")
                .addLore("")
                .addLore("&7&oYou can feel this object pulsing with")
                .addLore("&7&oan arcane energy you don't understand.")
                .addGlow()
                .setCustomModelNumber(1).build();

        ShapedRecipe shiningEnderPearlRecipe = new ShapedRecipe(NamespacedKey.minecraft("shining_pearl"), shiningEnderPearl);
        shiningEnderPearlRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        shiningEnderPearlRecipe.setIngredient('X', Material.ENDER_PEARL);

        return shiningEnderPearlRecipe;
    }

    /* private ShapedRecipe createCompactedShiningEnderPearl() {
        ItemStack compactedShiningEnderPearl = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&aCompacted Shining Ender Pearl")
                .addLore("")
                .addLore("&7&oYou can feel this object pulsing with")
                .addLore("&7&oan arcane energy you don't understand.")
                .addGlow()
                .setCustomModelNumber(1).build();

        SkullMeta meta = (SkullMeta)compactedShiningEnderPearl.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer("Cypiea"));
        compactedShiningEnderPearl.setItemMeta(meta);

        ShapedRecipe compactedShiningEnderPearlRecipe = new ShapedRecipe(compactedShiningEnderPearl);
        compactedShiningEnderPearlRecipe.shape(
                "XXX",
                "XXX",
                "XXX");

        compactedShiningEnderPearlRecipe.setIngredient('X', Material.ENDER_PEARL);

        return compactedShiningEnderPearlRecipe;
    } */
}
