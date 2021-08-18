package heyyitstim.scsuite.Enchantments;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Beheading implements Listener {

    private int getChance(ItemStack item) {
        if (NBTUtil.isItem("scname", "vorpal_sword", item)) {
            return 5;
        }

        if (NBTUtil.isItem("scname", "adorned_vorpal_sword", item)) {
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