package heyyitstim.scsuite.Events.ToolEffects.DragonToolEffects;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class DragonSwordHandler implements Listener {

    public List<LivingEntity> getMobsInFront(Player player, double radius, double angle) {
        List<Entity> entities = player.getNearbyEntities(radius, radius, radius);
        List<LivingEntity> mobsInFront = new ArrayList<>();
        Vector playerDirection = player.getEyeLocation().getDirection().normalize();

        for (Entity entity : entities) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                Vector entityDirection = entity.getLocation().subtract(player.getLocation()).toVector().normalize();
                double dotProduct = playerDirection.dot(entityDirection);

                if (dotProduct > Math.cos(Math.toRadians(angle))) {
                    mobsInFront.add((LivingEntity) entity);
                }
            }
        }

        return mobsInFront;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (isDragonSword(event.getPlayer().getInventory().getItemInMainHand())) {

            Player player = event.getPlayer();

            if (event.getAction() == Action.RIGHT_CLICK_AIR && player.getCooldown(Material.NETHERITE_SWORD) == 0) {

                Location playerLoc = player.getLocation();
                World world = playerLoc.getWorld();

                // Set the radius of the fire ring
                double radius = 5;

                // Set the delay between particle spawns
                int delayTicks = 2;

                // Calculate the number of particle spawns based on the duration
                int durationSeconds = 1;
                int numSpawns = durationSeconds * 20 / delayTicks;

                // Create a BukkitRunnable to spawn the particles
                new BukkitRunnable() {
                    int count = 0;

                    @Override
                    public void run() {
                        if (count >= numSpawns) {
                            this.cancel();
                            return;
                        }

                        // Spawn a circle of fire particles around the player's location
                        for (double i = 0; i < Math.PI * 2; i += Math.PI / 16) {
                            double x = Math.sin(i) * radius;
                            double z = Math.cos(i) * radius;
                            Location particleLoc = playerLoc.clone().add(x, 0, z);
                            world.spawnParticle(Particle.FLAME, particleLoc, 0, 0, 0, 0, 0);
                        }

                        count++;
                    }
                }.runTaskTimer(Main.instance, 0, delayTicks);

                player.setCooldown(Material.NETHERITE_SWORD, 200); // sets cooldown to 200 ticks (10 seconds)
                event.getPlayer().playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);

                List<LivingEntity> mobsInFront = getMobsInFront(player, 5, 30); // Adjust the radius and angle as desired

                for (LivingEntity mob : mobsInFront) {
                    Vector knockbackDirection = mob.getLocation().subtract(player.getLocation()).toVector().normalize();
                    knockbackDirection.setY(0.5);
                    mob.setVelocity(knockbackDirection.multiply(1)); // Adjust the knockback strength as desired
                }
            }
        }
    }

    public boolean isDragonSword(ItemStack item) {
        return NBTUtil.isItem("scname", "dragon_sword", item);
    }
}
