package main;

import javax.swing.*;
import View.stockreport;
import Controller.StockReportController;
import Model.ReportModel;

public class InventoryMain extends JFrame {  // Extend JFrame to make it a standalone window
    public InventoryMain() {
        // Initialize components
        stockreport view = new stockreport();
        ReportModel model = new ReportModel();
        StockReportController controller = new StockReportController(view, model);

        // Set up the JFrame
        setTitle("Stock Report Generator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Use DISPOSE_ON_CLOSE to avoid closing the entire app
        setContentPane(view.getMainPanel());
        pack();
        setLocationRelativeTo(null);  // Center the window on the screen
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InventoryMain().setVisible(true);  // Create and show the InventoryMain window
            }
        });
    }
}