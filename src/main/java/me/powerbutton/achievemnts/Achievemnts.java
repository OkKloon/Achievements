package me.powerbutton.achievemnts;

import me.powerbutton.achievemnts.listeners.BlockBreaksListener;
import me.powerbutton.achievemnts.listeners.EntityListener;
import org.bukkit.Bukkit;
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
        Bukkit.getPluginManager().registerEvents(new EntityListener(), this);

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
int random = ThreadLocalRandom.current().nextInt(4);
if (random == 0) {
    for (Player players : Bukkit.getOnlinePlayers()) {
        if (this.getConfig().getBoolean(players.getName()+ ".playsongs")) {
            if (players.getLocation().getY() >68) {
            Methods.playSong(players, "upper.nbs");
            } else if (players.getLocation().getY() < 0) {
                Methods.playSong(players, "cave.nbs");
            }

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
