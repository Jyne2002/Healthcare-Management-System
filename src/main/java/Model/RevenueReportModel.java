package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.DatabaseConnection;

public class RevenueReportModel {

    public String calculateMonthlyRevenue(int month, int year) {
        double totalFees = 0, totalExpenses = 0, revenue = 0;
        StringBuilder report = new StringBuilder();

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Get total income from appointments
            String feesQuery = "SELECT SUM(fees) FROM appointment WHERE MONTH(appointment_date) = ? AND YEAR(appointment_date) = ?";
            try (PreparedStatement stmt = conn.prepareStatement(feesQuery)) {
                stmt.setInt(1, month);
                stmt.setInt(2, year);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    totalFees = rs.getDouble(1);
                }
            }

            // Get total outcome from pharmacy_items
            String expensesQuery = "SELECT SUM(price) FROM pharmacy_items WHERE MONTH(created_at) = ? AND YEAR(created_at) = ?";
            try (PreparedStatement stmt = conn.prepareStatement(expensesQuery)) {
                stmt.setInt(1, month);
                stmt.setInt(2, year);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    totalExpenses = rs.getDouble(1);
                }
            }

            // Calculate revenue
            revenue = totalFees - totalExpenses;

            // Construct the detailed report
            report.append("Total Income (Appointments): Rs :").append(totalFees).append("\n");
            report.append("Total Outcome (Pharmacy Items): Rs :").append(totalExpenses).append("\n");
            report.append("Revenue: Rs : ").append(revenue).append("\n");

            // Optionally, add some rate calculations
            double incomeRate = (totalFees > 0) ? (revenue / totalFees) * 100 : 0;
            double expenseRate = (totalExpenses > 0) ? (totalExpenses / (totalFees + totalExpenses)) * 100 : 0;

            report.append("Income Rate: ").append(String.format("%.2f", incomeRate)).append("%\n");
            report.append("Expense Rate: ").append(String.format("%.2f", expenseRate)).append("%\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report.toString();
    }
}
