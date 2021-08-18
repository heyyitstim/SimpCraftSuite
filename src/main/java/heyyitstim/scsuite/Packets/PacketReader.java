package heyyitstim.scsuite.Packets;

import heyyitstim.scsuite.Events.JerryHandler;
import heyyitstim.scsuite.Main;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.PacketPlayInUseEntity;
import net.minecraft.server.level.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PacketReader {

    static Channel channel;
    public static Map<UUID, Channel> channels = new HashMap<>();

    public static void inject(Player player) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        channel = craftPlayer.getHandle().b.a.k;
        channels.put(player.getUniqueId(), channel);

        if (channel.pipeline().get("PacketInjector") != null)
            return;

        channel.pipeline().addAfter("decoder", "PacketInjector", new MessageToMessageDecoder<PacketPlayInUseEntity>() {
            @Override
            protected void decode(ChannelHandlerContext channelHandlerContext, PacketPlayInUseEntity packetPlayInUseEntity, List<Object> arg) throws Exception {
                arg.add(packetPlayInUseEntity);
                readPacket(player, packetPlayInUseEntity);
            }
        });
    }

    public static void uninject(Player player) {
        channel = channels.get(player.getUniqueId());
        if (channel.pipeline().get("PacketInjector") != null) {
            channel.pipeline().remove("PacketInjector");
        }
    }

    public static void readPacket(Player player, Packet<?> packet) {
        if (packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayInUseEntity")) {

            Object action = getValue(packet, "b");

            if (action == null)
                return;

            Object isRightClick1 = getValue(action, "a");
            Object isRightClick2 = getValue(action, "b");

            if (isRightClick1 == null || isRightClick2 == null || !isRightClick1.toString().equalsIgnoreCase("MAIN_HAND"))
                return;

            int id = (int) getValue(packet, "a");

            for (EntityPlayer npc : JerryHandler.NPCs) {
                if (npc.getId() == id) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, () -> Bukkit.getPluginManager().callEvent(new RightClickNPC(player, npc)), 0);
                }
            }
        }
    }

    private static Object getValue(Object instance, String name) {
        Object result = null;

        if (!hasField(instance, name)) {
            return null;
        }

        try {
            Field field = instance.getClass().getDeclaredField(name);
            field.setAccessible(true);
            result = field.get(instance);
            field.setAccessible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private static boolean hasField(Object obj, String name) {
        for(Field field : obj.getClass().getDeclaredFields()){
            if(field.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }
}
