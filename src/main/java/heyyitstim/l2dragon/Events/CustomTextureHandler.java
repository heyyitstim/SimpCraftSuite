package heyyitstim.l2dragon.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CustomTextureHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().setResourcePack("https://drive.google.com/uc?id=1fD69tGaVzvBvUMWmIFlNJnlEan5Wgfet&export=download"); // resource pack link
    }
}
