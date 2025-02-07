package main;

import javax.swing.*;
import View.stockreport;
import Controller.StockReportController;
import Model.ReportModel;

public class InventoryMain extends JFrame {
    public InventoryMain() {
        // Initialize components
        stockreport view = new stockreport();
        ReportModel model = new ReportModel();
        StockReportController controller = new StockReportController(view, model);

        // Set up the JFrame
        setTitle("Stock Report Generator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(view.getMainPanel());
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InventoryMain().setVisible(true);
            }
        });
    }
}