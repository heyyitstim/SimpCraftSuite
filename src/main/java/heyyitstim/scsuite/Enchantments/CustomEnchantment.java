package heyyitstim.scsuite.Enchantments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

public abstract class CustomEnchantment extends Enchantment {

    public CustomEnchantment(NamespacedKey key) {
        super(key);
    }

    @Override
    public abstract String getName();

    @Override
    public abstract int getMaxLevel();

    @Override
    public abstract int getStartLevel();

    @Override
    public abstract EnchantmentTarget getItemTarget();

    @Override
    public abstract boolean conflictsWith(Enchantment enchantment);

    @Override
    public abstract boolean canEnchantItem(ItemStack itemStack);

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;

        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);

        } catch (Exception e) {
            System.out.println("Unable to load " + enchantment.getName());
        }

        if (registered) {
            System.out.println("Successfully loaded " + enchantment.getName());
        }
    }

}
