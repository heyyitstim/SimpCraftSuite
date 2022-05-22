package heyyitstim.scsuite.Items.Armor;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class BootsOfTheTraveller {

    public void registerRecipes() {

        ShapedRecipe bootsOfTheTravellerRecipe = createBootsOfTheTraveller();

        Main.instance.getServer().addRecipe(bootsOfTheTravellerRecipe);
    }

    private ShapedRecipe createBootsOfTheTraveller() {
        ItemStack bootsOfTheTraveller = new ItemBuilder(Material.LEATHER_BOOTS)
                .setName("&5Boots Of The Traveller")
                .addLore("")
                .addLore("&bPiece Bonus: Fleet Foot")
                .addLore("&7Gain permanent speed 1 while wearing.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 3, EquipmentSlot.FEET)
                .setLeatherColor(Color.PURPLE)
                .addStringNBT("scname", "boots_of_the_traveller")
                .setCustomModelNumber(1).build();

        ShapedRecipe bootsOfTheTravellerRecipe = new ShapedRecipe(NamespacedKey.minecraft("farm_helmet"), bootsOfTheTraveller);
        bootsOfTheTravellerRecipe.shape(
                "XXX",
                "XYX",
                "XXX");

        bootsOfTheTravellerRecipe.setIngredient('X', Material.RABBIT_FOOT);
        bootsOfTheTravellerRecipe.setIngredient('Y', Material.DIAMOND_BOOTS);

        return bootsOfTheTravellerRecipe;
    }
}
