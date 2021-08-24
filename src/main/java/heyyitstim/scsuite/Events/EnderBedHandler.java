package heyyitstim.scsuite.Events;

import heyyitstim.scsuite.Util.ItemBuilder;
import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class EnderBedHandler implements Listener {

    private boolean isBed(ItemStack item) {
        return NBTUtil.isItem("sc_name", "ender_bed", item);
    }

    private Location whereToTeleport(Player player) {
        if (player.getBedSpawnLocation() != null) return player.getBedSpawnLocation();
        return Bukkit.getWorlds().get(0).getSpawnLocation();
    }

    @EventHandler
    public void useBed(PlayerInteractEvent e){

        if (!isBed(e.getPlayer().getInventory().getItemInMainHand()))
            return;

        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
            return;
        }

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK)
            e.setCancelled(true);

        Player player = e.getPlayer();

        player.getInventory().setItemInMainHand(null);

        player.setVelocity(new Vector(0, 0, 0));
        player.setFallDistance(0);
        player.teleport(whereToTeleport(player));
    }
}
