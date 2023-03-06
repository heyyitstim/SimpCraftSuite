package heyyitstim.scsuite.Events.ToolEffects.DragonToolEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class DragonShovelHandler implements Listener {

    List<Block> blocks = new ArrayList<>();

    BlockFace blockface = null;

    private boolean isDragonShovel(ItemStack dragonShovel) {
        return NBTUtil.isItem("scname", "dragon_shovel", dragonShovel);
    }

    private void giveMiningFatigue(Player p) {
        p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 7*24*60*60*20, 0));
    }

    private void removeMiningFatigue(Player p) {
        p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
    }

    @EventHandler
    public void heldItem(PlayerItemHeldEvent e) {
        Player p = e.getPlayer();
        ItemStack heldItem = p.getInventory().getItem(e.getNewSlot());

        if (isDragonShovel(heldItem)) {
            giveMiningFatigue(p);
        }
        else {
            removeMiningFatigue(p);
        }
    }

    @EventHandler
    public void disableEnchanting(EnchantItemEvent e) {
        ItemStack item = e.getItem();
        if (isDragonShovel(item)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if(e.getAction().equals(Action.LEFT_CLICK_BLOCK)){
            blockface = e.getBlockFace();
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Block block = e.getBlock();

        if (isDragonShovel(e.getPlayer().getInventory().getItemInMainHand())) {
            if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                blocks.add(block.getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.WEST));
                blocks.add(block.getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.SOUTH));
                blocks.add(block.getRelative(BlockFace.SOUTH_WEST));
                blocks.add(block.getRelative(BlockFace.SOUTH_EAST));
                blocks.add(block.getRelative(BlockFace.NORTH_WEST));
                blocks.add(block.getRelative(BlockFace.NORTH_EAST));
            }
            if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                blocks.add(block.getRelative(BlockFace.UP));
                blocks.add(block.getRelative(BlockFace.DOWN));
                blocks.add(block.getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.SOUTH));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.SOUTH));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.NORTH));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.SOUTH));
            }
            if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                blocks.add(block.getRelative(BlockFace.UP));
                blocks.add(block.getRelative(BlockFace.DOWN));
                blocks.add(block.getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.WEST));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.UP).getRelative(BlockFace.WEST));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.EAST));
                blocks.add(block.getRelative(BlockFace.DOWN).getRelative(BlockFace.WEST));
            }
            for(Block b : blocks){
                /*
                To add exceptions, for example, certain blocks not to be mined by the Multibreak Pickaxe, you add this if statement before the block break line:
                if(b.getType() != Material.IRON_ORE && b.getType() != Material.DIRT){
                    b.breakNaturally(event.getPlayer().getInventory().getItemInMainHand());
                }
                This example used is for Iron Ore and Dirt blocks, to change the type of material to ignore, just change the name of the material.
                */
                b.breakNaturally(e.getPlayer().getInventory().getItemInMainHand());
            }
            blocks.clear();
        }
    }
}
