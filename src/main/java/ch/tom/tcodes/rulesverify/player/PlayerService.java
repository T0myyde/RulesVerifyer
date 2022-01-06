package ch.tom.tcodes.rulesverify.player;

import org.bukkit.Location;

import java.util.List;

public class PlayerService {
    private PlayerRepositoryImp repository = new PlayerRepositoryImp();
    public Player add (Player player) {
        this.repository.save(player);
        return player;
    }

    public Player get(String uuid) {
        Player player = this.repository.get(uuid);
        return player;
    }

    public void update(Player player) {
        this.repository.update(player);
    }

    public void delete(Player player) {
        this.repository.delete(player);
    }

    public boolean exists(String uuid) {
        return this.repository.exists(uuid);
    }

    public List<Player> getList() {
        return this.repository.list();
    }
}
