package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

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
                .addStringNBT("scname", "compressed_rotten_flesh")
                .setCustomModelNumber(1).build();

        ShapedRecipe compressedRottenFleshRecipe = new ShapedRecipe(NamespacedKey.minecraft("compressed_rotten_flesh"), compressedRottenFlesh);
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
                .addStringNBT("scname", "shining_ender_pearl")
                .setCustomModelNumber(1).build();

        ShapedRecipe shiningEnderPearlRecipe = new ShapedRecipe(NamespacedKey.minecraft("shining_ender_pearl"), shiningEnderPearl);
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
