package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection
    getConnection() {

        Connection con = null;

        try {

            Class.forName(
            "oracle.jdbc.driver.OracleDriver");

            con =
            DriverManager.getConnection(
            System.getenv().getOrDefault("BANK_DB_URL", "jdbc:oracle:thin:@//localhost:1521/XE"),
            System.getenv("BANK_DB_USER"),
            System.getenv("BANK_DB_PASSWORD"));

        } catch (Exception e) {

            System.out.println(
            "Connection error.");
        }

        return con;
    }
}