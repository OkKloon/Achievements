package me.powerbutton.achievemnts.listeners;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import me.powerbutton.achievemnts.Prefix;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreaksListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.EMERALD_ORE || e.getBlock().getType() == Material.DEEPSLATE_EMERALD_ORE) {
            if (!Achievemnts.getInstance().getConfig().getBoolean(e.getPlayer().getName() + ".firstemerald")) {
                Methods.grantAchievement(e.getPlayer(), "firstemerald");
                Methods.sendHoverableMessage(e.getPlayer(),"Villager simp", "Izroc emerald ore");

                Methods.playSound(e.getPlayer()); //d
            }


         }


    }
    @EventHandler
    public  void onBreaking(BlockBreakEvent e ) {
        if (Achievemnts.getInstance().getConfig().getInt(e.getPlayer().getName() + ".blocksbroken") <10000) {
            Achievemnts.getInstance().getConfig().set(e.getPlayer().getName() + ".blocksbroken",
                    Achievemnts.getInstance().getConfig()
                            .getInt(e.getPlayer().getName() + ".blocksbroken") + 1);
Achievemnts.getInstance().saveConfig();

        } else if (Achievemnts.getInstance().getConfig().getInt(e.getPlayer().getName() + ".blocksbroken") == 10000) {
            Methods.grantAchievement(e.getPlayer(), ".blocksbroken");
            Methods.playSound(e.getPlayer());
            Methods.sendHoverableMessage(e.getPlayer(),Prefix.prefix + "Bloku ultra racējs", "Izroc 10000 blokus" );

        }


    }
}
