package me.powerbutton.achievemnts.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CancelFireworkDamage implements Listener
{
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent e) {
        if (e.getDamager().hasMetadata("nodamage")) {
            e.setCancelled(true);//d
        }

    }
}
