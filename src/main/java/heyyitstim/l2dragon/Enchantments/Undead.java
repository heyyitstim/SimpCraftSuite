package heyyitstim.l2dragon.Enchantments;

import heyyitstim.l2dragon.Util.NBTUtil;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Undead implements Listener {

    private boolean isUndead(Entity entity) {
        return  entity instanceof Zombie ||
                entity instanceof Skeleton ||
                entity instanceof Phantom ||
                entity instanceof SkeletonHorse ||
                entity instanceof Stray ||
                entity instanceof Wither ||
                entity instanceof WitherSkeleton ||
                entity instanceof Zoglin ||
                entity instanceof ZombieHorse;
    }

    private boolean isUndeadSword(ItemStack item) {
        if (!item.hasItemMeta())
            return false;

        ItemMeta meta = item.getItemMeta();
        String tag = NBTUtil.getStringTag(meta, "scname");

        if (tag == null)
            return false;

        return tag.equalsIgnoreCase("undead_sword");
    }

    @EventHandler
    public void damageUndead(EntityDamageByEntityEvent e) {
        if (!isUndead(e.getEntity()) || !(e.getDamager() instanceof Player))
            return;

        Player player = (Player) e.getDamager();

        if (!isUndeadSword(player.getInventory().getItemInMainHand()))
            return;

        e.setDamage(e.getDamage() * 1.50);
    }
}
