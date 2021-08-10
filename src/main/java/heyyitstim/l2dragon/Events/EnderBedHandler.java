package heyyitstim.l2dragon.Events;

import heyyitstim.l2dragon.Util.ItemBuilder;
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

import java.io.PushbackInputStream;

public class EnderBedHandler implements Listener {

    private final ItemStack enderBed = new ItemBuilder(Material.PURPLE_BED)
            .setName("&5Ender Bed")
            .addLore("")
            .addLore("&7&oInstantly teleports the user to their spawn.")
            .addLore("&7&oBreaks after one use.")
            .setCustomModelNumber(1).build();

    private boolean isBed(ItemStack item) {
        if (item == null || !item.hasItemMeta() || !item.getItemMeta().hasLore() || !item.getItemMeta().hasDisplayName())
            return false;

        return item.getItemMeta().getDisplayName().equals(enderBed.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(enderBed.getItemMeta().getLore());
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
