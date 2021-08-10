package heyyitstim.l2dragon.Enchantments;

import heyyitstim.l2dragon.Util.ChatUtil;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class Undead implements Listener {

    private final ArrayList<String> UNDEAD_LORE = new ArrayList<>(Arrays.asList("", ChatUtil.color("&7&oMade of zombie flesh. Gross!"),
            ChatUtil.color("&7&oSeems like it might do extra damage to undead...")));

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
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return false;

        return item.getItemMeta().getLore().equals(UNDEAD_LORE);
    }

    @EventHandler
    public void damageUndead(EntityDamageByEntityEvent e) {
        if (!isUndead(e.getEntity()) || e.getDamager() instanceof Player)
            return;

        Player player = (Player) e.getDamager();

        if (!isUndeadSword(player.getInventory().getItemInMainHand()))
            return;

        e.setDamage(e.getDamage() * 1.50);
    }
}
