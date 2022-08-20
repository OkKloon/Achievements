package me.powerbutton.achievemnts.commands;

import me.powerbutton.achievemnts.Achievemnts;
import me.powerbutton.achievemnts.Methods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ForcePlay implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof ConsoleCommandSender) {

            for (Player players : Bukkit.getOnlinePlayers()) {
                if (Achievemnts.getInstance().getConfig().getBoolean(players.getName() + ".playsongs")) {
                    if (players.getLocation().getY() > 60) {
                        Methods.playSong(players, "/upper.nbs");
                        players.sendMessage(ChatColor.GREEN + "Ja tu vairāk negribi dzirdēt šīs dziesmas raksti '/song'");
                    } else if (players.getLocation().getY() < 0) {
                        Methods.playSong(players, "/cave.nbs");
                        players.sendMessage(ChatColor.GREEN + "Ja tu vairāk negribi dzirdēt šīs dziesmas raksti '/song'");
                    }


                }

            }


        }
        return false;

    }
}
