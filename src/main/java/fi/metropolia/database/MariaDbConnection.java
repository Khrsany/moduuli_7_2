package fi.metropolia.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MariaDbConnection {

    private static final String URL = "jdbc:mariadb://localhost:3306/currencydb";
    private static final String USER = "root";
    private static final String PASSWORD = "Abbuusi";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
