package Controller;

import Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LowStockNotifier {
    public static void checkLowStock() {
        String query = "SELECT name, quantity FROM pharmacy_items WHERE quantity < 5";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            boolean lowStockFound = false;

            while (rs.next()) {
                lowStockFound = true;
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                System.out.println("⚠ WARNING: Low stock for " + name + "! Only " + quantity + " left.");
            }

            if (!lowStockFound) {
                System.out.println("✅ All stock levels are sufficient.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}