package ch.tom.tcodes.rulesverify.player;

import ch.tom.tcodes.rulesverify.RulesVerify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PlayerRepositoryImp implements PlayerRepository{

    private RulesVerify plugin = RulesVerify.getInstance();

    @Override
    public void save(Player player) {
        try {
            Connection con = plugin.getMySQL().getConnection();
            String sql = "INSERT INTO `player`(name,uuid,verified) VALUES(?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, player.getName());
            preparedStatement.setString(2, player.getUuid());
            preparedStatement.setBoolean(3, false);

            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Player player) {
        try {
            Connection con = plugin.getMySQL().getConnection();
            String sql = "UPDATE `player` SET verified=? WHERE uuid=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, player.getUuid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Player player) {
        try {
            Connection con = plugin.getMySQL().getConnection();
            String sql = "DELETE from `player` WHERE uuid=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, player.getUuid());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Player get(String uuid) {
        Player player = new Player();
        try {
            Connection con = plugin.getMySQL().getConnection();
            String sql = "SELECT * FROM `player` WHERE uuid=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, uuid);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                player.setName(rs.getString("name"));
                player.setUuid(rs.getString("uuid"));
                player.setVerified(rs.getBoolean("verified"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public boolean exists(String uuid) {
        for (Player p : this.list()) {
            if (p.getUuid().equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Player> list() {
        List<Player> list = new ArrayList<Player>();

        try {
            Connection con = plugin.getMySQL().getConnection();
            String sql = "SELECT * FROM `player`";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Player player = new Player();
                player.setName(rs.getString("name"));
                player.setUuid(rs.getString("uuid"));
                player.setVerified(rs.getBoolean("verified"));
                list.add(player);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
