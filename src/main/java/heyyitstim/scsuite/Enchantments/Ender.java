package heyyitstim.scsuite.Enchantments;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Ender implements Listener {

    private boolean isEnder(Entity entity) {
        return  entity instanceof Enderman ||
                entity instanceof EnderDragon ||
                entity instanceof Endermite ||
                entity instanceof Shulker;
    }

    private boolean isEnderSword(ItemStack item) {
        if (!item.hasItemMeta())
            return false;

        ItemMeta meta = item.getItemMeta();
        String tag = NBTUtil.getStringTag(meta, "scname");

        if (tag == null)
            return false;

        return tag.equalsIgnoreCase("undead_sword");
    }

    @EventHandler
    public void damageEnder(EntityDamageByEntityEvent e) {
        if (!isEnder(e.getEntity()) || !(e.getDamager() instanceof Player))
            return;

        Player player = (Player) e.getDamager();

        if (!isEnderSword(player.getInventory().getItemInMainHand()))
            return;

        e.setDamage(e.getDamage() * 1.50);
    }
}
