package heyyitstim.scsuite.Events;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class DisableHeadPlacement implements Listener {

    @EventHandler
    public void disablePlacement(BlockPlaceEvent e) {
        ItemStack inHand = e.getPlayer().getInventory().getItemInMainHand();

        String string = NBTUtil.getStringTag(inHand, "scname");
        if (string == "" || string == null) {
            return;
        }
        if (string != null || string.length() > 0) {
            e.setCancelled(true);
        }
    }
}
