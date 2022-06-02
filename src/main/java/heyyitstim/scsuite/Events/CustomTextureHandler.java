package heyyitstim.scsuite.Events;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import net.md_5.bungee.api.chat.TextComponent;

public class CustomTextureHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        e.getPlayer().setResourcePack("https://www.dropbox.com/s/003q8gt87zmasee/SimpCraft%20v2.0.zip?dl=1"); // resource pack link

        TextComponent message = new TextComponent("Click HERE to view the Wiki!");
        message.setColor(ChatColor.GREEN);
        message.setBold(true);
        message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/heyyitstim/SimpCraftSuite/wiki"));
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ChatColor.GRAY + "" + ChatColor.ITALIC + "Click here to open the Wiki!")));
        p.spigot().sendMessage(message);
    }
}
