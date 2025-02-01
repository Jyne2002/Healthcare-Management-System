package main;

import javax.swing.*;
import View.PatientVisitReport;

public class PatientVisitMain extends JFrame {  // Extend JFrame to make it a standalone window
    public PatientVisitMain() {
        // Initialize the view
        PatientVisitReport view = new PatientVisitReport();

        // Set up the JFrame
        setTitle("Patient Visit Report");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Use DISPOSE_ON_CLOSE to avoid closing the entire app
        setContentPane(view.getMainPanel());
        pack();
        setLocationRelativeTo(null);  // Center the window on the screen
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater to ensure thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PatientVisitMain().setVisible(true);  // Create and show the PatientVisitMain window
            }
        });
    }
}