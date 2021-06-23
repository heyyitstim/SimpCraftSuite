package heyyitstim.l2dragon.Util;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CustomLootTable {

    private ArrayList<LootItem> loot;
    private int totalWeight;
    private int chanceToFillSlot;

    public CustomLootTable(int chanceToFillSlot) {
        loot = new ArrayList<>();
        totalWeight = 0;
        this.chanceToFillSlot = chanceToFillSlot;
    }

    public void addItem(ItemStack item, int weight) {
        loot.add(new LootItem(item, weight));
        totalWeight += weight;
    }

    public void populateInventory(Inventory inv) {
        for (int slot = 0; slot < inv.getSize(); slot++) {
            int doesFillSlot = ThreadLocalRandom.current().nextInt(0, 100);

            if (doesFillSlot > chanceToFillSlot)
                continue;

            inv.setItem(slot, getSingleItem());
        }
    }

    public ItemStack getSingleItem() {
        int randomNumber = ThreadLocalRandom.current().nextInt(0, totalWeight);
        int currentMax = 0;

        for (LootItem item : loot) {
            currentMax += item.getWeight();

            if (randomNumber <= currentMax) {
                return item.getItem();
            }
        }

        return null;
    }

    // Items for looting
    private static class LootItem {

        private final ItemStack item;
        private final int weight;

        public LootItem(ItemStack item, int weight) {
            this.item = item;
            this.weight = weight;
        }

        public ItemStack getItem() {
            return item;
        }

        public int getWeight() {
            return weight;
        }
    }
}
