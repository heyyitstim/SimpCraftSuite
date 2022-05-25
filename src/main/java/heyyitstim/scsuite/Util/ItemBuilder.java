package heyyitstim.scsuite.Util;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import heyyitstim.scsuite.Main;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.libs.org.codehaus.plexus.util.Base64;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
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
        meta = NBTUtil.addTag(meta, name, value);
        item.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setLeatherColor(Color color) {
        if (item.getType() != Material.LEATHER_BOOTS || item.getType() != Material.LEATHER_CHESTPLATE
                || item.getType() != Material.LEATHER_HELMET || item.getType() != Material.LEATHER_HELMET) { return this; }

        LeatherArmorMeta armorMeta = (LeatherArmorMeta) item.getItemMeta();
        armorMeta.setColor(color);

        item.setItemMeta(armorMeta);
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

        if (value == null || value.isEmpty() || item.getType() != Material.PLAYER_HEAD)
            return this;

        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", value).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));

        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);
        }catch (NoSuchFieldException | IllegalAccessException e) { e.printStackTrace(); }

        meta = skullMeta;
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
}