package heyyitstim.scsuite.Items.Armor;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class MiningHelmet {

    public MiningHelmet() {
        registerRecipes();
    }

    public void registerRecipes() {

        ShapedRecipe miningHelmetRecipe = createMiningHelmet();

        Main.instance.getServer().addRecipe(miningHelmetRecipe);
    }

    private ShapedRecipe createMiningHelmet() {
        ItemStack miningHelmet = new ItemBuilder(Material.GOLDEN_HELMET)
                .setName("&aMining Helmet")
                .addLore("")
                .addLore("&bPiece Bonus: True Sight")
                .addLore("&7Grants the wearer heightened")
                .addLore("&7visibility in darkness.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 2, EquipmentSlot.HEAD)
                .addGlow()
                .hideEnchants()
                .addStringNBT("scname", "mining_helmet")
                .setCustomModelNumber(1).build();

        ShapedRecipe miningHelmetRecipe = new ShapedRecipe(NamespacedKey.minecraft("mining_helmet"), miningHelmet);
        miningHelmetRecipe.shape(
                " Y ",
                "XXX",
                "X X");

        miningHelmetRecipe.setIngredient('X', Material.GOLD_INGOT);
        miningHelmetRecipe.setIngredient('Y', Material.REDSTONE_LAMP);

        return miningHelmetRecipe;
    }
}
