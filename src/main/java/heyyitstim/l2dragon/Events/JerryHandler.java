package heyyitstim.l2dragon.Events;

import org.bukkit.entity.NPC;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
