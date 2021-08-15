package heyyitstim.l2dragon.Enchantments;

import heyyitstim.l2dragon.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Beheading implements Listener {

    private int getChance(ItemStack item) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return 0;

        ItemMeta meta = item.getItemMeta();
        String tag = NBTUtil.getStringTag(meta, "scname");

        if (tag == null)
            return 0;

        if (tag.equalsIgnoreCase("vorpal_sword")) {
            return 5;
        }

        if (tag.equalsIgnoreCase("adorned_vorpal")) {
            return 10;
        }

        return 0;
    }

    private boolean hasSkull(List<ItemStack> drops) {
        for (ItemStack item : drops) {
            if (item.getType() == Material.WITHER_SKELETON_SKULL)
                return true;
        }

        return false;
    }

    @EventHandler
    public void witherSkeletonDeath(EntityDeathEvent e) {
        if (!(e.getEntity() instanceof WitherSkeleton) ||  e.getEntity().getKiller() == null)
            return;

        Player player = e.getEntity().getKiller();
        ItemStack item = player.getInventory().getItemInMainHand();
        int chance = getChance(item);

        if (chance <= 0 || hasSkull(e.getDrops()) || ThreadLocalRandom.current().nextInt(0, 101) > chance)
            return;

        e.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SKULL, 1));
    }
}