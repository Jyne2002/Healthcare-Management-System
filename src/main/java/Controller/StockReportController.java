package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import Model.ReportModel;
import View.stockreport;

public class StockReportController {
    private stockreport view;
    private ReportModel model;

    public StockReportController(stockreport view, ReportModel model) {
        this.view = view;
        this.model = model;

        //control the button
        this.view.addGenerateButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
    }

    private void generateReport() {
        String startDate = view.getStartDate();
        String endDate = view.getEndDate();

        // Validation
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false); // Enforce strict date parsing

            sdf.parse(startDate);
            sdf.parse(endDate);

            // Fetching from the model
            List<Object[]> reportData = model.getReportData(startDate, endDate);

            // validation
            if (reportData.isEmpty()) {
                view.showMessage("No records found for the given date range.");
                return;
            }

            // updating table outputs
            DefaultTableModel tableModel = new DefaultTableModel(
                    reportData.toArray(new Object[0][]),
                    new String[]{"Name", "Quantity", "Price", "Expiration Date"}
            );

            view.setTableData(tableModel);

        } catch (Exception ex) {
            view.showMessage("Invalid date format. Please use yyyy-MM-dd.");
        }
    }
}
