package View;
import Home.Home;

import javax.swing.*;
import java.awt.*;

public class PatientView extends JFrame {
    public JTextField nameField, ageField, genderField, contactField, emailField, visitDateField;
    public JButton addButton, updateButton, deleteButton,backButton;
    public JTable patientTable;

    public PatientView() {
        setTitle("Patient Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender (1=Male, 0=Female):"));
        genderField = new JTextField();
        panel.add(genderField);

        panel.add(new JLabel("Contact:"));
        contactField = new JTextField();
        panel.add(contactField);

        panel.add(new JLabel("Email:"));
        emailField = new JTextField();
        panel.add(emailField);

        panel.add(new JLabel("Visit Date (YYYY-MM-DD):"));
        visitDateField = new JTextField();
        panel.add(visitDateField);

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        backButton = new JButton("Back");
        backButton.addActionListener(e -> backButton());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add( backButton);

        patientTable = new JTable();
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(patientTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    public void backButton() {
        this.dispose(); // Close the current window
        Home home = new Home(); // Create an instance of Home
        home.setVisible(true); // Show Home window
    }
}
