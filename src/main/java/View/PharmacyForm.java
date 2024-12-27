package View;

import Model.PharmacyItem;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PharmacyForm extends JDialog {
    private JTextField idField, nameField, quantityField, priceField, expDateField;
    private JButton saveButton, cancelButton;
    private PharmacyItem pharmacyItem;
    private Runnable onSaveListener;
    private List<PharmacyItem> existingItems;

    public PharmacyForm(JFrame parent, String title, PharmacyItem item, List<PharmacyItem> existingItems) {
        super(parent, title, true);
        this.pharmacyItem = item;
        this.existingItems = existingItems;

        // Initialize fields
        idField = new JTextField(String.valueOf(item.getId()), 20);
        nameField = new JTextField(item.getName(), 20);
        quantityField = new JTextField(String.valueOf(item.getQuantity()), 20);
        priceField = new JTextField(String.valueOf(item.getPrice()), 20);
        expDateField = new JTextField(item.getExpDate(), 20);

        // Initialize buttons
        saveButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        // Action for save button
        saveButton.addActionListener(e -> {
            if (validateForm()) {
                // Update the pharmacyItem with the values from the fields
                pharmacyItem.setId(Integer.parseInt(idField.getText()));
                pharmacyItem.setName(nameField.getText());
                pharmacyItem.setQuantity(Integer.parseInt(quantityField.getText()));
                pharmacyItem.setPrice(Double.parseDouble(priceField.getText()));
                pharmacyItem.setExpDate(expDateField.getText());

                // Call the onSaveListener if it's set
                if (onSaveListener != null) {
                    onSaveListener.run();
                }

                dispose(); // Close the dialog after save
            }
        });

        // Action for cancel button
        cancelButton.addActionListener(e -> dispose());

        // Layout for the form
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(quantityField);
        formPanel.add(new JLabel("Price (LKR):"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Exp Date:"));
        formPanel.add(expDateField);
        formPanel.add(saveButton);
        formPanel.add(cancelButton);

        // Set content pane and size
        setContentPane(formPanel);
        setSize(400, 300);
        setLocationRelativeTo(parent);
    }

    public PharmacyItem getPharmacyItem() {
        return pharmacyItem;
    }

    // Method to set the save listener
    public void setOnSaveListener(Runnable listener) {
        this.onSaveListener = listener;
    }

    private boolean validateForm() {

    if (idField.getText().trim().isEmpty()) {
        showError("ID cannot be empty.");
        return false;
    }
    if (nameField.getText().trim().isEmpty()) {
        showError("Name cannot be empty.");
        return false;
    }
    if (quantityField.getText().trim().isEmpty()) {
        showError("Quantity cannot be empty.");
        return false;
    }
    if (priceField.getText().trim().isEmpty()) {
        showError("Price cannot be empty.");
        return false;
    }
    if (expDateField.getText().trim().isEmpty()) {
        showError("Expiration Date cannot be empty.");
        return false;
    }

    // Validate ID as numeric
    int id = -1; // Declare id variable
    try {
        id = Integer.parseInt(idField.getText().trim());
    } catch (NumberFormatException e) {
        showError("ID must be a valid integer.");
        return false;
    }

    // Validate ID uniqueness
    for (PharmacyItem item : existingItems) {
        // Exclude the current item by checking its original ID
        if (item.getId() == id && item.getId() != pharmacyItem.getId()) {
            showError("ID already exists. Please enter a unique ID.");
            return false;
        }
    }

    // Validate Name uniqueness
    String name = nameField.getText().trim();
    for (PharmacyItem item : existingItems) {
    // Exclude the current item by checking its original name
    if (item.getName().equalsIgnoreCase(name) && item.getId() != pharmacyItem.getId()) {
        showError("Name already exists. Please enter a unique Name.");
        return false;
    }
    }

    // Validate quantity and price as numeric
    try {
        Integer.parseInt(quantityField.getText().trim());
    } catch (NumberFormatException e) {
        showError("Quantity must be a valid integer.");
        return false;
    }

    try {
        Double.parseDouble(priceField.getText().trim());
    } catch (NumberFormatException e) {
        showError("Price must be a valid number.");
        return false;
    }

    // Validate expiration date
    String expDate = expDateField.getText().trim();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    sdf.setLenient(false);
    try {
        Date date = sdf.parse(expDate);
        if (date.before(new Date())) {
            showError("Expiration Date must be today or a future date.");
            return false;
        }
    } catch (Exception e) {
        showError("Expiration Date must be in the format yyyy-MM-dd.");
        return false;
    }

    return true;
}

    // Show error message in a dialog box
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Validation Error", JOptionPane.ERROR_MESSAGE);
    }
}
