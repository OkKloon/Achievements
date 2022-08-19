package me.powerbutton.achievemnts.listeners;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import me.powerbutton.achievemnts.Prefix;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreaksListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.EMERALD_ORE || e.getBlock().getType() == Material.DEEPSLATE_EMERALD_ORE) {
            if (!Achievemnts.getInstance().getConfig().getBoolean(e.getPlayer().getName() + ".firstemerald")) {
                Methods.setValue(e.getPlayer(), "firstemerald");
                e.getPlayer().sendMessage(Prefix.prefix + "Villager simp");
                Methods.playSound(e.getPlayer());
            }


         }


    }
}
