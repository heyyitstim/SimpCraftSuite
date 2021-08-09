package heyyitstim.l2dragon.Enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

public abstract class CustomEnchantment extends Enchantment {

    public CustomEnchantment(NamespacedKey name) {
        super(name);
    }

    @Override
    public abstract boolean canEnchantItem(ItemStack item);

    public abstract EnchantmentTarget getItemTarget();

    public abstract int getMaxLevel();

    public abstract String getName();

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }
}
