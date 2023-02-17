package heyyitstim.scsuite.Events.ItemEffects;

import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PocketChestHandler implements Listener {

    private boolean isPocketChest(ItemStack item) {
        return NBTUtil.isItem("scname", "pocket_chest", item);
    }

    @EventHandler
    public void onChestLink(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (!isPocketChest(e.getPlayer().getInventory().getItemInMainHand()))
                return;

            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)
                return;

            if (e.getClickedBlock().getType().equals(Material.CHEST)) {
                e.setCancelled(true);

                Block b = e.getClickedBlock();

                ItemStack pocketChest = e.getItem();
                ItemMeta meta = pocketChest.getItemMeta();
                List<String> lore = e.getItem().getItemMeta().getLore();

                if (lore.size() >= 7)
                    return;

                lore.add("");
                lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "Linked to chest at:");
                lore.add(b.getWorld().getName() + "," + b.getX() + "," + b.getY() + "," + b.getZ());
                meta.setLore(lore);
                e.getPlayer().getInventory().getItemInMainHand().setItemMeta(meta);
            }
        }
    }

    @EventHandler
    public void onPlayerOpenLinkedChest(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            if (!isPocketChest(e.getPlayer().getInventory().getItemInMainHand()))
                return;

            List<String> lore = e.getItem().getItemMeta().getLore();
            if (lore.size() > 7) {
                String[] locationXYZ = lore.get(7).split(",");
                String worldName = locationXYZ[0];
                World world = Bukkit.getWorld(worldName);
                int x = Integer.parseInt(locationXYZ[1]);
                int y = Integer.parseInt(locationXYZ[2]);
                int z = Integer.parseInt(locationXYZ[3]);
                BlockState bs = world.getBlockAt(x, y, z).getState();
                Chest c = (Chest) bs;
                e.getPlayer().openInventory(c.getInventory());
            }
        }
    }
}

