package heyyitstim.scsuite.Events.ArmorEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HelmetOfWisdomHandler implements Listener {

    private boolean checkArmor(ItemStack helmet) {
        if (helmet == null) return false;

        return isHelmet(helmet);
    }

    @EventHandler
    public void increaseExp(PlayerExpChangeEvent e) {
        if (checkArmor(e.getPlayer().getInventory().getHelmet())) {
            int exp = e.getAmount();
            e.setAmount((int)(exp*1.5));
        }
    }

    public boolean isHelmet(ItemStack item) {
        return NBTUtil.isItem("scname", "helmet_of_wisdom", item);
    }
}
