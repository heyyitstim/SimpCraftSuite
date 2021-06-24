package heyyitstim.l2dragon.Items;

import heyyitstim.l2dragon.Util.ChatUtil;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class DragonDrops {

    private static final ItemStack SCALE = new ItemBuilder(Material.IRON_NUGGET)
            .setName("&cDragon Scale")
            .addLore("")
            .addLore("&7&oTaken from a slain dragon, this")
            .addLore("&7&oscale hums with magical energy.")
            .addGlow()
            .build();

    public static void rewardPlayer(Player player, double scale) {
        int randomInt = ThreadLocalRandom.current().nextInt(1001);

        if (randomInt <= 100 * scale) {
            SCALE.setAmount(3);
            player.getInventory().addItem(SCALE);

            return;
        }

        if (randomInt <= 200 * scale) {
            SCALE.setAmount(2);
            player.getInventory().addItem(SCALE);

            return;
        }

        if (randomInt <= 300 * scale) {
            SCALE.setAmount(1);
            player.getInventory().addItem(SCALE);
        }
    }
}
