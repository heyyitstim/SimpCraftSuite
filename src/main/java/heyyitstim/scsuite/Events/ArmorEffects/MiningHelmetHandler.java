package heyyitstim.scsuite.Events.ArmorEffects;

import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class MiningHelmetHandler implements Listener {

    private boolean checkArmor(ItemStack helmet) {
        if (helmet == null) return false;

        return isHelmet(helmet);
    }

    // Gives Night Vision 1 for 7 days, 24 hours, 60 minutes, 60 seconds, 20 ticks
    private void giveNightVision(Player p, ItemStack helmet) {
        if (checkArmor(helmet)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 7*24*60*60*20, 0));
        }
    }

    @EventHandler
    public void onEquip(InventoryClickEvent e) {

        if (e.getInventory() instanceof CraftingInventory) {

            Player player = (Player)e.getWhoClicked();

            System.out.println(e.getSlot() + " " + e.getAction());

            if (e.getSlot() == 39) {

                InventoryAction action = e.getAction();
                ItemStack slotItem = e.getCurrentItem();
                ItemStack holdingItem = e.getCursor();

                if (action == InventoryAction.PLACE_ALL || action == InventoryAction.PICKUP_ALL || action == InventoryAction.SWAP_WITH_CURSOR) {

                    if (checkArmor(slotItem)) {
                        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                        return;
                    }

                    giveNightVision(player, holdingItem);
                }
            }
        }
    }

    public boolean isHelmet(ItemStack item) {
        return NBTUtil.isItem("scname", "mining_helmet", item);
    }
}
