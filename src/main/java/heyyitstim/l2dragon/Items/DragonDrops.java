package heyyitstim.l2dragon.Items;

import org.bukkit.entity.EnderDragon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class DragonDrops {

    @EventHandler
    public void onEnderDragonDeath(EntityDeathEvent e){
        if(e.getEntity() instanceof EnderDragon){
            //do whatever
        }
    }
}
