package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static final String DB_URL = "jdbc:mysql://localhost:3306/medicare_plus";
    public static final String DB_USER = "root"; // Replace with your username
    public static final String DB_PASSWORD = ""; // Replace with your password

    // Method to get connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

