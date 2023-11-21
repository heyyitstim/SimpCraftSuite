package heyyitstim.scsuite.Items.Drugs.Handlers;

import com.google.gson.JsonObject;
import heyyitstim.scsuite.Main;
import heyyitstim.scsuite.Util.NBTUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HempCropHandler implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        // Check if the player placed a hemp seed
        if (!isHempSeed(event.getPlayer().getInventory().getItemInMainHand()))
            return;

        if (event.getBlockPlaced().getType() == Material.WHEAT_SEEDS) {
            // Replace the seeds block with a hemp crop block
            Block block = event.getBlock();
            block.setType(Material.AIR);
            block.setType(Material.WHEAT); // Replace with the custom crop material

            //Set the growth state to the first stage
            Ageable ageable = (Ageable) block.getBlockData();
            ageable.setAge(0);
            block.setBlockData(ageable);
        }
    }

    public boolean isHempSeed(ItemStack item) {
        return NBTUtil.isItem("scname", "hemp_seed", item);
    }

}
