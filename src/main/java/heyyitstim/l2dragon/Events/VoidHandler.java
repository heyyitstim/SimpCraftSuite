package heyyitstim.l2dragon.Events;

import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class VoidHandler implements Listener {

    private final ItemStack voidCrystal = new ItemBuilder(Material.NETHER_STAR)
            .setName("&6Void Crystal")
            .addLore("")
            .addLore("&7&oA sentient object that will sacrifice itself to")
            .addLore("&7&oprotect you from the ever-hungry void!")
            .addLore("&7&oShatters after one use.")
            .setCustomModelNumber(1).build();

    private boolean isVoidCrystal(ItemStack item) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore() || !item.getItemMeta().hasDisplayName())
            return false;

        return item.getItemMeta().getDisplayName().equals(voidCrystal.getItemMeta().getDisplayName()) && item.getItemMeta().getLore().equals(voidCrystal.getItemMeta().getLore());
    }

    private boolean hasVoidCrystal(Player player) {

        for (ItemStack item : player.getInventory()) {
            if (isVoidCrystal(item)) return true;
        }

        return false;
    }

    private void removeVoidCrystal(Player player) {

        for (ItemStack item : player.getInventory()) {
            if (isVoidCrystal(item)) {
                item.setType(Material.AIR);
            }
        }
    }

    private Location whereToTeleport(Player player) {
        if (player.getBedSpawnLocation() != null) return player.getBedSpawnLocation();
        return Bukkit.getWorlds().get(0).getSpawnLocation();
    }

    @EventHandler
    public void isInVoid(EntityDamageEvent e) {
        if (e.getCause() != EntityDamageEvent.DamageCause.VOID || !(e.getEntity() instanceof Player))
            return;

        Player player = (Player) e.getEntity();

        if (!hasVoidCrystal(player))
            return;

        removeVoidCrystal(player);

        player.setVelocity(new Vector(0, 0, 0));
        player.setInvulnerable(true);
        player.teleport(whereToTeleport(player));
        player.setInvulnerable(false);
    }
}
