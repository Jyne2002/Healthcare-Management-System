package View;

import Controller.PharmacyController;
import Model.PharmacyItem;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;

public class LowStockNotificationView extends javax.swing.JFrame {
    private PharmacyController controller = new PharmacyController();

    public LowStockNotificationView() {
        initComponents();
        controller = new PharmacyController();
        updateTable();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        Header = new javax.swing.JPanel();
        HeaderTxt = new javax.swing.JLabel();
        TableScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Buttons = new javax.swing.JPanel();
        CloseBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Low Stock Notification");
        setSize(800, 600);  // Set preferred size for the window

        Header.setBackground(new java.awt.Color(204, 204, 204));

        HeaderTxt.setBackground(new java.awt.Color(0, 0, 0));
        HeaderTxt.setFont(new java.awt.Font("Arial", 1, 28));
        HeaderTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HeaderTxt.setText("Low Stock Items");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(HeaderTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
        );
        HeaderLayout.setVerticalGroup(
                HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(HeaderTxt)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Table.setBackground(new java.awt.Color(204, 255, 255));
        Table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] { "ID", "Name", "Quantity", "Price (LKR)", "Exp Date" }
        ) {
            boolean[] canEdit = new boolean [] { false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        TableScrollPane1.setViewportView(Table);
        TableScrollPane1.setPreferredSize(new java.awt.Dimension(750, 400));  // Increase the preferred size of the table

        Buttons.setBackground(new java.awt.Color(204, 204, 204));

        CloseBtn.setBackground(new java.awt.Color(204, 204, 255));
        CloseBtn.setText("Close");
        CloseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonsLayout = new javax.swing.GroupLayout(Buttons);
        Buttons.setLayout(ButtonsLayout);
        ButtonsLayout.setHorizontalGroup(
                ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ButtonsLayout.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(CloseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(300, Short.MAX_VALUE))
        );
        ButtonsLayout.setVerticalGroup(
                ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonsLayout.createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addComponent(CloseBtn)
                                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TableScrollPane1)
                        .addComponent(Buttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TableScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);  // Center the window on the screen
    }

    private void CloseBtnActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);

        List<PharmacyItem> lowStockItems = controller.getLowStockItems();

        for (PharmacyItem item : lowStockItems) {
            model.addRow(new Object[]{
                    item.getId(),
                    item.getName(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getExpDate()
            });
        }

        if (model.getRowCount() > 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "⚠ WARNING: Some medicines are in low stock!",
                    "Low Stock Alert",
                    JOptionPane.WARNING_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "✅ All stock levels are sufficient.",
                    "Low Stock Notification",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LowStockNotificationView().setVisible(true);
            }
        });
    }

    private javax.swing.JPanel Buttons;
    private javax.swing.JButton CloseBtn;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel HeaderTxt;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TableScrollPane1;
}
