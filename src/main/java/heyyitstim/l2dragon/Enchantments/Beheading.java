package heyyitstim.l2dragon.Enchantments;

import heyyitstim.l2dragon.Util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Beheading implements Listener {

    private final ArrayList<String> STARTER_VORPAL = new ArrayList<>(Arrays.asList("", ChatUtil.color("&7&oThrough unknown methods, this sword seems to"),
            ChatUtil.color("&7&oprovide bonus chance for wither skeleton skulls!")));

    private final ArrayList<String> ADORNED_VORPAL = new ArrayList<>(Arrays.asList("", ChatUtil.color("&7&oAn upgraded version of the vorpal sword."),
            ChatUtil.color("&7&oEven more wither skulls!")));

    private int getChance(ItemStack item) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return 0;

        if (item.getItemMeta().getLore().equals(STARTER_VORPAL)) {
            return 5;
        }

        if (item.getItemMeta().getLore().equals(ADORNED_VORPAL)) {
            return 10;
        }

        System.out.println(STARTER_VORPAL + " " + item.getItemMeta().getLore());

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