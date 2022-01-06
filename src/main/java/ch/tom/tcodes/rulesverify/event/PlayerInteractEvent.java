package ch.tom.tcodes.rulesverify.event;

import ch.tom.tcodes.rulesverify.RulesVerify;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class PlayerInteractEvent implements Listener {

    RulesVerify plugin = RulesVerify.getInstance();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase("§6RulesVerify §8| §7T-Codes")) {
            if (event.getCurrentItem().getType() == Material.GREEN_WOOL) {
                plugin.getPlayerService().get(player.getUniqueId().toString()).setVerified(true);
                System.out.println(plugin.getPlayerService().get(player.getUniqueId().toString()));
                plugin.getPlayerService().update(plugin.getPlayerService().get(player.getUniqueId().toString()));
                player.sendMessage("§aDu bist nun erfolgreich Verifiziert");
                player.closeInventory();
            }else if (event.getCurrentItem().getType() == Material.RED_WOOL) {
                player.kickPlayer("§cDu musst die Regeln Akzeptieren!");
            }


            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        if (!plugin.getPlayerService().get(player.getUniqueId().toString()).isVerified()) {
            if (event.getView().getTitle().equalsIgnoreCase("§6RulesVerify §8| §7T-Codes")) {
                player.kickPlayer("§cDu musst die Regeln Akzeptieren!");
            }
        }
    }
}
