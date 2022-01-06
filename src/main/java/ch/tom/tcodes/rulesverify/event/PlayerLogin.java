package ch.tom.tcodes.rulesverify.event;

import ch.tom.tcodes.rulesverify.RulesVerify;
import ch.tom.tcodes.rulesverify.player.PlayerAlreadyExists;
import ch.tom.tcodes.rulesverify.player.PlayerService;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener {


    RulesVerify plugin = RulesVerify.getInstance();

    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (!plugin.getPlayerService().exists(player.getUniqueId().toString())) {
            plugin.getPlayerService().add(new ch.tom.tcodes.rulesverify.player.Player(player.getName(), player.getUniqueId().toString(), false));
        }
    }
}
