package Controller;
import Model.*;
import View.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class PatientController {
    private PatientView view;
    private PatientDAO dao;

    public PatientController(PatientView view, PatientDAO dao) {
        this.view = view;
        this.dao = dao;

        // Add Patient
        view.addButton.addActionListener(e -> {
            try {
                dao.addPatient(new Patient(0,
                        view.nameField.getText(),
                        Integer.parseInt(view.ageField.getText()),
                        Integer.parseInt(view.genderField.getText()),  // Added gender handling
                        view.contactField.getText(),
                        view.addressField.getText(),
                        view.visitDateField.getText()
                ));
                JOptionPane.showMessageDialog(view, "Patient added successfully!");
                loadPatientData();  // Refresh table after adding
                resetFormFields();  // Reset form fields after adding
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(view, "Error adding patient.");
            }
        });

        // Update Patient
        view.updateButton.addActionListener(e -> {
            int selectedRow = view.patientTable.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) view.patientTable.getValueAt(selectedRow, 0);

                // Ensure all fields are filled
                if (view.nameField.getText().isEmpty() ||
                        view.ageField.getText().isEmpty() ||
                        view.genderField.getText().isEmpty() ||
                        view.contactField.getText().isEmpty() ||
                        view.addressField.getText().isEmpty() ||
                        view.visitDateField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Please fill in all fields to update the patient.");
                    return;
                }

                try {
                    // Get the updated data from the fields
                    Patient updatedPatient = new Patient(
                            id,
                            view.nameField.getText(),
                            Integer.parseInt(view.ageField.getText()),
                            Integer.parseInt(view.genderField.getText()),
                            view.contactField.getText(),
                            view.addressField.getText(),
                            view.visitDateField.getText()
                    );

                    dao.updatePatient(updatedPatient);  // Update patient in the database
                    JOptionPane.showMessageDialog(view, "Patient updated successfully!");
                    loadPatientData();  // Refresh table after updating
                    resetFormFields();  // Reset form fields after updating
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Error updating patient.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Please enter valid data (e.g., Age and Gender should be numbers).");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please select a patient to update.");
            }
        });

        // Delete Patient
        view.deleteButton.addActionListener(e -> {
            int selectedRow = view.patientTable.getSelectedRow();
            if (selectedRow >= 0) {
                int id = (int) view.patientTable.getValueAt(selectedRow, 0);
                try {
                    dao.deletePatient(id);
                    JOptionPane.showMessageDialog(view, "Patient deleted successfully!");
                    loadPatientData();  // Refresh table after deleting
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Error deleting patient.");
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please select a patient to delete.");
            }
        });

        // Load data when application starts
        try {
            loadPatientData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Populate the fields when a row is selected
        view.patientTable.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = view.patientTable.getSelectedRow();
            if (selectedRow >= 0) {
                view.nameField.setText((String) view.patientTable.getValueAt(selectedRow, 1));
                view.ageField.setText(String.valueOf(view.patientTable.getValueAt(selectedRow, 2)));
                view.genderField.setText(String.valueOf(view.patientTable.getValueAt(selectedRow, 3)));
                view.contactField.setText((String) view.patientTable.getValueAt(selectedRow, 4));
                view.addressField.setText((String) view.patientTable.getValueAt(selectedRow, 5));
                view.visitDateField.setText((String) view.patientTable.getValueAt(selectedRow, 6));
            }
        });
    }

    private void loadPatientData() throws SQLException {
        List<Patient> patients = dao.getAllPatients();
        String[] columns = {"ID", "Name", "Age", "Gender", "Contact", "Address", "Visit Date"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Patient p : patients) {
            tableModel.addRow(new Object[]{
                    p.getId(),
                    p.getName(),
                    p.getAge(),
                    p.getGender() == 1 ? "Male" : "Female",
                    p.getContact(),
                    p.getAddress(),
                    p.getVisitDate()
            });
        }

        view.patientTable.setModel(tableModel);
    }

    // Method to reset the form fields
    private void resetFormFields() {
        view.nameField.setText("");
        view.ageField.setText("");
        view.genderField.setText("");
        view.contactField.setText("");
        view.addressField.setText("");
        view.visitDateField.setText("");
    }
}
