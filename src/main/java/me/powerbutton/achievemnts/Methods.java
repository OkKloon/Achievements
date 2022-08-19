package me.powerbutton.achievemnts;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.songplayer.RadioSongPlayer;
import com.xxmicloxx.NoteBlockAPI.utils.NBSDecoder;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import java.io.File;

public class Methods {
    public static void setValue(Player player, String achievement) {
        Achievemnts.getInstance().getConfig().set(player.getName() + "." + achievement, true);
        Achievemnts.getInstance().saveConfig();
    } public static void playSound(Player player) {
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1000, 2);
        letFirework(player);
    } public static void letFirework(Player player) {
        Firework firework = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta meta = firework.getFireworkMeta();

        FireworkEffect.Builder builder = FireworkEffect.builder();
        builder.withTrail().withFlicker().withFade(Color.GREEN, Color.WHITE, Color.YELLOW, Color.BLUE,
                        Color.FUCHSIA, Color.PURPLE, Color.MAROON, Color.LIME, Color.ORANGE)
                .with(FireworkEffect.Type.BALL_LARGE);
        builder.withColor(Color.GREEN, Color.PURPLE, Color.ORANGE);
        meta.addEffect(builder.build());
        meta.setPower(0);
        firework.setFireworkMeta(meta);

    }
    public static void playSong(Player player, String path) {
        Song song = NBSDecoder.parse(new File(Achievemnts.getInstance().getServer().getPluginsFolder().getAbsolutePath() + "/" + path));
        RadioSongPlayer rsp = new RadioSongPlayer(song);
// Add player to SongPlayer so he will hear the song.
        rsp.addPlayer(player);
// Start RadioSongPlayer playback
        rsp.setPlaying(true);


    }
}
