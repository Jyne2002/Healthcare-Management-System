package View;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class RevenueReport {
    private JPanel Main;
    private JComboBox<String> dropDmonth;
    private JComboBox<String> dropDyear;
    private JButton generateButton;
    private JTextArea textArea1;

    public RevenueReport() {
        initializeUI();  // Apply UI customizations
        initializeDropdowns();  // Populate dropdowns
    }

    public JPanel getMainPanel() {
        return Main;
    }

    public JComboBox<String> getDropDmonth() {
        return dropDmonth;
    }

    public JComboBox<String> getDropDyear() {
        return dropDyear;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JTextArea getTextArea() {
        return textArea1;
    }

    // 🎨 Apply styling to the UI components
    private void initializeUI() {
        Main = new JPanel();
        Main.setLayout(new BorderLayout());
        Main.setBackground(new Color(240, 248, 255)); // Light blue background

        // Create top panel for month & year selection
        JPanel selectionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        selectionPanel.setBorder(BorderFactory.createTitledBorder("Select Month & Year"));
        selectionPanel.setBackground(new Color(200, 230, 255));

        JLabel monthLabel = new JLabel("Month:");
        JLabel yearLabel = new JLabel("Year:");

        dropDmonth = new JComboBox<>();
        dropDyear = new JComboBox<>();

        // ✅ Make the button smaller
        generateButton = new JButton("Generate");
        generateButton.setBackground(new Color(30, 144, 255)); // Dodger Blue
        generateButton.setForeground(Color.WHITE);
        generateButton.setFont(new Font("Arial", Font.BOLD, 12)); // Smaller Font
        generateButton.setPreferredSize(new Dimension(100, 30)); // Set Fixed Size

        selectionPanel.add(monthLabel);
        selectionPanel.add(dropDmonth);
        selectionPanel.add(yearLabel);
        selectionPanel.add(dropDyear);

        // 🎨 Styling the TextArea
        textArea1 = new JTextArea(10, 30);
        textArea1.setFont(new Font("Bahnschrift", Font.BOLD, 15));
        textArea1.setForeground(Color.BLACK);
        textArea1.setBackground(Color.WHITE);
        textArea1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
        textArea1.setEditable(false);

        JScrollPane textScrollPane = new JScrollPane(textArea1);

        // Create a panel for the button and center it
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(240, 248, 255));
        buttonPanel.add(generateButton);

        // Add everything to the main panel
        Main.add(selectionPanel, BorderLayout.NORTH);
        Main.add(buttonPanel, BorderLayout.CENTER);
        Main.add(textScrollPane, BorderLayout.SOUTH);
    }

    private void initializeDropdowns() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        for (String month : months) {
            dropDmonth.addItem(month);
        }

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= currentYear - 10; i--) {
            dropDyear.addItem(String.valueOf(i));
        }
    }
}
