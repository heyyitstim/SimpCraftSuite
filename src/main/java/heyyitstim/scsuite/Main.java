package heyyitstim.scsuite;

import heyyitstim.scsuite.Enchantments.*;
import heyyitstim.scsuite.Events.GenerateLoot;
import heyyitstim.scsuite.Events.JerryHandler;
import heyyitstim.scsuite.Events.RecipeChecker;
import heyyitstim.scsuite.Events.*;
import heyyitstim.scsuite.Items.*;
import heyyitstim.scsuite.Events.DragonHandler;
import heyyitstim.scsuite.Util.ChatUtil;
import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public static Main instance;
    public static ArrayList<ItemStack> nuggetRecipes = new ArrayList<>();
    public static ArrayList<ItemStack> rottenFleshRecipes = new ArrayList<>();
    public static ArrayList<ItemStack> enderPearlRecipes = new ArrayList<>();
    public static ArrayList<ItemStack> stringRecipes = new ArrayList<>();
    public static ArrayList<ShapedRecipe> potionRecipes = new ArrayList<>();

    public static Enchantment GlowEnchant = new Glow();

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
        Bukkit.getPluginManager().registerEvents(new VoidHandler(), this);
        Bukkit.getPluginManager().registerEvents(new EnderBedHandler(), this);
        Bukkit.getPluginManager().registerEvents(new JerryHandler(), this);
        Bukkit.getPluginManager().registerEvents(new CustomTextureHandler(), this);

        // Enchantments
        Bukkit.getPluginManager().registerEvents(new Beheading(), this);
        Bukkit.getPluginManager().registerEvents(new Undead(), this);
        Bukkit.getPluginManager().registerEvents(new Spider(), this);
        Bukkit.getPluginManager().registerEvents(new Ender(), this);
        CustomEnchantment.registerEnchantment(GlowEnchant);


        getCommand("test").setExecutor(this);

        System.out.println("SCSuite has been enabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (player.isOp()) {

            ItemStack SCALE = new ItemBuilder(Material.IRON_NUGGET)
                    .setName("&cDragon Scale")
                    .addGlow()
                    .addStringNBT("scname", "dragon_scale")
                    .build();

            player.getInventory().addItem(SCALE);

            return false;
        }

        player.kickPlayer(ChatUtil.color("&cYou have been banned for trying to use admin commands."));

        return false;
    }

    @Override
    public void onDisable() {
        System.out.println("SCSuite has been disabled!");
    }
}