package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Main;
import heyyitstim.l2dragon.Util.ChatUtil;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.Color;

import java.util.Arrays;

public class RuneRecipes {

    public RuneRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {
        // Flight Rune
        ShapedRecipe flightRuneRecipe = createFlightRune();

        Main.instance.getServer().addRecipe(flightRuneRecipe);
    }

    private ShapedRecipe createFlightRune() {
        ItemStack flightRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) flightRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.AQUA).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&bFlight Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oApply this to a &cDragon Chestplate"),
                ChatUtil.color("to fly like you're wearing an elytra!")));
        flightRune.setItemMeta(metaFw);

        ShapedRecipe flightRuneRecipe = new ShapedRecipe(flightRune);
        flightRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        flightRuneRecipe.setIngredient('X', Material.IRON_NUGGET);
        flightRuneRecipe.setIngredient('Z', Material.ELYTRA);
        flightRuneRecipe.setIngredient('Y', Material.GUNPOWDER);

        return flightRuneRecipe;
    }

    private ShapedRecipe createStrengthRune() {
        ItemStack strengthRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) stengthRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.RED).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&cStrength Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color(""),
                ChatUtil.color("&7&oApply this to any &cDragon Armor"),
                ChatUtil.color("to gain permanent Strength 1!")));
        strengthRune.setItemMeta(metaFw);

        ShapedRecipe strengthRuneRecipe = new ShapedRecipe(strengthRune);
        strengthRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        strengthRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        strengthRuneRecipe.setIngredient('Z', Material.ELYTRA);
        strengthRuneRecipe.setIngredient('Y', Material.POTION); // Strength Potions

        return strengthRuneRecipe;
    }
}
