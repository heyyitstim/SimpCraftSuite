package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Util.ChatUtil;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.*;

public class DragonDrops implements Listener {

    private final HashMap<UUID, Double> damagers = new HashMap<>();

    @EventHandler
    public void onDamageDragon(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof EnderDragon) { // Checks if the entity damaged was the dragon.
            if (e.getDamager() instanceof Player) { // Checks if the entity damaging the dragon is a player.
                Player player = (Player) e.getDamager(); // Casts player to a local object.

                Double currentDamage = damagers.get(player.getUniqueId()); // Grabs how much damage the player has done already.

                // Basically if the player has done no damage, it puts in the damage they just did,
                // if they've done damage it adds it to the damage they previously had.
                damagers.put(player.getUniqueId(), currentDamage != null ? currentDamage + e.getDamage() : e.getDamage());
            }
        }
    }

    private List<Map.Entry<UUID, Double>> getTop3Damagers() {
        // Create a list from elements of HashMap
        List<Map.Entry<UUID, Double>> list = new LinkedList<>(damagers.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());

        return list;
    }

    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent e){
        if(e.getEntity() instanceof EnderDragon){
            List<Map.Entry<UUID, Double>> topDamagers = getTop3Damagers();

            ChatUtil.broadcast("&5The Dragon has died!");
            if (topDamagers.size() >= 1)
                ChatUtil.broadcast("&d 1st » " + topDamagers.get(0).getKey() + " " + topDamagers.get(0).getValue());
            if (topDamagers.size() >= 2)
                ChatUtil.broadcast("&d 2nd » " + topDamagers.get(1).getKey() + " " + topDamagers.get(1).getValue());
            if (topDamagers.size() >= 3)
                ChatUtil.broadcast("&d 3rd » " + topDamagers.get(2).getKey() + " " + topDamagers.get(2).getValue());

            damagers.clear(); // Resets the damages done by players until the next fight. We don't clear it until after we get the top damagers.

            // Do drops here based off whatever.
        }
    }
}
