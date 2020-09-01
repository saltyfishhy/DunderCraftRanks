package me.saltyfishhy.DunderRanks;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!Main.data.getConfig().getKeys(false).contains(e.getPlayer().getUniqueId().toString())) {
            Main.data.getConfig().createSection(e.getPlayer().getUniqueId().toString());
            Main.data.getConfig().createSection(e.getPlayer().getUniqueId().toString() + ".rank");
            Main.data.getConfig().set(e.getPlayer().getUniqueId().toString() + ".name", e.getPlayer().getName());
            Main.data.getConfig().set(e.getPlayer().getUniqueId().toString() + ".rank", "NONE");
            Main.data.saveConfig();
        }
    }

}