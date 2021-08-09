package heyyitstim.l2dragon.Enchantments;

import heyyitstim.l2dragon.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public class Beheading extends CustomEnchantment {

    private static final Material[] TYPES = new Material[] {
            Material.DIAMOND_SWORD,
            Material.IRON_SWORD,
            Material.GOLDEN_SWORD,
            Material.STONE_SWORD,
            Material.WOODEN_SWORD
    };

    public Beheading() {
        super(new NamespacedKey(Main.instance, "Beheading"));
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return ;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
    }
}