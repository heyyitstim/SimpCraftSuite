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

public class BootsOfTheTraveler {

    public void registerRecipes() {

        ShapedRecipe bootsOfTheTravelerRecipe = createBootsOfTheTraveler();

        Main.instance.getServer().addRecipe(bootsOfTheTravelerRecipe);
    }

    private ShapedRecipe createBootsOfTheTraveler() {
        ItemStack bootsOfTheTraveler = new ItemBuilder(Material.LEATHER_BOOTS)
                .setName("&5Boots of The Traveler")
                .addLore("")
                .addLore("&bPiece Bonus: Quick Step")
                .addLore("&7Gain permanent speed 1 while wearing.")
                .addAttribute(Attribute.GENERIC_ARMOR, "generic.armor", 3, EquipmentSlot.FEET)
                .addStringNBT("scname", "boots_of_the_traveler")
                .setLeatherColor(Color.PURPLE)
                .setCustomModelNumber(1).build();

        ShapedRecipe bootsOfTheTravelerRecipe = new ShapedRecipe(NamespacedKey.minecraft("boots_of_the_traveler"), bootsOfTheTraveler);
        bootsOfTheTravelerRecipe.shape(
                "XZX",
                "XYX",
                "XZX");

        bootsOfTheTravelerRecipe.setIngredient('X', Material.RABBIT_FOOT);
        bootsOfTheTravelerRecipe.setIngredient('Y', Material.DIAMOND_BOOTS);
        bootsOfTheTravelerRecipe.setIngredient('Z', Material.PLAYER_HEAD); // Compacted Sugar Cane

        return bootsOfTheTravelerRecipe;
    }
}
