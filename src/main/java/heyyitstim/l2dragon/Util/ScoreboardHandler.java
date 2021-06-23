package heyyitstim.l2dragon.Util;

import heyyitstim.l2dragon.Events.DragonHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;

public class ScoreboardHandler {

    private Scoreboard board;
    private ArrayList<ScoreboardLine> lines;
    private Player player;

    public ScoreboardHandler(Player p) {
        this.player = p;

        lines = new ArrayList<>();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard(); // Creates a score board

        Objective objective = board.registerNewObjective("EnderDragon", "dummy"); // Sets the scoreboard name to game name and it can only change with commands
        objective.setDisplaySlot(DisplaySlot.SIDEBAR); // Set the position to be the sidebar
        objective.setDisplayName(ChatUtil.color("&5EnderDragon")); // Added the scoreboard header of UHC-?

        for (int i = 0; i < 15; i++) {
            lines.add(new ScoreboardLine(objective, "", i));
        }
    }

    // Updates the players stats
    private void updateBoard() {
        lines.get(3).update(" ");
        lines.get(2).update(" ");
        lines.get(1).update(" &dYour Damage » " + DragonHandler.damagers.get(player.getUniqueId()));
        lines.get(0).update("    ");
    }

    // Sends an updated scoreboard to all players
    public void sendToPlayer() {
        updateBoard();
        player.setScoreboard(board);
    }

    public Player getPlayer() {
        return player;
    }
}
