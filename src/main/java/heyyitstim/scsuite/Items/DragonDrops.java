package heyyitstim.scsuite.Items;

import heyyitstim.scsuite.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.ThreadLocalRandom;

public class DragonDrops {

    private static final ItemStack SCALE = new ItemBuilder(Material.IRON_NUGGET)
            .setName("&6Dragon Scale")
            .addLore("")
            .addLore("&6&lLEGENDARY")
            .addGlow()
            .addStringNBT("scname", "dragon_scale")
            .build();

    public static void rewardPlayer(Player player, double scale) {
        int randomInt = ThreadLocalRandom.current().nextInt(1001);

        if (randomInt <= 200 * scale) {
            SCALE.setAmount(3);
            player.getInventory().addItem(SCALE);

            return;
        }

        if (randomInt <= 300 * scale) {
            SCALE.setAmount(2);
            player.getInventory().addItem(SCALE);

            return;
        }

        if (randomInt <= 400 * scale) {
            SCALE.setAmount(1);
            player.getInventory().addItem(SCALE);
        }
    }
}
