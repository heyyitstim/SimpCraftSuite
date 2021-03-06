package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.ChatUtil;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.Color;

import java.util.Arrays;

public class ToolRuneRecipes {

    public ToolRuneRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {
        // AutoSmelt Rune
        ShapedRecipe smeltRuneRecipe = createSmeltRune();
        // 3x3 Hammer Rune
        ShapedRecipe hammerRuneRecipe = createHammerRune();

        Main.instance.getServer().addRecipe(smeltRuneRecipe);
        Main.instance.getServer().addRecipe(hammerRuneRecipe);
    }

    private ShapedRecipe createSmeltRune() {
        ItemStack smeltRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) smeltRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.AQUA).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&4Auto-Smelt Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Tool Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oMining with this rune applied"),
                ChatUtil.color("&7&owill &4&oauto-smelt &7&oblocks!")));
        smeltRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(smeltRune);

        ShapedRecipe smeltRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("smelt_rune"), smeltRune);
        smeltRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        smeltRuneRecipe.setIngredient('X', Material.IRON_NUGGET);
        smeltRuneRecipe.setIngredient('Z', Material.DIAMOND_PICKAXE);
        smeltRuneRecipe.setIngredient('Y', Material.FIRE_CHARGE);

        return smeltRuneRecipe;
    }

    private ShapedRecipe createHammerRune() {
        ItemStack hammerRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) hammerRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.AQUA).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&8Hammer Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Pickaxe Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oAllows your pickaxe to mine in a"),
                ChatUtil.color("&7&o3x3 area, and increases tool durability!")));
        hammerRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(hammerRune);

        ShapedRecipe hammerRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("hammer_rune"), hammerRune);
        hammerRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        hammerRuneRecipe.setIngredient('X', Material.IRON_NUGGET);
        hammerRuneRecipe.setIngredient('Z', Material.DIAMOND_PICKAXE);
        hammerRuneRecipe.setIngredient('Y', Material.EMERALD);

        return hammerRuneRecipe;
    }
}
