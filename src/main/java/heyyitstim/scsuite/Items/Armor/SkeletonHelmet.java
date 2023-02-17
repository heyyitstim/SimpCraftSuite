package heyyitstim.scsuite.Items.Armor;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class SkeletonHelmet {

    public SkeletonHelmet() {
        registerRecipes();
    }

    public void registerRecipes() {

        ShapedRecipe skeletonHelmetRecipe = createSkeletonHelmet();

        Main.instance.getServer().addRecipe(skeletonHelmetRecipe);
    }

    private ShapedRecipe createSkeletonHelmet() {
        ItemStack skeletonHelmet = new ItemBuilder(Material.SKELETON_SKULL)
                .setName("&5Skeleton Helmet")
                .addLore("")
                .addLore("&bPiece Bonus: Bone Shield")
                .addLore("&7Grants the wearer increased")
                .addLore("&7resistance to projectiles.")
                .addLore("")
                .addLore("&5&lEPIC HELMET")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 3, EquipmentSlot.HEAD)
                .addEnchant(Enchantment.PROTECTION_PROJECTILE, 4)
                .addGlow()
                .hideEnchants()
                .addStringNBT("scname", "skeleton_helmet")
                .setCustomModelNumber(1).build();

        ShapedRecipe skeletonHelmetRecipe = new ShapedRecipe(NamespacedKey.minecraft("skeleton_helmet"), skeletonHelmet);
        skeletonHelmetRecipe.shape(
                "XXX",
                "XYX",
                "   ");

        skeletonHelmetRecipe.setIngredient('X', Material.BONE_BLOCK);
        skeletonHelmetRecipe.setIngredient('Y', Material.DIAMOND_HELMET);

        return skeletonHelmetRecipe;
    }
}
