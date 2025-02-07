package Controller;
// import
import Model.PharmacyItem;
import Database.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PharmacyController {

    public void addItem(PharmacyItem item) {
        String query = "INSERT INTO pharmacy_items (id, name, quantity, price, expDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, item.getId());
            stmt.setString(2, item.getName());
            stmt.setInt(3, item.getQuantity());
            stmt.setDouble(4, item.getPrice());
            stmt.setString(5, item.getExpDate());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateItem(int id, PharmacyItem updatedItem) {
        String query = "UPDATE pharmacy_items SET name = ?, quantity = ?, price = ?, expDate = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, updatedItem.getName());
            stmt.setInt(2, updatedItem.getQuantity());
            stmt.setDouble(3, updatedItem.getPrice());
            stmt.setString(4, updatedItem.getExpDate());
            stmt.setInt(5, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(int id) {
        String query = "DELETE FROM pharmacy_items WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PharmacyItem> getInventory() {
        List<PharmacyItem> inventory = new ArrayList<>();
        String query = "SELECT * FROM pharmacy_items";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                PharmacyItem item = new PharmacyItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("expDate")
                );
                inventory.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventory;
    }


    public List<PharmacyItem> getLowStockItems() {
        List<PharmacyItem> lowStockItems = new ArrayList<>();
        String query = "SELECT * FROM pharmacy_items WHERE quantity < 5";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                PharmacyItem item = new PharmacyItem(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"),
                        rs.getString("expDate")
                );
                lowStockItems.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lowStockItems;
}
}
