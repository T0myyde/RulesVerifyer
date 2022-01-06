package ch.tom.tcodes.rulesverify;

import ch.tom.tcodes.rulesverify.event.PlayerInteractEvent;
import ch.tom.tcodes.rulesverify.event.PlayerJoin;
import ch.tom.tcodes.rulesverify.event.PlayerLogin;
import ch.tom.tcodes.rulesverify.mysql.MySQL;
import ch.tom.tcodes.rulesverify.player.PlayerService;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class RulesVerify extends JavaPlugin {

    private static RulesVerify instance;
    private MySQL mySQL;
    private PlayerService playerService;
    @Override
    public void onEnable() {
        instance = this;
        mySQL = new MySQL();
        playerService = new PlayerService();
        mySQL.startConnection();
        saveDefaultConfig();
        onInit(Bukkit.getPluginManager());
    }

    @Override
    public void onDisable() {
        mySQL.stopConnection();
    }

    public static RulesVerify getInstance() {
        return instance;
    }

    private void onInit(PluginManager pluginManager) {
        pluginManager.registerEvents(new PlayerJoin(), this);
        pluginManager.registerEvents(new PlayerLogin(), this);
        pluginManager.registerEvents(new PlayerInteractEvent(), this);
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    public PlayerService getPlayerService() {
        return playerService;
    }
}
