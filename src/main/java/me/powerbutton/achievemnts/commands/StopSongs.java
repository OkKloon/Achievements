package me.powerbutton.achievemnts.commands;

import me.powerbutton.achievemnts.Achievemnts;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StopSongs implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args){
if (sender instanceof Player p) {
   boolean bool = Achievemnts.getInstance().getConfig().getBoolean(p.getName() +".playsongs");
   if (!bool) {
       Achievemnts.getInstance().getConfig().set(p.getName() + ".playsongs", true);
       Achievemnts.getInstance().saveConfig();
       p.sendMessage(ChatColor.GREEN + "Tagad tu VARI dzirdēt ambient mūziku");

   } else {
       Achievemnts.getInstance().getConfig().set(p.getName() + ".playsongs", false);
       Achievemnts.getInstance().saveConfig();
       p.sendMessage(ChatColor.RED + "Tagad tu NEVARI dzirdēt ambient mūziku");
       p.stopAllSounds(); //d
   }


}





        return false;
    }
}
