package me.powerbutton.achievemnts.listeners;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

public class CatFeedListener implements Listener {
    @EventHandler
    public void onFeed(PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Cat) {
            if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(new ItemStack(Material.SALMON))
                    ||e.getPlayer().getInventory().getItemInMainHand().isSimilar(new ItemStack(Material.COD))
            || e.getPlayer().getInventory().getItemInMainHand().isSimilar(new ItemStack(Material.TROPICAL_FISH))) {

                if (!Achievemnts.getInstance().getConfig().getBoolean(e.getPlayer().getName() + ".catfeed"))
                        {
                            Methods.grantAchievement(e.getPlayer(), "catfeed");
                            Methods.sendHoverableMessage(e.getPlayer(), "Pussy lover", "Pabaro kaķi ar zivi");
                            Methods.playSound(e.getPlayer());
                        }

            }




        }
    }
    @EventHandler
    public void onDogFeed(PlayerInteractEntityEvent e) {
        if (!Methods.isAchieved(e.getPlayer(), "dogfeeder")) {
        if (e.getRightClicked() instanceof Wolf) {
            if (e.getPlayer().getInventory().getItemInMainHand().isSimilar(new ItemStack(Material.BONE))) {
                Bukkit.getScheduler().runTaskLater(Achievemnts.getInstance(), () -> {
                    if (((Wolf) e.getRightClicked()).isTamed()) {
                        Methods.grantAchievement(e.getPlayer(), "dogfeeder");
                        Methods.sendHoverableMessage(e.getPlayer(), "Bitch Lover", "Padari suni par savu draugu :)");
                        Methods.playSound(e.getPlayer());
                    }
                }, 2);

            }

            }

        }

    }
}
