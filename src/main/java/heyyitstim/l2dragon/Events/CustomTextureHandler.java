package heyyitstim.l2dragon.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CustomTextureHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().setResourcePack("https://www.dropbox.com/s/94nwed0atggtosn/SimpCraft%20v1.1.zip?dl=1"); // resource pack link
    }
}
