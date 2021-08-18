package heyyitstim.scsuite.Util;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KillCounter {

    @EventHandler
    public void addKill(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller();
        ItemStack itemKilledWith = killer.getEquipment().getItemInMainHand();

        if (killer != null) {
            ItemMeta meta = killer.getEquipment().getItemInMainHand().getItemMeta();

            List<String> lore = meta.getLore();
            lore.add(ChatUtil.color("&7Kills: &e"));
            itemKilledWith.setItemMeta(meta);
        }

        if (killer == null) {
            return;
        }
    }
}
