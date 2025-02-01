package View;

import Database.DatabaseConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AppointmentBookingForm extends JFrame {
    private JTextField tfFees, tfDate, tfTime;
    private JButton btnBookAppointment;
    private JComboBox<String> cbDoctorName, cbPatientName;
    private JPanel formPanel; // Panel for the form
    private JProgressBar progressBar;

    public AppointmentBookingForm() {
        setTitle("Book Appointment");
        setLayout(new BorderLayout());

        // Create a panel for the form to be centered
        formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));  // Use BoxLayout for vertical alignment
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 123, 255), 2, true));  // Add border for the "box" effect
        formPanel.setBackground(new Color(255, 255, 255));  // Set a white background

        // Set the form components
        addFormComponents();

        // Create a container panel for centering
        JPanel containerPanel = new JPanel(new GridBagLayout());
        containerPanel.setBackground(new Color(240, 240, 240));  // Light gray background for the window
        containerPanel.add(formPanel);
//appointment
        //appointments
        // Set JFrame properties
        add(containerPanel, BorderLayout.CENTER);
        setSize(600, 600);  // Increase size to make the form bigger
        setLocationRelativeTo(null);  // Center the window on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Fetch doctor names and patient names from the database and populate the JComboBox
        loadDoctorNames();
        loadPatientNames();
    }

    // Add form components with labels and inputs
    private void addFormComponents() {
        // Create labels and input fields
        JLabel lblPatientName = createLabel("Patient Name:");
        cbPatientName = new JComboBox<>();
        cbPatientName.setFont(new Font("Arial", Font.PLAIN, 16));
        cbPatientName.setPreferredSize(new Dimension(250, 30));  // Increase width

        JLabel lblDoctorName = createLabel("Doctor Name:");
        cbDoctorName = new JComboBox<>();
        cbDoctorName.setFont(new Font("Arial", Font.PLAIN, 16));
        cbDoctorName.setPreferredSize(new Dimension(250, 30));  // Increase width

        JLabel lblFees = createLabel("Fees:");
        tfFees = createTextField();

        JLabel lblDate = createLabel("Appointment Date:");
        tfDate = createTextField();

        JLabel lblTime = createLabel("Appointment Time:");
        tfTime = createTextField();

        // Book Appointment button with icon
        btnBookAppointment = createButton("Book Appointment", "book_icon.png");

        // Progress bar for loading data
        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);

        // Add components to formPanel
        formPanel.add(Box.createVerticalStrut(30));  // Add vertical space
        formPanel.add(lblPatientName);
        formPanel.add(cbPatientName);
        formPanel.add(Box.createVerticalStrut(15));

        formPanel.add(lblDoctorName);
        formPanel.add(cbDoctorName);
        formPanel.add(Box.createVerticalStrut(15));

        formPanel.add(lblFees);
        formPanel.add(tfFees);
        formPanel.add(Box.createVerticalStrut(15));

        formPanel.add(lblDate);
        formPanel.add(tfDate);
        formPanel.add(Box.createVerticalStrut(15));

        formPanel.add(lblTime);
        formPanel.add(tfTime);
        formPanel.add(Box.createVerticalStrut(30));

        formPanel.add(btnBookAppointment);
        formPanel.add(Box.createVerticalStrut(20));

        formPanel.add(progressBar);
    }

    // Method to create labels with custom styles
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 16));  // Increase font size for labels
        label.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the label horizontally
        return label;
    }

    // Method to create text fields with custom styles
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setPreferredSize(new Dimension(250, 30));  // Increase width for text fields
        textField.setToolTipText("Enter details here");
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the text field
        return textField;
    }

    // Method to create buttons with custom icon and styling
    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));  // Increase font size for buttons
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));  // Adjust padding
        button.setIcon(new ImageIcon(iconPath));  // Set the icon for the button
        button.setFocusPainted(false);  // Remove focus border
        button.setAlignmentX(Component.CENTER_ALIGNMENT);  // Center the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookAppointment();
            }
        });
        return button;
    }

    // Load doctor names from the database and populate the JComboBox
    private void loadDoctorNames() {
        progressBar.setVisible(true);
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id, name FROM doctors";  // Updated query
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String doctorName = rs.getString("name");
                cbDoctorName.addItem(doctorName);  // Add doctor name to the combo box
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching doctor names: " + ex.getMessage());
        } finally {
            progressBar.setVisible(false);
        }
    }


    // Load patient names from the database and populate the JComboBox
    private void loadPatientNames() {
        progressBar.setVisible(true);
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id, Name FROM patient_records";  // Updated query
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String patientName = rs.getString("Name");
                cbPatientName.addItem(patientName);  // Add patient name to the combo box
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching patient names: " + ex.getMessage());
        } finally {
            progressBar.setVisible(false);
        }
    }


    // Book an appointment using selected doctor and patient and other form fields
    private void bookAppointment() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO appointment (patient_id, doctor_id, appointment_date, appointment_time, fees) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);

            // Get values from the form fields
            String patientName = (String) cbPatientName.getSelectedItem();
            String doctorName = (String) cbDoctorName.getSelectedItem();
            double fees = Double.parseDouble(tfFees.getText());

            // Convert the text fields for Date and Time into Date and Time objects
            java.sql.Date date = java.sql.Date.valueOf(tfDate.getText());  // Use java.sql.Date
            java.sql.Time time = java.sql.Time.valueOf(tfTime.getText() + ":00");  // Use java.sql.Time and append ":00" for seconds

            // Get the patient_id based on the patient name
            int patientId = getPatientIdByName(patientName);

            // Get the doctor_id based on the selected doctor name
            int doctorId = getDoctorIdByName(doctorName);

            // Check if patient_id and doctor_id are valid
            if (patientId == -1 || doctorId == -1) {
                JOptionPane.showMessageDialog(this, "Invalid patient or doctor selected.");
                return;
            }

            // Set the values in the prepared statement
            statement.setInt(1, patientId);
            statement.setInt(2, doctorId);
            statement.setDate(3, date);
            statement.setTime(4, time);
            statement.setDouble(5, fees);

            int result = statement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Appointment booked successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Error booking appointment.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Get the patient_id based on the patient name
    private int getPatientIdByName(String patientName) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id FROM patient_records WHERE Name = ?";  // Updated query
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, patientName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching patient ID: " + ex.getMessage());
        }
        return -1;  // Return -1 if patient is not found
    }

    private int getDoctorIdByName(String doctorName) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT id FROM doctors WHERE name = ?";  // Updated query
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, doctorName);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching doctor ID: " + ex.getMessage());
        }
        return -1;  // Return -1 if doctor is not found
    }

    public static void main(String[] args) {
        new AppointmentBookingForm();
    }
}
