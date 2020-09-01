package me.saltyfishhy.DunderRanks;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RankGUI {

    public static HashMap<Player, UUID> rankGUI = new HashMap<>();

    public static void openRankGUI(Player p, String name) {
        try {
            Player targ = Bukkit.getPlayer(name);
            ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            String rank = Rank.getRank(targ);
            ItemMeta meta = skull.getItemMeta();
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "Rank: " + rank);
            skullMeta.setLore(lore);
            skullMeta.setDisplayName(ChatColor.RED + targ.getName());
            skullMeta.setOwningPlayer(targ);
            skull.setItemMeta(skullMeta);
            Inventory inv = Bukkit.createInventory(null, 54, ChatColor.RED + targ.getName() + "'s" + ChatColor.DARK_GRAY + "rank");
            List<String> lore2 = new ArrayList<>();
            lore2.add(ChatColor.DARK_GRAY + "Click to apply");
            ItemStack item = getWool(Material.GRAY_WOOL, ChatColor.GRAY + "Default", lore2);
            createItem(item, 19, inv);
            inv.setItem(0, skull);
            ItemStack item3 = getWool(Material.BLUE_WOOL, ChatColor.GRAY + "Receptionist", lore2);
            createItem(item3, 21, inv);
            ItemStack item4 = getWool(Material.LIME_WOOL, ChatColor.GRAY + "Quality Assurance", lore2);
            createItem(item4, 22, inv);
            ItemStack item5 = getWool(Material.YELLOW_WOOL, ChatColor.GRAY + "Sales", lore2);
            createItem(item5, 23, inv);
            ItemStack item6 = getWool(Material.ORANGE_WOOL, ChatColor.GRAY + "HR", lore2);
            createItem(item6, 24, inv);
            ItemStack item7 = getWool(Material.RED_WOOL, ChatColor.GRAY + "Regional Manager", lore2);
            createItem(item7, 25, inv);
            rankGUI.put(p, targ.getUniqueId());
            p.openInventory(inv);
        } catch (Exception e) {
            UUID uuidPlayer = null;
            for (String key : Main.data.getConfig().getKeys(false)) {
                Main.getInstance().getLogger().info(key);
                if (Main.data.getConfig().getString(key + ".name").equals(name)) {
                    uuidPlayer = UUID.fromString(key);
                }
            }
            if (uuidPlayer != null) {
                OfflinePlayer targOff = Bukkit.getOfflinePlayer(uuidPlayer);
                ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
                SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                String rank = Rank.getRank(targOff);
                ItemMeta meta = skull.getItemMeta();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "Rank: " + rank);
                skullMeta.setLore(lore);
                skullMeta.setDisplayName(ChatColor.RED + targOff.getName());
                skullMeta.setOwningPlayer(targOff);
                skull.setItemMeta(skullMeta);
                Inventory inv = Bukkit.createInventory(null, 54, ChatColor.RED + targOff.getName() + "'s" + ChatColor.DARK_GRAY + "rank");
                List<String> lore2 = new ArrayList<>();
                lore2.add(ChatColor.DARK_GRAY + "Click to apply");
                ItemStack item = getWool(Material.GRAY_WOOL, ChatColor.GRAY + "Default", lore2);
                createItem(item, 19, inv);
                inv.setItem(0, skull);
                ItemStack item3 = getWool(Material.BLUE_WOOL, ChatColor.GRAY + "Receptionist", lore2);
                createItem(item3, 21, inv);
                ItemStack item4 = getWool(Material.LIME_WOOL, ChatColor.GRAY + "Quality Assurance", lore2);
                createItem(item4, 22, inv);
                ItemStack item5 = getWool(Material.YELLOW_WOOL, ChatColor.GRAY + "Sales", lore2);
                createItem(item5, 23, inv);
                ItemStack item6 = getWool(Material.ORANGE_WOOL, ChatColor.GRAY + "HR", lore2);
                createItem(item6, 24, inv);
                ItemStack item7 = getWool(Material.RED_WOOL, ChatColor.GRAY + "Regional Manager", lore2);
                createItem(item7, 25, inv);
                rankGUI.put(p, targOff.getUniqueId());
                p.openInventory(inv);
            } else {
                p.sendMessage(ChatColor.DARK_GRAY + "Rank> " + ChatColor.GRAY + "Offline Player not found.");
            }
        }
    }

    public static ItemStack getWool(Material type, String name, List<String> lore) {
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(lore);
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static void createItem(ItemStack item, Integer slot, Inventory inv) {
        inv.setItem(slot, item);
    }
}


