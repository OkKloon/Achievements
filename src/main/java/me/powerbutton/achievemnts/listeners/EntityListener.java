package me.powerbutton.achievemnts.listeners;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import me.powerbutton.achievemnts.Prefix;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.checkerframework.checker.units.qual.A;

public class EntityListener implements Listener {
    @EventHandler
    public void onSting(EntityDamageByEntityEvent e ){
        if (e.getDamager() instanceof Bee bee) {
            if (e.getEntity() instanceof Player p) {
                if (!Achievemnts.getInstance().getConfig().getBoolean(p.getName() + ".beesting")) {
                    Methods.setValue(p, ".beesting");
                    Methods.playSound(p);
                    p.sendMessage(Prefix.prefix + "random ass");
                }
            }
        }

    }
}
