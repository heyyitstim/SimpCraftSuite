package heyyitstim.scsuite.Events.ToolEffects.DragonToolEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class DragonAxeHandler implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!isDragonAxe(event.getPlayer().getInventory().getItemInMainHand()))
            return;
        if (event.getPlayer().isSneaking())
            return;

        Block block = event.getBlock();

        if (block.getType() == Material.OAK_LOG || block.getType() == Material.ACACIA_LOG || block.getType() == Material.SPRUCE_LOG || block.getType() == Material.DARK_OAK_LOG || block.getType() == Material.BIRCH_LOG || block.getType() == Material.JUNGLE_LOG || block.getType() == Material.WARPED_HYPHAE || block.getType() == Material.CRIMSON_HYPHAE) {
            destroyTree(block);
        }
    }

    private void destroyTree(Block block) {
        for (Block relative : getConnectedBlocks(block)) {
            if (relative.getType() == Material.OAK_LOG || relative.getType() == Material.ACACIA_LOG || relative.getType() == Material.SPRUCE_LOG || relative.getType() == Material.DARK_OAK_LOG || relative.getType() == Material.BIRCH_LOG || relative.getType() == Material.JUNGLE_LOG || relative.getType() == Material.WARPED_HYPHAE || relative.getType() == Material.CRIMSON_HYPHAE) {

                // Gets world the block was broken in
                World world = block.getWorld();
                // Breaks connected log blocks
                relative.breakNaturally();
                world.playSound(relative.getLocation(), Sound.BLOCK_WOOD_BREAK, 1.0f, 1.0f);
                destroyTree(relative);
            }
        }
    }

    private Block[] getConnectedBlocks(Block block) {
        return new Block[]{
                block.getRelative(0, 1, 0),
                block.getRelative(1, 0, 0),
                block.getRelative(-1, 0, 0),
                block.getRelative(0, 0, 1),
                block.getRelative(0, 0, -1),
                block.getRelative(0, -1, 0)
        };
    }

    public boolean isDragonAxe(ItemStack item) {
        return NBTUtil.isItem("scname", "dragon_axe", item);
    }
}
