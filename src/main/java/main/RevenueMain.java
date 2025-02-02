package main;

import Controller.RevenueReportController;
import Model.RevenueReportModel;
import View.RevenueReport;
import javax.swing.*;

public class RevenueMain extends JFrame {  // Extend JFrame to make it a standalone window
    public RevenueMain() {
        // Initialize components
        RevenueReport view = new RevenueReport();
        RevenueReportModel model = new RevenueReportModel();
        new RevenueReportController(view, model);

        // Set up the JFrame
        setTitle("Revenue Report");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Use DISPOSE_ON_CLOSE to avoid closing the entire app
        setContentPane(view.getMainPanel());
        pack();
        setLocationRelativeTo(null);  // Center the window on the screen
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            new RevenueMain().setVisible(true);  // Create and show the RevenueMain window
        });
    }
}