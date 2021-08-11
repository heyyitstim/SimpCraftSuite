package heyyitstim.l2dragon.Util;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KillCounter {

    @EventHandler
    public void addKill(EntityDeathEvent e) {
        Player killer = e.getEntity().getKiller() instanceof Player ? (Player) e.getEntity().getKiller() : null;
        ItemStack itemKilledWith = killer.getEquipment().getItemInMainHand();

        if (e.getEntity().isDead() == true) {
            ItemMeta meta = killer.getEquipment().getItemInMainHand().getItemMeta();
        }
    }
}
