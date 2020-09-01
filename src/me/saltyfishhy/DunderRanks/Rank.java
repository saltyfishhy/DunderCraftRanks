package me.saltyfishhy.DunderRanks;

import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Objects;

public enum Rank {


    REGIONAL_MANAGER(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("ranks.regional_manager"))),
    HR(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("ranks.hr"))),
    SALES(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("ranks.sales"))),
    QUALITY_ASSURANCE(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("ranks.quality_assurance"))),
    RECEPTIONIST(ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("ranks.receptionist"))),
    NONE("");

    private final String prefix;
    //Map<Player, Rank> ranks = new HashMap<>();

    Rank(String prefix) {
        this.prefix = prefix;
    }

    public static void setRank(Player p, String rank) {
        String uuid = p.getUniqueId().toString();
        String rank1 = rank.toUpperCase();
        Main.data.getConfig().set(uuid + ".rank", rank1);
        Main.data.saveConfig();
    }
    public static void setRank(OfflinePlayer p, String rank) {
        String uuid = p.getUniqueId().toString();
        String rank1 = rank.toUpperCase();
        Main.data.getConfig().set(uuid + ".rank", rank1);
        Main.data.saveConfig();
    }

    public static String getRank(Player p) {
        String uuid = p.getUniqueId().toString();
        return Main.data.getConfig().getString(uuid + ".rank");
        //String rankString = Main.getInstance().getConfig().getString("players.name." + uuid + ".rank");
    }

    public static String getRank(OfflinePlayer p) {
        String uuid = p.getUniqueId().toString();
        return Main.data.getConfig().getString(uuid + ".rank");
        //String rankString = Main.getInstance().getConfig().getString("players.name." + uuid + ".rank");
    }

    public static void loadRank(Player p) {
        String uuid = p.getUniqueId().toString();
        String rankString = Main.data.getConfig().getString(uuid + ".rank");
        Rank rank = (rankString == null) ? Rank.NONE : Rank.valueOf(rankString);
        String playerName = (ChatColor.YELLOW + p.getName());
        p.setDisplayName(rank.getPrefix() + " " + playerName);
        p.setPlayerListName(rank.getPrefix() + " " + playerName);
        //ranks.put(p, rank);
    }

    public String getPrefix() {
        return prefix;
    }

    public static boolean hasRank(Player p, Rank r) {
        Rank rank = Rank.valueOf(getRank(p));
        return (rank.compareTo(r) <= 0);
    }

    public static boolean hasRank(OfflinePlayer p, Rank r) {
        Rank rank = Rank.valueOf(getRank(p));
        return (rank.compareTo(r) <= 0);
    }

}
