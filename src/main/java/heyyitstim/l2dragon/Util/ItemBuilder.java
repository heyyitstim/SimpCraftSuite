package heyyitstim.l2dragon.Util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemBuilder {

    private ItemStack item;
    private ItemMeta meta;
    private List<String> lore = new ArrayList<>();

    public ItemBuilder(Material m) {
        this(m, 1);
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

    public ItemBuilder addAttribute(Attribute attribute, String name, double amount, EquipmentSlot slot) {
        meta.addAttributeModifier(attribute, new AttributeModifier(UUID.randomUUID(), name, amount, AttributeModifier.Operation.ADD_NUMBER, slot));
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }
}