package me.powerbutton.achievemnts.listeners;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (e.getMessage().equalsIgnoreCase("I better call Saul!")) {
            if (!Methods.isAchieved(e.getPlayer(), "saul")) {

                Methods.setValue(e.getPlayer(), "saul");
                Methods.playSound(e.getPlayer());
                Methods.sendHoverableMessage(e.getPlayer(), "I better call Saul!", "Čatā uzrakstīt 'I better call Saul!'");

                Bukkit.getScheduler().runTaskLater(Achievemnts.getInstance(), () ->Methods.playSong(e.getPlayer(), "/bcs.nbs"),10 );

            }


        }




    }
}
