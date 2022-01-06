package ch.tom.tcodes.rulesverify.event;

import ch.tom.tcodes.rulesverify.RulesVerify;
import ch.tom.tcodes.rulesverify.utils.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener {

    RulesVerify plugin = RulesVerify.getInstance();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (plugin.getPlayerService().get(player.getUniqueId().toString()).isVerified() == false) {
            Inventory inventory = Bukkit.createInventory(null, 9*3, "§6RulesVerify §8| §7T-Codes");
            for (int i = 0; i < 27; i++) {
                inventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
            }

            inventory.setItem(10, new ItemCreator(Material.WRITTEN_BOOK, 1).setDisplayName("§aAkzeptierst du die Regel?").create());

            inventory.setItem(14, new ItemCreator(Material.GREEN_WOOL, 1).setDisplayName("§aJA").create());
            inventory.setItem(15, new ItemCreator(Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1).create());
            inventory.setItem(16, new ItemCreator(Material.RED_WOOL, 1).setDisplayName("§cNEIN").create());
            player.openInventory(inventory);
        }
    }
}
