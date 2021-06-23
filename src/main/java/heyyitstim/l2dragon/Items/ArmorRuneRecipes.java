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

public class ArmorRuneRecipes {

    public ArmorRuneRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {
        // Flight Rune
        ShapedRecipe flightRuneRecipe = createFlightRune();
        // Strength Rune
        ShapedRecipe strengthRuneRecipe = createStrengthRune();
        // Night Vision Rune
        ShapedRecipe nvRuneRecipe = createNvRune();
        // Speed Rune
        ShapedRecipe speedRuneRecipe = createSpeedRune();
        // Jump Rune
        ShapedRecipe jumpRuneRecipe = createJumpRune();
        // Fire Resistance Rune
        ShapedRecipe fireRuneRecipe = createFireRune();
        // Water Breathing Rune
        ShapedRecipe waterRuneRecipe = createWaterRune();

        Main.instance.getServer().addRecipe(flightRuneRecipe);
        Main.instance.getServer().addRecipe(strengthRuneRecipe);
        Main.instance.getServer().addRecipe(nvRuneRecipe);
        Main.instance.getServer().addRecipe(speedRuneRecipe);
        Main.instance.getServer().addRecipe(jumpRuneRecipe);
        Main.instance.getServer().addRecipe(fireRuneRecipe);
        Main.instance.getServer().addRecipe(waterRuneRecipe);
    }

    private ShapedRecipe createFlightRune() {
        ItemStack flightRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) flightRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.AQUA).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&bFlight Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Chestplate Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oAllows you to &b&ofly &7&oas if"),
                ChatUtil.color("&7&oyou were wearing an elytra!")));
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
        FireworkEffectMeta metaFw = (FireworkEffectMeta) strengthRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.RED).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&cStrength Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Armor Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oWith this rune applied, you will"),
                ChatUtil.color("&7&ogain permanent &c&oStrength 1&7&o!")));
        strengthRune.setItemMeta(metaFw);

        ShapedRecipe strengthRuneRecipe = new ShapedRecipe(strengthRune);
        strengthRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        strengthRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        strengthRuneRecipe.setIngredient('Z', Material.DIAMOND_AXE);
        strengthRuneRecipe.setIngredient('Y', Material.POTION); // Strength Potions

        return strengthRuneRecipe;
    }

    private ShapedRecipe createNvRune() {
        ItemStack nvRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) nvRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.YELLOW).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&eNight Vision Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Helmet Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oApply this to a &c&oDragon Helmet"),
                ChatUtil.color("&7&oto gain permanent &e&onight vision&7&o!")));
        nvRune.setItemMeta(metaFw);

        ShapedRecipe nvRuneRecipe = new ShapedRecipe(nvRune);
        nvRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        nvRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        nvRuneRecipe.setIngredient('Z', Material.GOLDEN_CARROT);
        nvRuneRecipe.setIngredient('Y', Material.POTION); // Nightvision Potions

        return nvRuneRecipe;
    }

    private ShapedRecipe createSpeedRune() {
        ItemStack speedRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) speedRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.TEAL).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&3Speed Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Boots Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oApply this to &c&oDragon Boots"),
                ChatUtil.color("&7&oto gain permanent &3&oSpeed 1&7&o!")));
        speedRune.setItemMeta(metaFw);

        ShapedRecipe speedRuneRecipe = new ShapedRecipe(speedRune);
        speedRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        speedRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        speedRuneRecipe.setIngredient('Z', Material.SUGAR);
        speedRuneRecipe.setIngredient('Y', Material.POTION); // Speed Potions

        return speedRuneRecipe;
    }

    private ShapedRecipe createJumpRune() {
        ItemStack jumpRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) jumpRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.LIME).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&aJumping Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Greaves Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oAllows the wearer to gain"),
                ChatUtil.color("&7&opermanent &a&oJump Boost 1&7&o!")));
        jumpRune.setItemMeta(metaFw);

        ShapedRecipe jumpRuneRecipe = new ShapedRecipe(jumpRune);
        jumpRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        jumpRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        jumpRuneRecipe.setIngredient('Z', Material.SUGAR);
        jumpRuneRecipe.setIngredient('Y', Material.POTION); // Speed Potions

        return jumpRuneRecipe;
    }

    private ShapedRecipe createFireRune() {
        ItemStack fireRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) fireRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.ORANGE).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&6Fire Resistance Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Armor Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oThe magical properties of this rune"),
                ChatUtil.color("&7&ogrant permanent &6&oFire Resistance 1&7&o!")));
        fireRune.setItemMeta(metaFw);

        ShapedRecipe fireRuneRecipe = new ShapedRecipe(fireRune);
        fireRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        fireRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        fireRuneRecipe.setIngredient('Z', Material.MAGMA_CREAM);
        fireRuneRecipe.setIngredient('Y', Material.POTION); // Fire Res. Potions

        return fireRuneRecipe;
    }

    private ShapedRecipe createWaterRune() {
        ItemStack waterRune = new ItemStack(Material.FIREWORK_STAR, 1);
        FireworkEffectMeta metaFw = (FireworkEffectMeta) waterRune.getItemMeta();
        FireworkEffect aa = FireworkEffect.builder().withColor(Color.NAVY).build();
        metaFw.setEffect(aa);
        metaFw.setDisplayName(ChatUtil.color("&1Water Breathing Rune"));
        metaFw.setLore(Arrays.asList(
                ChatUtil.color("&7&oDragon Helmet Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7&oThe magical properties of this rune"),
                ChatUtil.color("&7&ogrant permanent &1&oWater Breathing&7&o!")));
        waterRune.setItemMeta(metaFw);

        ShapedRecipe waterRuneRecipe = new ShapedRecipe(waterRune);
        waterRuneRecipe.shape(
                "YXY",
                "XZX",
                "YXY");

        waterRuneRecipe.setIngredient('X', Material.IRON_NUGGET); // Dragon Scales
        waterRuneRecipe.setIngredient('Z', Material.WATER_BUCKET);
        waterRuneRecipe.setIngredient('Y', Material.TURTLE_HELMET); // Water Breathing Potions

        return waterRuneRecipe;
    }
}
