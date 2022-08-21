package me.powerbutton.achievemnts;

import me.powerbutton.achievemnts.commands.ForcePlay;
import me.powerbutton.achievemnts.commands.StopSongs;
import me.powerbutton.achievemnts.listeners.BlockBreaksListener;
import me.powerbutton.achievemnts.listeners.CancelFireworkDamage;
import me.powerbutton.achievemnts.listeners.CatFeedListener;
import me.powerbutton.achievemnts.listeners.EntityListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ThreadLocalRandom;

public final class Achievemnts extends JavaPlugin {
private static Achievemnts instance;
public static Achievemnts getInstance() {
    return instance;
}

    @Override
    public void onEnable(){
        // Plugin startup logic
instance=this;
saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new BlockBreaksListener(), this);
        Bukkit.getPluginManager().registerEvents(new CancelFireworkDamage(), this);
        Bukkit.getPluginManager().registerEvents(new CatFeedListener(), this);

        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);
        getCommand("songs").setExecutor(new StopSongs());        getCommand("forceplay").setExecutor(new ForcePlay());

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
int random = ThreadLocalRandom.current().nextInt(4);
if (random == 0) {
    System.out.println("vajadzetu but, ka saktu spelet muziku");
    for (Player players : Bukkit.getOnlinePlayers()) {
        players.sendMessage(ChatColor.GRAY + "" + ChatColor.ITALIC +"Atgādinājums, dziesmas var atkal ieslēgt, izdarot '/songs'");
        if (this.getConfig().getBoolean(players.getName()+ ".playsongs")) {
            if (players.getLocation().getY() >60) {
            Methods.playSong(players, "/upper.nbs");
                players.sendMessage(ChatColor.GREEN + "Ja tu vairāk negribi dzirdēt šīs dziesmas raksti '/songs'");
            } else if (players.getLocation().getY() < 0) {
                Methods.playSong(players, "/cave.nbs");
                players.sendMessage(ChatColor.GREEN + "Ja tu vairāk negribi dzirdēt šīs dziesmas raksti '/songs'");
            }//d

        }
    }

}


        }, 100, 5000);

    }

    @Override
    public void onDisable(){
        // Plugin shutdown logic
    }
}
