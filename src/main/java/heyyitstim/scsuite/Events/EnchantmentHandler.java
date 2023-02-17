package heyyitstim.scsuite.Events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnchantmentHandler implements Listener {

    @EventHandler
    public void onEnchant(EnchantItemEvent e){
        ItemStack item = e.getItem();
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        if(lore!=null){
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            int index = 0;
            while(!lore.get(index).equals("")){ //Skip to the first blank line in lore
                index++;
            }

            Map<Enchantment, Integer> enchants = e.getEnchantsToAdd();
            for(Enchantment enchantment : enchants.keySet()){
                String enchantName = EnchantmentNames.get(enchantment);
                int enchantLevel = enchants.get(enchantment);
                lore.add(index, "§7"+enchantName +" "+ enchantLevel);

                index++;
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
        }
    }

    private static HashMap<Enchantment, String> EnchantmentNames = new HashMap<Enchantment, String>();
    static{
        for(Enchantment enchant : Enchantment.values()){
            EnchantmentNames.put(enchant, enchant.getKey().toString());
        }//For loop just to give all enchants a temp name using NamespacedKey. Don't need this if you manually add all of them below.
        //EnchantmentNames.put(Enchantment.ARROW_DAMAGE, "Power");
        //EnchantmentNames.put(Enchantment.ARROW_KNOCKBACK, "Punch");
    }
}
