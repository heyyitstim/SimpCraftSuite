package heyyitstim.scsuite.Enchantments;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DragonSlayer implements Listener {

    private boolean isDragon(Entity entity) {
        return  entity instanceof EnderDragon;
    }


    @EventHandler
    public void damageDragon(EntityDamageByEntityEvent e) {
        if (!isDragon(e.getEntity()) || !(e.getDamager() instanceof Player))
            return;

        Player player = (Player) e.getDamager();

            return;

        //e.setDamage(e.getDamage() * 1.10);
    }
}