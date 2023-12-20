package org.bluebudbc.bbccore;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof  Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Usage:/sc (Message)");
            }else{
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if(player.hasPermission("BBCCORE.staffchat")) {
                        String message = String.join(" ", args);
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "[" + ChatColor.DARK_PURPLE + "StaffChat" + ChatColor.LIGHT_PURPLE + "]" + ChatColor.WHITE + " " + sender.getName() + " " + ChatColor.DARK_GRAY + "|" + " " + ChatColor.WHITE + message);

                    }
                }

            }

        }
        return false;
    }
}
