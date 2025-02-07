package main;

import Controller.RevenueReportController;
import Model.RevenueReportModel;
import View.RevenueReport;
import javax.swing.*;

public class RevenueMain extends JFrame {
    public RevenueMain() {

        RevenueReport view = new RevenueReport();
        RevenueReportModel model = new RevenueReportModel();
        new RevenueReportController(view, model);


        setTitle("Revenue Report");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(view.getMainPanel());
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new RevenueMain().setVisible(true);
        });
    }
}