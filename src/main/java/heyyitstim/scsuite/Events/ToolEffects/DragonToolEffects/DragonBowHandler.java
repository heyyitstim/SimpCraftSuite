package heyyitstim.scsuite.Events.ToolEffects.DragonToolEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class DragonBowHandler implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if (item != null && item.getType() == Material.BOW && event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (!isDragonBow(event.getPlayer().getInventory().getItemInMainHand()))
                return;

            event.setCancelled(true);
            if (player.getCooldown(Material.BOW) > 0) {
                event.setCancelled(true);
                return;
            }

            player.setCooldown(Material.BOW, 20); // sets cooldown to 20 ticks
            Arrow arrow = player.launchProjectile(Arrow.class);
            arrow.setVelocity(player.getEyeLocation().getDirection().multiply(3)); // fires the arrow
        }
    }

    public boolean isDragonBow(ItemStack item) {
        return NBTUtil.isItem("scname", "dragon_bow", item);
    }
}
