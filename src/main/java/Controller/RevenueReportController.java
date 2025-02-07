package Controller;

import Model.RevenueReportModel;
import View.RevenueReport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevenueReportController {
    private RevenueReport view;
    private RevenueReportModel model;

    public RevenueReportController(RevenueReport view, RevenueReportModel model) {
        this.view = view;
        this.model = model;

        //control button
        view.getGenerateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
    }

    private void generateReport() {
        int month = view.getDropDmonth().getSelectedIndex() + 1;  // Get month index (1-12)
        int year = Integer.parseInt((String) view.getDropDyear().getSelectedItem());

        // fetching from model
        String detailedReport = model.calculateMonthlyRevenue(month, year);
        view.getTextArea().setText(detailedReport);  // Display the detailed report in the JTextArea
    }
}
