package heyyitstim.scsuite.Events.ArmorEffects;

import org.bukkit.Material;
import org.bukkit.event.Listener;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FarmArmorHandler implements Listener {

    private boolean checkArmor(Player player) {
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chest = player.getInventory().getChestplate();
        ItemStack legs = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();

        if (!isLeatherArmor(helmet) || !isLeatherArmor(chest) || !isLeatherArmor(legs) || !isLeatherArmor(boots)) { return false; }

        if (!NBTUtil.isItem("scname", "farm_helmet", helmet)) { return false; }
        if (!NBTUtil.isItem("scname", "farm_chestplate", chest)) { return false; }
        if (!NBTUtil.isItem("scname", "farm_leggings", legs)) { return false; }
        if (!NBTUtil.isItem("scname", "farm_boots", boots)) { return false; }

        return true;
    }

    private boolean wearingBoots(Player player) {
        ItemStack boots = player.getInventory().getBoots();

        if (!isLeatherArmor(boots)) { return false; }

        return NBTUtil.isItem("scname", "farm_boots", boots);
    }

    private boolean isLeatherArmor(ItemStack item) {
        if (item == null) { return false; }
        return item.getType() == Material.LEATHER_HELMET || item.getType() == Material.LEATHER_CHESTPLATE || item.getType() == Material.LEATHER_LEGGINGS || item.getType() == Material.LEATHER_BOOTS;
    }

    private boolean isHoe(ItemStack item) {
        if (item == null) { return false; }
        return item.getType() == Material.WOODEN_HOE || item.getType() == Material.STONE_HOE || item.getType() == Material.IRON_HOE || item.getType() == Material.DIAMOND_HOE || item.getType() == Material.NETHERITE_HOE;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        ItemStack holding = e.getPlayer().getInventory().getItemInMainHand();

        negateDurability(holding, e.getPlayer());
    }

    @EventHandler
    public void tillLand(PlayerInteractEvent e) {

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack holding = e.getPlayer().getInventory().getItemInMainHand();

            negateDurability(holding, e.getPlayer());
        }

        if (e.getAction() == Action.PHYSICAL) {
            if (e.getClickedBlock().getType() != Material.FARMLAND) { return; }

            e.setCancelled((wearingBoots(e.getPlayer())));
        }
    }

    public void negateDurability(ItemStack item, Player player) {

        if (!isHoe(item)) { return; }

        ItemMeta meta = item.getItemMeta();
        meta.setUnbreakable(checkArmor(player));
        item.setItemMeta(meta);
    }
}
