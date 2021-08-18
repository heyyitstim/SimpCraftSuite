package heyyitstim.scsuite.Events;

import heyyitstim.scsuite.Items.DragonDrops;
import heyyitstim.scsuite.Util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.entity.Arrow;
import heyyitstim.scsuite.Util.ScoreboardHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.*;

public class DragonHandler implements Listener {

    public static final HashMap<UUID, Double> damagers = new HashMap<>();
    public static double DragonHealth = 0;
    private final ArrayList<ScoreboardHandler> scoreboards = new ArrayList<>();

    @EventHandler
    public void onDamageDragon(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof EnderDragon) { // Checks if the entity damaged was the dragon.
            EnderDragon dragon = (EnderDragon) e.getEntity();

            Player damager = e.getDamager() instanceof Player ? (Player) e.getDamager() : null;

            if (e.getDamager() instanceof Arrow) { // Checks if it's an arrow
                Arrow arrow = (Arrow) e.getDamager(); // Casts it to an arrow
                arrow.setDamage(e.getDamage() * 0.75); // Nerfs dragon arrow damage.

                if (arrow.getShooter() instanceof Player) // Checks if it was from a player
                    damager = (Player) arrow.getShooter(); // Sets the damager to a player
                else
                    return; // If it wasn't a player that shot it then we return and dont do anything.
            }

            Double currentDamage = damagers.get(damager.getUniqueId()); // Grabs how much damage the player has done already.

            /* Basically if the player has done no damage, it puts in the damage they just did,
               if they've done damage it adds it to the damage they previously had.
            */

            if (currentDamage != null) {
                damagers.put(damager.getUniqueId(), twoDecimals(currentDamage + e.getDamage()));
            } else {
                damagers.put(damager.getUniqueId(), twoDecimals(e.getDamage()));
                scoreboards.add(new ScoreboardHandler(damager)); // If they haven't done damage yet add them to the leaderboard.
            }

            // Update the scoreboard each time damage is done
            sendToPlayers();
            DragonHealth = twoDecimals(dragon.getHealth());
        }
    }

    private List<Map.Entry<UUID, Double>> getTop3Damagers() {
        // Create a list from elements of HashMap
        List<Map.Entry<UUID, Double>> list = new LinkedList<>(damagers.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());
        Collections.reverse(list);

        return list;
    }

    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent e) {
        if (e.getEntity() instanceof EnderDragon) {
            List<Map.Entry<UUID, Double>> topDamagers = getTop3Damagers();

            ChatUtil.broadcast("&5The Ender Dragon has been slain!");

            if (topDamagers.size() >= 1) {
                Player player = Bukkit.getPlayer(topDamagers.get(0).getKey());
                ChatUtil.broadcastToWorld("&d 1st » " + player.getDisplayName() + " " + topDamagers.get(0).getValue(), e.getEntity().getWorld());
                DragonDrops.rewardPlayer(player, 1);
            }

            if (topDamagers.size() >= 2) {
                Player player = Bukkit.getPlayer(topDamagers.get(1).getKey());
                ChatUtil.broadcastToWorld("&d 2nd » " + player.getDisplayName() + " " + topDamagers.get(1).getValue(), e.getEntity().getWorld());
                DragonDrops.rewardPlayer(player, 0.75);
            }

            if (topDamagers.size() >= 3) {
                Player player = Bukkit.getPlayer(topDamagers.get(2).getKey());
                ChatUtil.broadcastToWorld("&d 3rd » " + player.getDisplayName() + " " + topDamagers.get(2).getValue(), e.getEntity().getWorld());
                DragonDrops.rewardPlayer(player, 0.5);
            }

            damagers.clear(); // Resets the damages done by players until the next fight. We don't clear it until after we get the top damagers.
            removeAllBoards();
            scoreboards.clear();
        }
    }

    @EventHandler
    public void onDragonSpawn(EntitySpawnEvent e) {
        if (e.getEntity() instanceof EnderDragon) {
            ChatUtil.broadcast("&5The Ender Dragon has been summoned!");

            EnderDragon dragon = (EnderDragon) e.getEntity();

            dragon.setMaxHealth(dragon.getHealth() * 2);
            dragon.setHealth(dragon.getHealth() * 2);
            DragonHealth = dragon.getHealth();
        }
    }

    @EventHandler
    public void onLogout(PlayerQuitEvent e) {
        ScoreboardHandler board = getBoard(e.getPlayer());

        if (board != null) {
            scoreboards.remove(board);
            e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }
    }

    private double twoDecimals(Double d) {
        return (double) Math.round(d * 100.0) / 100.0;
    }

    private void removeAllBoards() {
        for (ScoreboardHandler board : scoreboards) {
            board.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
        }
    }

    private void sendToPlayers() {
        for (ScoreboardHandler board : scoreboards) {
            board.sendToPlayer();
        }
    }

    private ScoreboardHandler getBoard(Player p) {
        for (ScoreboardHandler s : scoreboards) {
            if (s.getPlayer().equals(p)) {
                return s;
            }
        }
        return null;
    }
}
