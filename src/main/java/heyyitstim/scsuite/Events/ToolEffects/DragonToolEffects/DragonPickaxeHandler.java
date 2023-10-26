package heyyitstim.scsuite.Events.ToolEffects.DragonToolEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class DragonPickaxeHandler implements Listener {

    public boolean isDragonPickaxe(ItemStack item) {
        return NBTUtil.isItem("scname", "dragon_pickaxe", item);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!isDragonPickaxe(event.getPlayer().getInventory().getItemInMainHand()))
            return;

        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType().equals(Material.IRON_ORE) || block.getType().equals(Material.GOLD_ORE)) {
            ItemStack smeltedItem = null;
            int fortuneLevel = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);

            if (block.getType().equals(Material.IRON_ORE)) {
                smeltedItem = new ItemStack(Material.IRON_INGOT, 1);
            } else if (block.getType().equals(Material.GOLD_ORE)) {
                smeltedItem = new ItemStack(Material.GOLD_INGOT, 1);
            }

            if (fortuneLevel > 0) {
                int additionalItems = new Random().nextInt(fortuneLevel + 1);
                smeltedItem.setAmount(smeltedItem.getAmount() + additionalItems);
            }

            block.setType(Material.AIR);
            block.getWorld().dropItemNaturally(block.getLocation(), smeltedItem);
            event.setCancelled(true);
        }

        if (block.getType().equals(Material.RAW_IRON_BLOCK) || block.getType().equals(Material.RAW_GOLD_BLOCK)) {
            ItemStack smeltedItem = null;

            if (block.getType().equals(Material.RAW_IRON_BLOCK)) {
                smeltedItem = new ItemStack(Material.IRON_BLOCK, 1);
            } else if (block.getType().equals(Material.RAW_GOLD_BLOCK)) {
                smeltedItem = new ItemStack(Material.GOLD_BLOCK, 1);
            }

            block.setType(Material.AIR);
            block.getWorld().dropItemNaturally(block.getLocation(), smeltedItem);
            event.setCancelled(true);
        }
    }
}
