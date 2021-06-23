package heyyitstim.l2dragon.Util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;
    private List<String> lore = new ArrayList<>();

    public ItemBuilder(Material m) {
        item = new ItemStack(m);
        meta = item.getItemMeta();
    }

    public ItemBuilder(Material m, int s) {
        item = new ItemStack(m, s);
        meta = item.getItemMeta();
    }

    public ItemBuilder setName(String name) {
        meta.setDisplayName(ChatUtil.color(name));
        return this;
    }

    public ItemBuilder addLore(String lore) {
        this.lore.add(ChatUtil.color(lore));
        meta.setLore(this.lore);
        return this;
    }

    public ItemBuilder setLore(List<String> lore) {
        this.lore = lore;
        meta.setLore(this.lore);
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level) {
        meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder setCustomModelNumber(int num) {
        meta.setCustomModelData(num);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }
}