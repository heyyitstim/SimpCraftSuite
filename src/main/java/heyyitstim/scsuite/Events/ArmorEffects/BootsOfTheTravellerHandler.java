package heyyitstim.scsuite.Events.ArmorEffects;

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

public class BootsOfTheTravellerHandler implements Listener {

    private boolean checkArmor(ItemStack boots) {
        if (boots == null) return false;

        return isBoots(boots);
    }

    // Gives Speed 1 for 7 days, 24 hours, 60 minutes, 60 seconds, 20 ticks
    private void giveSpeed(Player p, ItemStack boots) {
        if (checkArmor(boots)) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 7*24*60*60*20, 0));
        }
    }

    @EventHandler
    public void onEquip(InventoryClickEvent e) {

        if (e.getInventory() instanceof CraftingInventory) {

            Player player = (Player)e.getWhoClicked();

            if (e.getSlot() == 36) {

                InventoryAction action = e.getAction();
                ItemStack slotItem = e.getCurrentItem();
                ItemStack holdingItem = e.getCursor();

                if (action == InventoryAction.PLACE_ALL) {

                    if (isBoots(slotItem)) {
                        player.removePotionEffect(PotionEffectType.SPEED);
                        return;
                    }

                    giveSpeed(player, holdingItem);
                }
            }
        }
    }

    public boolean isBoots(ItemStack item) {
        return NBTUtil.isItem("scname", "boots_of_the_traveller", item);
    }
}
