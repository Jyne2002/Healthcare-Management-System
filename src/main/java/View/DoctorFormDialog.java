// DoctorFormDialog.java
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DoctorFormDialog extends JDialog {
    private JTextField idField;
    private JTextField nameField;
    private JTextField specializationField;
    private JTextField availabilityField;
    private JTextField doctorFeeField;
    private boolean isSubmitted;

    public DoctorFormDialog(Frame parent, String title, String[] initialData) {
        super(parent, title, true);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(new JLabel("Doc.ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Specialization:"));
        specializationField = new JTextField();
        add(specializationField);

        add(new JLabel("Availability:"));
        availabilityField = new JTextField();
        add(availabilityField);

        add(new JLabel("Doctor Fee:"));
        doctorFeeField = new JTextField();
        add(doctorFeeField);

        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Cancel");
        add(okButton);
        add(cancelButton);

        if (initialData != null) {
            idField.setText(initialData[0]);
            idField.setEditable(false); // ID is not editable during update
            nameField.setText(initialData[1]);
            specializationField.setText(initialData[2]);
            availabilityField.setText(initialData[3]);
            doctorFeeField.setText(initialData[4]);
        }

        okButton.addActionListener(e -> {
            if (validateFields()) {
                isSubmitted = true;
                setVisible(false);
            }
        });

        cancelButton.addActionListener(e -> {
            isSubmitted = false;
            setVisible(false);
        });

        setPreferredSize(new Dimension(400, 300));
        pack();
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public String[] getFormData() {
        return new String[]{
                idField.getText(),
                nameField.getText(),
                specializationField.getText(),
                availabilityField.getText(),
                doctorFeeField.getText()
        };
    }

    private boolean validateFields() {
        if (idField.getText().trim().isEmpty()) {
            showMessage("Doc.ID cannot be empty");
            return false;
        }
        try {
            Integer.parseInt(idField.getText().trim());
        } catch (NumberFormatException e) {
            showMessage("Doc.ID must be a valid number");
            return false;
        }

        if (nameField.getText().trim().isEmpty()) {
            showMessage("Name cannot be empty");
            return false;
        }

        if (specializationField.getText().trim().isEmpty()) {
            showMessage("Specialization cannot be empty");
            return false;
        }

        if (availabilityField.getText().trim().isEmpty()) {
            showMessage("Availability cannot be empty");
            return false;
        }

        if (doctorFeeField.getText().trim().isEmpty()) {
            showMessage("Doctor Fee cannot be empty");
            return false;
        }
        try {
            Double.parseDouble(doctorFeeField.getText().trim());
        } catch (NumberFormatException e) {
            showMessage("Doctor Fee must be a valid number");
            return false;
        }

        return true;
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
    }
}
