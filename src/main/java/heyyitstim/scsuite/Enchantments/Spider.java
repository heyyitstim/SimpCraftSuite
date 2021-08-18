package heyyitstim.scsuite.Enchantments;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Spider implements Listener {

    private boolean isSpider(Entity entity) {
        return  entity instanceof Spider ||
                entity instanceof CaveSpider ||
                entity instanceof Silverfish;
    }

    private boolean isSpiderSword(ItemStack item) {
        if (!item.hasItemMeta())
            return false;

        ItemMeta meta = item.getItemMeta();
        String tag = NBTUtil.getStringTag(meta, "scname");

        if (tag == null)
            return false;

        return tag.equalsIgnoreCase("spider_sword");
    }

    @EventHandler
    public void damageSpider(EntityDamageByEntityEvent e) {
        if (!isSpider(e.getEntity()) || !(e.getDamager() instanceof Player))
            return;

        Player player = (Player) e.getDamager();

        if (!isSpiderSword(player.getInventory().getItemInMainHand()))
            return;

        e.setDamage(e.getDamage() * 1.50);
    }
}
