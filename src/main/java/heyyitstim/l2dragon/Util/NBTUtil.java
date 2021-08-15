package heyyitstim.l2dragon.Util;

import heyyitstim.l2dragon.Main;
import org.bukkit.NamespacedKey;
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

    public static boolean hasStringTag(ItemMeta meta, String name) {
        NamespacedKey key = new NamespacedKey(Main.instance, name);
        PersistentDataContainer container = meta.getPersistentDataContainer();

        return container.has(key , PersistentDataType.STRING);
    }

}