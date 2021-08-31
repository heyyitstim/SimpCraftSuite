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

public class ArmorRuneRecipes {

    public ArmorRuneRecipes() {
        registerRecipes();
    }

    public void registerRecipes() {
        ShapedRecipe flightRuneRecipe = createFlightRune();
        ShapedRecipe strengthRuneRecipe = createStrengthRune();
        ShapedRecipe nvRuneRecipe = createNvRune();
        ShapedRecipe speedRuneRecipe = createSpeedRune();
        ShapedRecipe jumpRuneRecipe = createJumpRune();
        ShapedRecipe fireRuneRecipe = createFireRune();
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
                ChatUtil.color("&7Dragon Chestplate Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7Allows you to &bfly &7as if"),
                ChatUtil.color("&7you were wearing an elytra!")));
        flightRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(flightRune);

        ShapedRecipe flightRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("flight_rune"),flightRune);
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
                ChatUtil.color("&7Dragon Armor Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7With this rune applied, you will"),
                ChatUtil.color("&7gain permanent &cStrength 1&7!")));
        strengthRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(strengthRune);

        ShapedRecipe strengthRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("strength_rune"), strengthRune);
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
                ChatUtil.color("&7Dragon Helmet Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7Apply this to a &cDragon Helmet"),
                ChatUtil.color("&7to gain permanent &enight vision&7!")));
        nvRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(nvRune);

        ShapedRecipe nvRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("nv_rune"), nvRune);
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
                ChatUtil.color("&7Dragon Boots Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7Apply this to &cDragon Boots"),
                ChatUtil.color("&7to gain permanent &3Speed 1&7!")));
        speedRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(speedRune);

        ShapedRecipe speedRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("speed_rune"), speedRune);
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
                ChatUtil.color("&7Dragon Greaves Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7Allows the wearer to gain"),
                ChatUtil.color("&7permanent &aJump Boost 1&7!")));
        jumpRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(jumpRune);

        ShapedRecipe jumpRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("jump_rune"), jumpRune);
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
                ChatUtil.color("&7Dragon Armor Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7The magical properties of this rune"),
                ChatUtil.color("&7grant permanent &6Fire Resistance 1&7!")));
        fireRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(fireRune);

        ShapedRecipe fireRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("fire_rune"), fireRune);
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
                ChatUtil.color("&7Dragon Helmet Upgrade"),
                ChatUtil.color(""),
                ChatUtil.color("&7The magical properties of this rune"),
                ChatUtil.color("&7grant permanent &1Water Breathing&7!")));
        waterRune.setItemMeta(metaFw);

        Main.nuggetRecipes.add(waterRune);

        ShapedRecipe waterRuneRecipe = new ShapedRecipe(NamespacedKey.minecraft("water_rune"), waterRune);
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
