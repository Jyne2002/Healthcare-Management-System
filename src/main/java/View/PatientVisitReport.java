package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;

public class PatientVisitReport {
    private JPanel Main;
    private JComboBox<String> monthDropdown;
    private JComboBox<Integer> yearDropdown;
    private JButton generateButton;
    private JTable reportTable;
    private JScrollPane scrollPane;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/medicare_plus";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public PatientVisitReport() {
        // Initialize table model explicitly
        DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Name", "Age", "Address", "Contact", "Date Registered"}, 0);
        reportTable = new JTable(tableModel);

        // Attach table to the scroll pane
        scrollPane.setViewportView(reportTable);

        // Populate year dropdown
        for (int year = 2025; year <= 2030; year++) {
            yearDropdown.addItem(year);
        }

        // Populate month dropdown
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        for (String month : months) {
            monthDropdown.addItem(month);
        }

        // Button listener
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear table
                tableModel.setRowCount(0);

                // Fetch selected month and year
                String selectedMonth = (String) monthDropdown.getSelectedItem();
                int selectedMonthIndex = monthDropdown.getSelectedIndex() + 1; // Convert to 1-based month index
                int selectedYear = (int) yearDropdown.getSelectedItem();

                // Fetch data from the database
                List<Object[]> patientData = fetchPatientDataFromDatabase(selectedMonthIndex, selectedYear);

                // Populate table with database data
                for (Object[] row : patientData) {
                    tableModel.addRow(row);
                }

                JOptionPane.showMessageDialog(null, "Report generated for " + selectedMonth + " " + selectedYear);
            }
        });
    }

    private List<Object[]> fetchPatientDataFromDatabase(int month, int year) {
        String query = "SELECT Name, Age, Address, Contact, DateAdded FROM patient_records WHERE MONTH(DateAdded) = ? AND YEAR(DateAdded) = ?";
        List<Object[]> patientDetails = new java.util.ArrayList<>();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, month);
            stmt.setInt(2, year);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] row = {
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Address"),
                        rs.getString("Contact"),
                        rs.getDate("DateAdded")
                };
                patientDetails.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patientDetails;
    }

    public JPanel getMainPanel() {
        return Main;
    }
}
