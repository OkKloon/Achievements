package me.powerbutton.achievemnts.listeners;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import me.powerbutton.achievemnts.Prefix;
import org.bukkit.entity.Bee;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.checkerframework.checker.units.qual.A;

public class EntityListener implements Listener {
    @EventHandler
    public void onSting(EntityDamageByEntityEvent e ){
        if (e.getDamager() instanceof Bee bee) {
            if (e.getEntity() instanceof Player p) {
                if (!Achievemnts.getInstance().getConfig().getBoolean(p.getName() + ".beesting")) {
                    Methods.setValue(p, ".beesting");
                    Methods.playSound(p);

                    Methods.sendHoverableMessage(p,  "random ass", "Bitei tev jāiedzeļ");
                }
            }
        }

    }
    @EventHandler
    public void onKill(EntityDeathEvent e) {
        if (e.getEntity() instanceof Monster)return;
        else {
            if (e.getEntity().getKiller() != null) {
                if (!Achievemnts.getInstance().getConfig().getBoolean(e.getEntity().getKiller().getName() + "killer")) {
                if (Achievemnts.getInstance().getConfig().getInt(e.getEntity().getKiller().getName() + ".kills") < 500) {
                    Achievemnts.getInstance().getConfig().set(e.getEntity().getKiller().getName() + ".kills", Achievemnts.getInstance().getConfig().getInt(e.getEntity().getKiller().getName() + ".kills") + 1);
                    Achievemnts.getInstance().saveConfig();
                }
                } else if (Achievemnts.getInstance().getConfig().getInt(e.getEntity().getKiller().getName() + ".kills") == 500) {
                        Methods.setValue(e.getEntity().getKiller(), "killer");
                        Methods.playSound(e.getEntity().getKiller());
                        Methods.sendHoverableMessage(e.getEntity().getKiller() , "Slepkava", "Nogalini 500 friendly mobs");



                }
            }
        }


    } @EventHandler
    public void onKilling(EntityDeathEvent e) {
        Player p = e.getEntity().getKiller();
        if (e.getEntity() instanceof Player target) {
            assert p != null;
            if (!Achievemnts.getInstance().getConfig().getBoolean(p.getName() + ".powerbuttonkiller"))
                if (target.getName().equals("Power_Button")) {


                Methods.setValue(p, "powerbuttonkiller");
                Methods.playSound(p);
                Methods.sendHoverableMessage(p, Prefix.prefix +"I'm the Power_Button now", "Nogalini Power_Button (Artūru)");
            }
        }
    }
}
