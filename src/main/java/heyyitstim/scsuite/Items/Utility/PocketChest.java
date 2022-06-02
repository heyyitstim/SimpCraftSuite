package heyyitstim.scsuite.Items.Utility;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class PocketChest {

    public PocketChest() {
        registerRecipes();
    }

    private void registerRecipes() {
        ShapedRecipe pocketChest = createPocketChest();
        Main.instance.getServer().addRecipe(pocketChest);
    }

    private ShapedRecipe createPocketChest() {
        ItemStack pocketChest = new ItemBuilder(Material.PLAYER_HEAD)
                .setName("&5Pocket Chest")
                .addLore("")
                .addLore("&bAbility: Remote Access")
                .addLore("&7Can open a chest from anywhere!")
                .addLore("&7Right click a chest to link")
                .addLore("&7this item to that chest.")
                .addStringNBT("scname", "pocket_chest")
                .addTexture("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODA2ZGJhNjMzZjc2ODI5MDA0OGI5NGFmOWQyNjI5YWIzMjZjZjZkYzExM2JmOTM1ZTQ3NDcxMjU2MGI1YjUzNCJ9fX0=")
                .setCustomModelNumber(1).build();

        ShapedRecipe pocketChestRecipe = new ShapedRecipe(NamespacedKey.minecraft("pocket_chest"), pocketChest);
        pocketChestRecipe.shape(
                "XXX",
                "XZX",
                "XXX");

        pocketChestRecipe.setIngredient('X', Material.CHEST);
        pocketChestRecipe.setIngredient('Z', Material.ENDER_EYE);

        return pocketChestRecipe;
    }
}
