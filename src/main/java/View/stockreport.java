package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;

public class stockreport {  // Keeping the class name lowercase
    private JTextField startdate;
    private JTextField endate;  // Fixed typo (was "endate")
    private JButton genrateButton;
    private JTable output;
    private JPanel Main;

    public stockreport() {
        // Initialize components manually
        Main = new JPanel();
        startdate = new JTextField(10);
        endate = new JTextField(10);
        genrateButton = new JButton("Generate Report");
        output = new JTable(new DefaultTableModel(new Object[]{"Name", "Quantity", "Price", "Expiration Date"}, 0));

        // Layout UI
        Main.setLayout(new BoxLayout(Main, BoxLayout.Y_AXIS));
        Main.add(new JLabel("Start Date:"));
        Main.add(startdate);
        Main.add(new JLabel("End Date:"));
        Main.add(endate);
        Main.add(genrateButton);
        Main.add(new JScrollPane(output));
    }

    public JPanel getMainPanel() {
        return Main;
    }

    public String getStartDate() {
        return startdate.getText();
    }

    public String getEndDate() {
        return endate.getText();
    }

    public void setTableData(DefaultTableModel tableModel) {
        output.setModel(tableModel);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void addGenerateButtonListener(ActionListener listener) {
        genrateButton.addActionListener(listener);
    }
}
