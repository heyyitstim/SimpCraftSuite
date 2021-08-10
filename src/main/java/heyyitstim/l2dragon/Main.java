package heyyitstim.l2dragon;

import heyyitstim.l2dragon.Enchantments.Beheading;
import heyyitstim.l2dragon.Enchantments.Undead;
import heyyitstim.l2dragon.Events.GenerateLoot;
import heyyitstim.l2dragon.Events.RecipeChecker;
import heyyitstim.l2dragon.Items.*;
import heyyitstim.l2dragon.Events.DragonHandler;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static ArrayList<ItemStack> nuggetRecipes = new ArrayList<>();
    public static ArrayList<ItemStack> rottenFleshRecipes = new ArrayList<>();
    public static ArrayList<ItemStack> enderPearlRecipes = new ArrayList<>();
    public static ArrayList<ShapedRecipe> potionRecipes = new ArrayList<>();

    @Override
    public void onEnable() {
        instance = this;

        // Recipes
        new DragonArmorRecipes();
        new DragonToolRecipes();
        new ArmorRuneRecipes();
        new ToolRuneRecipes();
        new WeaponRecipes();
        new UtilityItemRecipes();
        new CraftingIngredientRecipes();

        // Events
        Bukkit.getPluginManager().registerEvents(new DragonHandler(), this);
        Bukkit.getPluginManager().registerEvents(new RecipeChecker(), this);
        Bukkit.getPluginManager().registerEvents(new GenerateLoot(), this);

        // Enchantments
        Bukkit.getPluginManager().registerEvents(new Beheading(), this);
        Bukkit.getPluginManager().registerEvents(new Undead(), this);

        System.out.println("L2Dragon has been enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("L2Dragon has been disabled!");
    }
}
