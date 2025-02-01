package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Database.DatabaseConnection.*;

public class ReportModel {

    // Method to fetch report data as a list of Object[] for JTable
    public List<Object[]> getReportData(String startDate, String endDate) {
        List<Object[]> data = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Establish database connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL query to fetch data within date range
            String query = "SELECT name, quantity, price, expDate FROM pharmacy_items WHERE created_at BETWEEN ? AND ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);

            rs = stmt.executeQuery();

            // Process the result set and store in list
            while (rs.next()) {
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String expDate = rs.getString("expDate");

                data.add(new Object[]{name, quantity, price, expDate});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }
}
