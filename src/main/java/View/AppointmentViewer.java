package View;

import Home.Home;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AppointmentViewer extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public AppointmentViewer(int patientId) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/medicare_plus?useSSL=false";
        String user = "root";
        String password = "";

        // Query to fetch appointment data
        String query = "SELECT patient_id, doctor_id, appointment_date, appointment_time, fees FROM appointment WHERE patient_id = ?";

        // Create a table model to hold the data
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Patient ID");
        tableModel.addColumn("Doctor ID");
        tableModel.addColumn("Appointment Date");
        tableModel.addColumn("Appointment Time");
        tableModel.addColumn("Fees");

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Set the patient_id parameter dynamically
            preparedStatement.setInt(1, patientId);

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set and add rows to the table model
            while (resultSet.next()) {
                int patientIdFromDB = resultSet.getInt("patient_id");
                int doctorId = resultSet.getInt("doctor_id");
                String appointmentDate = resultSet.getString("appointment_date");
                String appointmentTime = resultSet.getString("appointment_time");
                double fees = resultSet.getDouble("fees");

                // Add a row to the table model
                tableModel.addRow(new Object[]{patientIdFromDB, doctorId, appointmentDate, appointmentTime, fees});
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Set up JFrame properties
        setTitle("Appointment Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Create a JTable with the table model
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Create a "Back to Home" button
        JButton backToHomeButton = new JButton("Back to Home");
        backToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                Home.main(new String[]{}); // Open Home window
            }
        });

        // Add the button to the bottom of the frame
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backToHomeButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public AppointmentViewer() {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AppointmentViewer(1).setVisible(true); // Example: Display appointments for patient ID 1
        });
    }
}
