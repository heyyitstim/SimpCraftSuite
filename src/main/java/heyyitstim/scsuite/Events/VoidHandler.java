package heyyitstim.scsuite.Events;

import heyyitstim.scsuite.Util.ItemBuilder;
import heyyitstim.scsuite.Util.NBTUtil;
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

    private boolean isVoidCrystal(ItemStack item) {
        return NBTUtil.isItem("scname", "void_crystal", item);
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
                item.setAmount(item.getAmount() - 1);
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
        player.setFallDistance(0);
        player.teleport(whereToTeleport(player));

        e.setDamage(0);
    }
}
