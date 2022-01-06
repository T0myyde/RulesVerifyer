package ch.tom.tcodes.rulesverify.player;

import java.util.List;

public interface PlayerRepository {

    void save(Player player);
    void update(Player player);
    void delete(Player player);
    Player get(String uuid);
    boolean exists(String uuid);
    List<Player> list();
}
