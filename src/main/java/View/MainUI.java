package View;

import Home.Home;
import javax.swing.*;
import java.awt.*;
import main.InventoryMain;
import main.PatientVisitMain;
import main.RevenueMain;

public class MainUI extends JFrame {
    private JButton InventoryButton;
    private JButton PatientButton;
    private JButton RevenueButton;
    private JButton goBackButton;
    private JTabbedPane tabbedPane;

    public MainUI() {
        setTitle("Monthly Report Generator");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Apply Blue Theme
        UIManager.put("Button.background", new Color(30, 144, 255)); // Dodger Blue
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("TabbedPane.background", new Color(200, 230, 255)); // Light blue
        UIManager.put("Panel.background", new Color(240, 248, 255)); // Alice Blue

        // Initialize buttons with tooltips
        InventoryButton = new JButton("Inventory Report");
        InventoryButton.setToolTipText("Manage and track inventory details.");

        PatientButton = new JButton("Patient Report");
        PatientButton.setToolTipText("View and manage patient visit records.");

        RevenueButton = new JButton("Revenue Report");
        RevenueButton.setToolTipText("Generate and analyze monthly revenue reports.");

        goBackButton = new JButton("Go Back");
        goBackButton.setToolTipText("Return to the main menu.");
        goBackButton.setBackground(new Color(255, 69, 0)); // Red-Orange
        goBackButton.setForeground(Color.WHITE); // White text

        // Create a tabbed pane
        tabbedPane = new JTabbedPane();

        // Button Panel with Title
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(173, 216, 230)); // Light blue background
        JLabel titleLabel = new JLabel("Select a Report:", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        buttonPanel.add(titleLabel);
        buttonPanel.add(InventoryButton);
        buttonPanel.add(PatientButton);
        buttonPanel.add(RevenueButton);
        buttonPanel.add(goBackButton);

        // Action Listeners
        InventoryButton.addActionListener(e -> showInventoryTab());
        PatientButton.addActionListener(e -> showPatientVisitTab());
        RevenueButton.addActionListener(e -> showRevenueTab());
        goBackButton.addActionListener(e -> goBackToHome());

        // Add components to the frame
        add(buttonPanel, BorderLayout.WEST);
        add(tabbedPane, BorderLayout.CENTER);
    }

    private void showInventoryTab() {
        int index = tabbedPane.indexOfTab("Inventory");
        if (index == -1) {
            InventoryMain inventoryMain = new InventoryMain();
            JPanel inventoryPanel = (JPanel) inventoryMain.getContentPane();
            tabbedPane.addTab("Inventory", inventoryPanel);
            index = tabbedPane.getTabCount() - 1;
        }
        tabbedPane.setSelectedIndex(index);
    }

    private void showRevenueTab() {
        int index = tabbedPane.indexOfTab("Revenue");
        if (index == -1) {
            RevenueMain revenueMain = new RevenueMain();
            JPanel revenuePanel = (JPanel) revenueMain.getContentPane();
            tabbedPane.addTab("Revenue", revenuePanel);
            index = tabbedPane.getTabCount() - 1;
        }
        tabbedPane.setSelectedIndex(index);
    }

    private void showPatientVisitTab() {
        int index = tabbedPane.indexOfTab("Patient");
        if (index == -1) {
            PatientVisitMain patientVisitMain = new PatientVisitMain();
            JPanel patientPanel = (JPanel) patientVisitMain.getContentPane();
            tabbedPane.addTab("Patient", patientPanel);
            index = tabbedPane.getTabCount() - 1;
        }
        tabbedPane.setSelectedIndex(index);
    }

    private void goBackToHome() {
        this.dispose(); // Close the current window
        Home home = new Home(); // Create an instance of Home
        home.setVisible(true); // Show Home window
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainUI mainui = new MainUI();
            mainui.setVisible(true);
        });
    }
}
