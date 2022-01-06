package ch.tom.tcodes.rulesverify.mysql;

import ch.tom.tcodes.rulesverify.RulesVerify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQL {
    public Connection connection;
    private RulesVerify plugin = RulesVerify.getInstance();

    public void startConnection() {
        Properties properties = new Properties();
        try {
            properties.put("user", "root");
            properties.put("password", "fHwGK7bl");
            properties.put("autoReconnect", "true");
            connection = DriverManager.getConnection("jdbc:mysql://45.139.112.79:3306/main", properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void stopConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            this.startConnection();
            return connection;
        }
    }
}
