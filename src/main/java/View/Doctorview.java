package View;
import Model.Doctor;
import Controller.DoctorController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;

public class Doctorview extends javax.swing.JFrame {
 private DoctorController controller;

    public Doctorview() {
        this.controller = new DoctorController();
        initComponents();
        setResizable(false);
        updateTable();
    }

    /**
     * Updates the JTable with data from the controller.
     */
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        model.setRowCount(0);
        for (Doctor doctor : controller.getDoctors()) {
            model.addRow(new Object[]{
                    String.valueOf(doctor.getId()),
                    doctor.getName(),
                    doctor.getSpecialization(),
                    doctor.getAvailability(),
                    doctor.getContactNumber()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        headerTextField = new javax.swing.JTextField();
        TableScrollPanel = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        buttonPanel = new javax.swing.JPanel();
        Addbutton = new javax.swing.JButton();
        Updatebutton = new javax.swing.JButton();
        Removebutton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        HomeBtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        headerTextField.setBackground(new java.awt.Color(255, 153, 153));
        headerTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        headerTextField.setText("Doctor Schedules");
        headerTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headerTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTextField, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc.ID", "Name", "Specialization", "Availability", "ContactNumber"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableScrollPanel.setViewportView(Table);

        buttonPanel.setBackground(new java.awt.Color(204, 204, 204));

        Addbutton.setBackground(new java.awt.Color(255, 255, 102));
        Addbutton.setText("Add Doctor");
        Addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddbuttonActionPerformed(evt);
            }
        });

        Updatebutton.setBackground(new java.awt.Color(255, 255, 102));
        Updatebutton.setText("Update");
        Updatebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebuttonActionPerformed(evt);
            }
        });

        Removebutton.setBackground(new java.awt.Color(255, 255, 102));
        Removebutton.setText("Remove Doctor");
        Removebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemovebuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Addbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(Removebutton)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Updatebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Removebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MediCarePlus");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        HomeBtn.setBackground(new java.awt.Color(255, 255, 102));
        HomeBtn.setText("jButton1");

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setText("jButton1");

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setText("jButton1");

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setText("Home");

        jButton5.setBackground(new java.awt.Color(255, 255, 102));
        jButton5.setText("jButton1");

        jButton6.setBackground(new java.awt.Color(255, 255, 102));
        jButton6.setText("jButton1");

        jButton7.setBackground(new java.awt.Color(255, 255, 102));
        jButton7.setText("jButton1");

        jButton8.setBackground(new java.awt.Color(255, 255, 102));
        jButton8.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton7)
                    .addComponent(jButton5)
                    .addComponent(HomeBtn)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton6)
                    .addComponent(jButton4))
                .addGap(24, 24, 24))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HomeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void headerTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headerTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_headerTextFieldActionPerformed

    private void AddbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddbuttonActionPerformed
         DoctorFormDialog form = new DoctorFormDialog(this, "Add Doctor", null);
    form.setVisible(true);
    if (form.isSubmitted()) {
        String[] data = form.getFormData();
        Doctor newDoctor = new Doctor(
                Integer.parseInt(data[0]),
                data[1],
                data[2],
                data[3],
                data[4]
        );
        controller.addDoctor(newDoctor);
        updateTable();
    }
    }//GEN-LAST:event_AddbuttonActionPerformed

    private void UpdatebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebuttonActionPerformed
         int selectedRow = Table.getSelectedRow();
    if (selectedRow >= 0) {
        String id = (String) Table.getValueAt(selectedRow, 0);
        String[] initialData = new String[5];
        for (int i = 0; i < 5; i++) {
            initialData[i] = (String) Table.getValueAt(selectedRow, i);
        }
        DoctorFormDialog form = new DoctorFormDialog(this, "Update Doctor", initialData);
        form.setVisible(true);
        if (form.isSubmitted()) {
            String[] data = form.getFormData();
            Doctor updatedDoctor = new Doctor(
                    Integer.parseInt(data[0]),
                    data[1],
                    data[2],
                    data[3],
                    data[4]
            );
            controller.updateDoctor(Integer.parseInt(id), updatedDoctor);
            updateTable();
        }
    } else {
        JOptionPane.showMessageDialog(this, "Select a doctor to update.");
    }
    }//GEN-LAST:event_UpdatebuttonActionPerformed

    private void RemovebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemovebuttonActionPerformed
       int selectedRow = Table.getSelectedRow();
    if (selectedRow >= 0) {
        int id = Integer.parseInt((String) Table.getValueAt(selectedRow, 0));
        controller.removeDoctor(id);
        updateTable();
    } else {
        JOptionPane.showMessageDialog(this, "Select a doctor to remove.");
    }
    }//GEN-LAST:event_RemovebuttonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Doctorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctorview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctorview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Addbutton;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JButton Removebutton;
    private javax.swing.JTable Table;
    private javax.swing.JScrollPane TableScrollPanel;
    private javax.swing.JButton Updatebutton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField headerTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
