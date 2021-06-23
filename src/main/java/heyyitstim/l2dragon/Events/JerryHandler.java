package heyyitstim.l2dragon.Events;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.PlayerInteractManager;
import net.minecraft.server.level.WorldServer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.entity.NPC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.UUID;

public class JerryHandler implements Listener {
    /*
        - If players first time clicking on Jerry, have some dialogue or something, need to figure that out
        - After first time, have an GUI menu that acts as an anvil to combine runes with tools/armor, that costs currency each time
     */

    public void spawnJerry() {
        // do stuff
    }

    @EventHandler
    public void onJerryClick(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof NPC){
            // do stuff
        }
    }
}
