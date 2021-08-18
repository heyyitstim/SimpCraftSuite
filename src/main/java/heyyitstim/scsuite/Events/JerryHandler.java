package heyyitstim.scsuite.Events;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import heyyitstim.scsuite.Packets.PacketReader;
import heyyitstim.scsuite.Packets.RightClickNPC;
import heyyitstim.scsuite.Util.ChatUtil;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.EntityPlayer;
import net.minecraft.server.level.WorldServer;
import net.minecraft.server.network.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.UUID;

public class JerryHandler implements Listener {
    /*
        - If players first time clicking on Jerry, have some dialogue or something, need to figure that out
        - After first time, have an GUI menu that acts as an anvil to combine runes with tools/armor, that costs currency each time
     */

    public static ArrayList<EntityPlayer> NPCs = new ArrayList<>();

    public static void spawnJerry(Location loc) {
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) loc.getWorld()).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), ChatUtil.color("&aJerry"));

        gameProfile.getProperties().put("textures", new Property("textures",
                "ewogICJ0aW1lc3RhbXAiIDogMTU5MDc5NzExNTA0NSwKICAicHJvZmlsZUlkIiA6ICI3NTE0NDQ4MTkxZTY0NTQ2OGM5NzM5YTZlMzk1N2JlYiIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGFua3NNb2phbmciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWY5MGEyZTY1NjYzNjE3ZGU4YWZlN2RlZDYwOTM1Mjg0NjI1ZDBiY2RiNDg3NzUxZGM2NTg5MjAyZjc2NGI5YSIKICAgIH0KICB9Cn0=",
                "rNjgi3BEiy2HzhUgikM/v8faIeYyM3g7wfFZl1RdZffFXxi7SZw8eY26A9YQepTfPCNILa68IzKlWPWOJnUnCOpPu1J89/1P5R5tda/psKEDGiRVUBVcCbkgPSFlq+JwBJrN0WbCusSsyFLy4YGfIF9K+lOAGExH2pMHqQMwYfGCcpbHClzZkJkjV7cTZhC6rxCtbKbMxKaR4PpPlLhocS9VBwm23x4FQzedK8cUBnk04wyN+BXKrm8VFeHRdDvEQMDOb7sdfRrh3P5BgNQq0u1wAbZ7QzC1eI0dCglueVRGkW3/U1djvkVobBbuURke+F0+YRtJv5tnU2/CDEuBThahNFC6FgA+Ve8QOJtCBeYpVmYSS2DOrw0qy/NbiwJq0BgrWCnvGa5VlnjjaB9BUfTLEYAeZRXD/K2ChHUR+svlVkRmm0N18gOp1cPOlt4PEQwHRhHTUFcyfktku0SFzm9oV7TzSgocU/F5fz312sVBAMRlJ+g0IRsXsxRj/ix6urrIzAiuybXEFWa344ZlBJp9rnAQOKAlTIv/XOxIp/XVI50QTAQzf9ddt1f32uNsV70Pn5P7H6rjRNSPp1eRcFrwhI7RmtH7x8IRMZvhJ8BwZiHFiPFiLPU+Am7KdZnGqYWCM+qh6QqkKEFnBBb6x/LzIKG+PpC4pMeF20kEjlQ="));

        EntityPlayer npc = new EntityPlayer(server, world, gameProfile);
        npc.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());

        NPCs.add(npc);


        addNPCPacket(npc, loc.getYaw());
    }

    private static void addNPCPacket(EntityPlayer npc, float yaw) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().b;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (yaw * 256.0f / 360.0f)));
        }
    }

    private static void addJoinPacket(Player player) {
        for (EntityPlayer npc : NPCs) {
            PlayerConnection connection = ((CraftPlayer) player).getHandle().b;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.a, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.y * 256.0f / 360.0f)));
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        PacketReader.uninject(e.getPlayer());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        addJoinPacket(e.getPlayer());

        PacketReader.inject(e.getPlayer());
    }

    @EventHandler
    public void onJerryClick(RightClickNPC e) {
        Player player = e.getPlayer();

        Inventory temp = Bukkit.createInventory(null, 54, ChatUtil.color("&bApply Runes"));

        player.openInventory(temp);
    }
}
