package main;

import javax.swing.*;
import View.PatientVisitReport;

public class PatientVisitMain extends JFrame {
    public PatientVisitMain() {

        PatientVisitReport view = new PatientVisitReport();


        setTitle("Patient Visit Report");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(view.getMainPanel());
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PatientVisitMain().setVisible(true);
            }
        });
    }
}