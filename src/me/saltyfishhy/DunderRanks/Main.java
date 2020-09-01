package me.saltyfishhy.DunderRanks;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static FileManager data;
    public static Main instance;
    public Listener listener = new InvClick();
    public Listener listener1 = new OnJoin();
    public Listener listener2 = new OnChat();

    public void onEnable() {
        this.data = new FileManager(this);
        data.reloadConfig();
        instance = this;
        loadConfig();
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(listener, this);
        pm.registerEvents(listener1, this);
        pm.registerEvents(listener2, this);
        getLogger().info("DunderCraft Ranks Enabled");
        getCommand("rank").setExecutor(new Commands());
    }

    public void onDisable() {
        getLogger().info("DunderCraft Ranks Disabled");
    }

    public static Main getInstance() {
        return instance;
    }

    public void loadConfig(){
        //tells the config file to copy the defaults that were created with the file initially
        getConfig().options().copyDefaults(true);
        //saves the config
        saveConfig();
    }

}
