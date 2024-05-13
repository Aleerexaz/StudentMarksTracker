package org.example.login;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public Connection databaseLink;

    public Connection getDBConnection() {
        // Use a relative path to locate the database file
        String relativePath = "src/main/Database/mydb";
        String absolutePath = System.getProperty("user.dir") + "/" + relativePath;
        String url = "jdbc:sqlite:" + absolutePath;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Establish the database connection
            databaseLink = DriverManager.getConnection(url);
            System.out.println("Connected to SQLite");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }

}
