package heyyitstim.scsuite.Items.Armor;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
public class HelmetOfWisdom {

    public HelmetOfWisdom() {
        registerRecipes();
    }

    public void registerRecipes() {

        ShapedRecipe helmetOfWisdomRecipe = createHelmetOfWisdom();

        Main.instance.getServer().addRecipe(helmetOfWisdomRecipe);
    }

    private ShapedRecipe createHelmetOfWisdom() {
        ItemStack helmetOfWisdom = new ItemBuilder(Material.SEA_LANTERN)
                .setName("&5Helmet of Wisdom")
                .addLore("")
                .addLore("&bPiece Bonus: Big Brain")
                .addLore("&7Increases the experience gain")
                .addLore("&7of the wearer by &a+50%&7.")
                .addLore("")
                .addLore("&5&lEPIC HELMET")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 2, EquipmentSlot.HEAD)
                .addGlow()
                .hideEnchants()
                .addStringNBT("scname", "helmet_of_wisdom")
                .addStringNBT("schelm", "true")
                .setCustomModelNumber(1).build();

        ShapedRecipe helmetOfWisdomRecipe = new ShapedRecipe(NamespacedKey.minecraft("helmet_of_wisdom"), helmetOfWisdom);
        helmetOfWisdomRecipe.shape(
                "YXY",
                "YZY",
                "   ");

        helmetOfWisdomRecipe.setIngredient('X', Material.LAPIS_BLOCK);
        helmetOfWisdomRecipe.setIngredient('Y', Material.EXPERIENCE_BOTTLE);
        helmetOfWisdomRecipe.setIngredient('Z', Material.IRON_HELMET);

        return helmetOfWisdomRecipe;
    }
}
