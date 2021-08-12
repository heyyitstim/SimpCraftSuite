package heyyitstim.l2dragon;

import heyyitstim.l2dragon.Enchantments.Beheading;
import heyyitstim.l2dragon.Enchantments.CustomEnchantment;
import heyyitstim.l2dragon.Enchantments.Glow;
import heyyitstim.l2dragon.Enchantments.Undead;
import heyyitstim.l2dragon.Events.GenerateLoot;
import heyyitstim.l2dragon.Events.JerryHandler;
import heyyitstim.l2dragon.Events.RecipeChecker;
import heyyitstim.l2dragon.Events.*;
import heyyitstim.l2dragon.Items.*;
import heyyitstim.l2dragon.Events.DragonHandler;
import heyyitstim.l2dragon.Util.ItemBuilder;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_17_R1.inventory.CraftItemStack;
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
        CustomEnchantment.registerEnchantment(GlowEnchant);

        getCommand("test").setExecutor(this);

        System.out.println("L2Dragon has been enabled!");
    }

    ItemStack shiningEnderPearl = new ItemBuilder(Material.ENDER_PEARL)
            .setName("&aShining Ender Pearl")
            .addLore("")
            .addLore("&7&oYou can feel this object pulsing with")
            .addLore("&7&oan arcane energy you don't understand.")
            .addGlow()
            .setCustomModelNumber(1).build();

    private static final ItemStack SCALE = new ItemBuilder(Material.IRON_NUGGET)
            .setName("&cDragon Scale")
            .addLore("")
            .addLore("&7&oTaken from a slain dragon, this")
            .addLore("&7&oscale hums with magical energy.")
            .addGlow()
            .build();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        //JerryHandler.spawnJerry(player.getLocation());

        player.getInventory().addItem(shiningEnderPearl);
        player.getInventory().addItem(SCALE);

        return false;
    }

    @Override
    public void onDisable() {
        System.out.println("L2Dragon has been disabled!");
    }
}