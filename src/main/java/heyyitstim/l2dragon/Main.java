package heyyitstim.l2dragon;

import heyyitstim.l2dragon.Items.ArmorRecipes;
import heyyitstim.l2dragon.Items.RuneRecipes;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        new ArmorRecipes();
        new RuneRecipes();
        System.out.println("L2Dragon has been enabled!");
    }

    @Override
    public void onDisable() {
        System.out.println("L2Dragon has been disabled!");
    }
}
