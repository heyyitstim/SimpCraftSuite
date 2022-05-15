package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class ArmorRecipes {

    public ArmorRecipes() {
        registerRecipes();
    }

    private void registerRecipes() {
        //ShapedRecipe hardenedDiamondHelmet = createHardenedDiamondHelmet();
        //ShapedRecipe hardenedDiamondChestplate = createHardenedDiamondChestplate();
        //ShapedRecipe hardenedDiamondLeggings = createHardenedDiamondLeggings();
        //ShapedRecipe hardenedDiamondBoots = createHardenedDiamondBoots();
        ShapedRecipe bootsOfTheTraveller = createBootsOfTheTraveller();

        //Main.instance.getServer().addRecipe(hardenedDiamondHelmet);
        //Main.instance.getServer().addRecipe(hardenedDiamondChestplate);
        //Main.instance.getServer().addRecipe(hardenedDiamondLeggings);
        //Main.instance.getServer().addRecipe(hardenedDiamondBoots);
        Main.instance.getServer().addRecipe(bootsOfTheTraveller);
    }

    private ShapedRecipe createBootsOfTheTraveller() {
        ItemStack bootsOfTheTraveller = new ItemBuilder(Material.IRON_BOOTS)
                .setName("&9Boots of the Traveller")
                .addLore("&7Grants the wearer increased speed")
                .addStringNBT("scname", "boots_of_the_traveller")
                .setCustomModelNumber(1).build();

        ShapedRecipe bootsOfTheTravellerRecipe = new ShapedRecipe(NamespacedKey.minecraft("boots_of_the_traveller"), bootsOfTheTraveller);
        bootsOfTheTravellerRecipe.shape(
                "   ",
                "X X",
                "X X");

        bootsOfTheTravellerRecipe.setIngredient('X', Material.SUGAR_CANE);

        return bootsOfTheTravellerRecipe;
    }
}
