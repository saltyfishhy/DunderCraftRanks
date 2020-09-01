package me.saltyfishhy.DunderRanks;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equals("rank")) {
            Player p = (Player) sender;
            if (!p.isOp() || !Rank.hasRank(p, Rank.valueOf("HR"))) {
                p.sendMessage(ChatColor.RED + "HR" + ChatColor.GRAY + " Rank is required to perform this command.");
                return true;
            }
            else {
                if (args.length < 1) {
                    p.sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Please specify a target player.");
                    return true;
                }
                else {
                    RankGUI.openRankGUI(p, args[0]);
                    return true;
                }
            }
        }
        return false;
    }

}