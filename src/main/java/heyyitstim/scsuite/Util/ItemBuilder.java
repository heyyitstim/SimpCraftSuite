package heyyitstim.scsuite.Util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import heyyitstim.scsuite.Main;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
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

    public ItemBuilder addStringNBT(String name, String value) {
        item.setItemMeta(meta);
        item = NBTUtil.addTag(item, name, value);
        meta = item.getItemMeta();
        return this;
    }

    public ItemBuilder setLeatherColor(Color color) {
        if (item.getType() != Material.LEATHER_BOOTS && item.getType() != Material.LEATHER_CHESTPLATE
                && item.getType() != Material.LEATHER_HELMET && item.getType() != Material.LEATHER_LEGGINGS) { return this; }

        LeatherArmorMeta armorMeta = (LeatherArmorMeta) meta;
        armorMeta.setColor(color);

        this.meta = armorMeta;

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

    public ItemBuilder addTexture(String value) {
//
//        if (value == null || value.isEmpty() || item.getType() != Material.PLAYER_HEAD)
//            return this;
//
//        SkullMeta skullMeta = (SkullMeta) meta;
//        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
//        profile.getProperties().put("textures", new Property("textures", value));
//
//        try {
//            Field profileField = skullMeta.getClass().getDeclaredField("profile");
//            profileField.setAccessible(true);
//            profileField.set(skullMeta, profile);
//        }catch (NoSuchFieldException | IllegalAccessException e) { e.printStackTrace(); }

        return this;
    }

    public ItemBuilder addGlow() {
        addEnchant(Main.GlowEnchant, 0);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    public ItemBuilder hideEnchants() {
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }
}