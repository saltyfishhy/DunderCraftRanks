package me.saltyfishhy.DunderRanks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InvClick implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        if (RankGUI.rankGUI.containsKey((Player) e.getWhoClicked())) {
            OfflinePlayer targ = Bukkit.getOfflinePlayer(RankGUI.rankGUI.get((Player) e.getWhoClicked()));
            if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Default")) {
                e.getWhoClicked().closeInventory();
                RankGUI.rankGUI.remove((Player) e.getWhoClicked());
                Rank.setRank(targ, "NONE");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Successfully Changed Rank.");
            }
            else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Receptionist")) {
                e.getWhoClicked().closeInventory();
                RankGUI.rankGUI.remove((Player) e.getWhoClicked());
                Rank.setRank(targ, "RECEPTIONIST");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Successfully Changed Rank.");
            }
            else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Quality Assurance")) {
                e.getWhoClicked().closeInventory();
                RankGUI.rankGUI.remove((Player) e.getWhoClicked());
                Rank.setRank(targ, "QUALITY_ASSURANCE");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Successfully Changed Rank.");
            }
            else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Sales")) {
                e.getWhoClicked().closeInventory();
                RankGUI.rankGUI.remove((Player) e.getWhoClicked());
                Rank.setRank(targ, "SALES");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Successfully Changed Rank.");
            }
            else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("HR")) {
                e.getWhoClicked().closeInventory();
                RankGUI.rankGUI.remove((Player) e.getWhoClicked());
                Rank.setRank(targ, "HR");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Successfully Changed Rank.");
            }
            else if (ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()).equals("Regional Manager")) {
                e.getWhoClicked().closeInventory();
                RankGUI.rankGUI.remove((Player) e.getWhoClicked());
                Rank.setRank(targ, "REGIONAL_MANAGER");
                e.getWhoClicked().sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Successfully Changed Rank.");
            }
            else {
                e.setCancelled(true);
            }
        }
    }
}