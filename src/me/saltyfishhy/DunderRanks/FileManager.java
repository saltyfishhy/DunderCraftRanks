package me.saltyfishhy.DunderRanks;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class FileManager {

    // Code reference supplied by CodedRed
    // @ https://github.com/CodedRedGIT/Spigot-Development-1.15/tree/master/Episode12-%20Custom%20Config%20Files

    private Main plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;


    public FileManager(Main plugin) {
        this.plugin = plugin;
        // saves/initializes the config
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if (this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "players.yml");

        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource("players.yml");
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults(defaultConfig);
        }
    }

    public FileConfiguration getConfig() {
        if (this.dataConfig == null)
            reloadConfig();

        return this.dataConfig;
    }

    public void saveConfig() {
        if (this.dataConfig == null || this.configFile == null)
            return;

        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Could not save config to " + this.configFile, e);
        }
    }

    public void saveDefaultConfig() {
        if (this.configFile == null)
            this.configFile = new File(this.plugin.getDataFolder(), "players.yml");

        if (!this.configFile.exists()) {
            this.plugin.saveResource("players.yml", false);
        }
    }


}
