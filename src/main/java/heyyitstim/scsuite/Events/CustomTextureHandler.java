package heyyitstim.scsuite.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CustomTextureHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.getPlayer().setResourcePack("https://www.dropbox.com/s/qre7yigmcp72f2c/SimpCraft%20v1.2.zip?dl=1"); // resource pack link
    }
}
