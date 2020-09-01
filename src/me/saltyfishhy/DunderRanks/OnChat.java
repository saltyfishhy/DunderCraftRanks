package me.saltyfishhy.DunderRanks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class OnChat implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
        Rank r = Rank.valueOf(Rank.getRank(e.getPlayer()));
        String chatFormat = Main.getInstance().getConfig().getString("chatformat");
        chatFormat = chatFormat.replace("%prefix%", r.getPrefix());
        chatFormat = chatFormat.replace("%name%", e.getPlayer().getName());
        chatFormat = chatFormat.replace("%message%", e.getMessage());
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', chatFormat));
    }

}
