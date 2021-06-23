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

    private static final ItemStack SCALE = new ItemBuilder(Material.IRON_NUGGET, 1)
            .setName("&cDragon Scale")
            .addLore("")
            .addLore("&7&oTaken from a slain dragon, this")
            .addLore("&7&oscale hums with magical energy.")
            .build();

    public GenerateLoot() {
        lootTable = new CustomLootTable(0); // The 0 doesn't matter other than filling a custom chest

        lootTable.addItem(SCALE, 1000);

        SCALE.setAmount(2);
        lootTable.addItem(SCALE, 200);

        SCALE.setAmount(3);
        lootTable.addItem(SCALE, 100);
    }

    @EventHandler
    public void lootGenerationEvent(LootGenerateEvent e) {
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
