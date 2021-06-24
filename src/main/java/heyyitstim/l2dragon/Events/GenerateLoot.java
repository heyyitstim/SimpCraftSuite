package heyyitstim.l2dragon.Events;

import heyyitstim.l2dragon.Util.CustomLootTable;
import heyyitstim.l2dragon.Util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateLoot implements Listener {

    private static CustomLootTable lootTable;

    public GenerateLoot() {
        /* The 0 is the percent that a slot is filled. Since we're not over writing chest data we set this to 0 as we don't need it as the
        * get single item method doesn't use this. It's only used for populating inventories. */
        lootTable = new CustomLootTable(0);

        ItemStack GoldCoin = new ItemBuilder(Material.GOLD_NUGGET, 1)
                .setName("&6Gold Coin")
                .build();
        lootTable.addItem(GoldCoin, 1000);

        GoldCoin = new ItemBuilder(Material.GOLD_NUGGET, 2)
                .setName("&6Gold Coin")
                .build();
        lootTable.addItem(GoldCoin, 200);

        GoldCoin = new ItemBuilder(Material.GOLD_NUGGET, 3)
                .setName("&6Gold Coin")
                .build();
        lootTable.addItem(GoldCoin, 100);
    }

    @EventHandler
    public void lootGenerationEvent(LootGenerateEvent e) {
        int doesSpawn = getRandomInt(100);
        if (doesSpawn > 10) // 10 is the percent chance that a special item from the loot table spawns.
            return;

        ArrayList<Integer> emptySlots = getEmptySlots(e.getInventoryHolder().getInventory()); // Leave these two lines alone
        int randomSlot = emptySlots.get(getRandomInt(emptySlots.size())); // Generates a random slot to use from the ones available.

        e.getInventoryHolder().getInventory().setItem(randomSlot, lootTable.getSingleItem()); // Leave this the same, change SCALE
    }

    private ArrayList<Integer> getEmptySlots(Inventory inventory) {
        ArrayList<Integer> emptySlots = new ArrayList<>(); // List of empty slots

        for (int i = 0 ; i < inventory.getSize() ; i++) { // Checks every slot
            ItemStack item = inventory.getItem(i);
            if (item == null || item.getType() == Material.AIR) { // Checks if slot is empty
                emptySlots.add(i); // Adds empty slot to the list
            }
        }

        return emptySlots; // Returns arraylist of usable slots.
    }

    private int getRandomInt(int max) {
        return getRandomInt(0, max);
    }

    private int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

}
