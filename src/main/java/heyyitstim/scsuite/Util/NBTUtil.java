package heyyitstim.scsuite.Util;

import heyyitstim.scsuite.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class NBTUtil {

    public static ItemMeta addTag(ItemMeta meta, String name, String value) {
        NamespacedKey key = new NamespacedKey(Main.instance, name);
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, value);
        return meta;
    }

    public static String getStringTag(ItemMeta meta, String name) {
        NamespacedKey key = new NamespacedKey(Main.instance, name);
        PersistentDataContainer container = meta.getPersistentDataContainer();

        if(container.has(key , PersistentDataType.STRING)) {
            return container.get(key, PersistentDataType.STRING);
        }

        return null;
    }

    public static boolean isItem(String name, String equal, ItemStack item) {
        if (!item.hasItemMeta() || !item.getItemMeta().hasLore())
            return false;

        ItemMeta meta = item.getItemMeta();
        String tag = NBTUtil.getStringTag(meta, name);

        if (tag == null)
            return false;

        return tag.equalsIgnoreCase(equal);
    }
}
