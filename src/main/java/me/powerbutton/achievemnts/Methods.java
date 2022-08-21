package me.powerbutton.achievemnts;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.*;
import org.bukkit.Color;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.io.File;

public class Methods {
    public static void grantAchievement(Player player, String achievement) {
        Achievemnts.getInstance().getConfig().set(player.getName() + "." + achievement, true);
        Achievemnts.getInstance().saveConfig(); //d
    }

    public static void playSound(Player player) {
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1000, 2);
        letFirework(player);
    }

    public static void letFirework(Player player) {
        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();

        FireworkEffect.Builder builder = FireworkEffect.builder();
        builder.withTrail().withFlicker().withFade(Color.GREEN, Color.WHITE, Color.YELLOW, Color.BLUE,
                        Color.FUCHSIA, Color.PURPLE, Color.MAROON, Color.LIME, Color.ORANGE)
                .with(FireworkEffect.Type.BALL_LARGE);
        builder.withColor(Color.GREEN, Color.PURPLE, Color.ORANGE);
        firework.setMetadata("nodamage", new FixedMetadataValue(Achievemnts.getInstance(), true));
        meta.addEffect(builder.build());
        meta.setPower(0);
        firework.setFireworkMeta(meta);

    }

    public static void playSong(Player player, String path) {
        Song song = NBSDecoder.parse(new File(Achievemnts.getInstance().getDataFolder().getAbsolutePath() + path));
        RadioSongPlayer rsp = new RadioSongPlayer(song);
// Add player to SongPlayer so he will hear the song.
        rsp.addPlayer(player);
// Start RadioSongPlayer playback
        rsp.setPlaying(true);


    }

    public static void sendHoverableMessage(Player player, String message, String hoverable) {
        TextComponent msg = new TextComponent(ChatColor.translateAlternateColorCodes('&', Prefix.prefix + message));
        msg.setHoverEvent(new net.md_5.bungee.api.chat.HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GOLD +hoverable).create()));
        player.spigot().sendMessage(msg);
    }
    public static boolean isAchieved(Player player, String achievement) {
return Achievemnts.getInstance().getConfig().getBoolean(player.getName() + "." +achievement);
    }
}
