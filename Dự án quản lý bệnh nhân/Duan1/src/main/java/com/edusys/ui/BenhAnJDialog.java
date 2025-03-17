/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.edusys.ui;

import com.edusys.dao.BenhAnDAO;
import com.edusys.entity.BenhAn;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class BenhAnJDialog extends javax.swing.JDialog {
    BenhAnDAO dao = new BenhAnDAO();
              int row = 0;
    /**
     * Creates new form BenhAnJDialog
     */
    public BenhAnJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
        
    }
    void FillTable() {
    DefaultTableModel model = (DefaultTableModel) tblBenhAn.getModel();
    model.setRowCount(0);
    try {
        List <BenhAn> list = dao.selectAll();
        for (BenhAn BA : list) {
            Object[] row = {
                BA.getMã_Bệnh_Án(),
                BA.getBệnh_dự_đoán(),
                BA.getTriệu_chứng(),
                BA.getChẩn_Đoán(),
                BA.getPhương_Pháp(),
            };
            model.addRow(row);  // Thêm hàng vào mô hình bảng
        }
    } catch (Exception e) {
        MsgBox.alert(this, "Lỗi Truy Vấn Lỗi Dữ Liệu");
    }
}
   void init(){
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("Hệ Thống Quản Lý Bệnh Nhân");
        FillTable();
    }
    void edit(){
        try {
            String MaNV = String.valueOf(tblBenhAn.getValueAt(this.row,0));
            System.out.println("MaNV"+MaNV);
            BenhAn model = dao.selectByID(MaNV);
            if (model != null) {
                setFrom(model);
//                updateStatus();
                tabs.setSelectedIndex(1);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi Truy Vấn Dữ Liệu"+e.getMessage());
        }
    }
    void setFrom(BenhAn model){
        txtbenhdudoan.setText(model.getBệnh_dự_đoán());
        txttrieuchung.setText(model.getTriệu_chứng());
        txtchandoan.setText(model.getChẩn_Đoán());
        txtphuongphap.setText(model.getPhương_Pháp());
        txtmabenhan.setText(String.valueOf(model.getMã_Bệnh_Án()));
    }
    BenhAn getForm() {
    BenhAn model = new BenhAn();

    // Set the properties of the NhanVien model using values from GUI components
    model.setBệnh_dự_đoán(txtbenhdudoan.getText());
    model.setTriệu_chứng(txttrieuchung.getText());
    model.setChẩn_Đoán(txtchandoan.getText());
    model.setPhương_Pháp(txtphuongphap.getText());
    model.setMã_Bệnh_Án(Integer.parseInt(txtmabenhan.getText()));


    // Return the populated model
    return model;
    }
    void clearForm() {
    // Create a new NhanVien object and set the form with this new object, effectively clearing the form
    this.setFrom(new BenhAn());

    }
    void First(){
        row = 0;
        edit();
    }
    
    void prev(){
        if (row > 0) {
            row--;
            edit();
        }
    }
    
    void next(){
        if (row < tblBenhAn.getRowCount() - 1) {
            row++;
            edit();
        }
    }
    void last(){
        row = tblBenhAn.getRowCount() - 1;
        edit();
    }
    void update() {
        BenhAn model = getForm();

        try {
            dao.update(model);
            this.FillTable();
            this.clearForm();

            MsgBox.alert(this, "Sửa thành công");
        } catch (Exception e) {
            MsgBox.alert(this, "Sửa Thất Bại" + e.getMessage());
        }

    }
    void updateStatus() {
    // Determine if a row is currently selected (edit mode)
    boolean edit = this.row >= 0;
    // Determine if the first row is selected
    boolean first = this.row == 0;
    // Determine if the last row is selected
    boolean last = this.row == tblBenhAn.getRowCount() - 1;

    // Enable or disable the txtMaNV text field based on edit mode
    txtmabenhan.setEditable(!edit);

    // When in insert mode, the update and delete buttons should be disabled
    btnthem2.setEnabled(!edit);
    btnsua2.setEnabled(edit);
    btnxoa2.setEnabled(edit);

    // Navigation buttons should be enabled based on the current row position
    btnfirst2.setEnabled(edit && !first);
    btnprev2.setEnabled(edit && !first);
    btnnext2.setEnabled(edit && !last);
    btnlast2.setEnabled(edit && !last);
    }
    void insert() {
            // Get the Dichvu model from the form
            BenhAn model = getForm();
            String comfirm = new String(txtchandoan.getText());
            if (comfirm.equals(model.getChẩn_Đoán())) {
                try {
                    dao.insert(model);
                    this.FillTable();
                    this.clearForm();

                    MsgBox.alert(this, "Thêm Mới Thành Công");
                } catch (Exception e) {
                    MsgBox.alert(this, "Thêm Mới Thất Bại" + e.getMessage());
                }
            } else {
            }
        }
    void delete() {

        if (MsgBox.confirm(this, "Bạn thực sự muốn xóa?")) {
            String manv = txtmabenhan.getText();
            try {
                // Attempt to delete the employee record
                dao.delete(manv);
                
                // Refresh the table to show updated data
                this.FillTable();
                
                // Clear the form
                this.clearForm();
                
                // Show success message
                MsgBox.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                // Show failure message if deletion fails
                MsgBox.alert(this, "Xóa thất bại!");
                    }
                }
            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBenhAn = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtmota = new javax.swing.JLabel();
        btnthem2 = new javax.swing.JButton();
        btnsua2 = new javax.swing.JButton();
        btnxoa2 = new javax.swing.JButton();
        btnmoi2 = new javax.swing.JButton();
        btnfirst2 = new javax.swing.JButton();
        btnprev2 = new javax.swing.JButton();
        btnnext2 = new javax.swing.JButton();
        btnlast2 = new javax.swing.JButton();
        txtbenhdudoan = new javax.swing.JTextField();
        txtphuongphap = new javax.swing.JTextField();
        txtchandoan = new javax.swing.JTextField();
        txttrieuchung = new javax.swing.JTextField();
        txtmabenhan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Bệnh Án");

        tblBenhAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã_Bệnh_Án", "Bệnh_dự_đoán", "Triệu_chứng", "Chẩn_Đoán", "Phương_Pháp"
            }
        ));
        tblBenhAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBenhAnMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblBenhAn);
        if (tblBenhAn.getColumnModel().getColumnCount() > 0) {
            tblBenhAn.getColumnModel().getColumn(0).setResizable(false);
            tblBenhAn.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBenhAn.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblBenhAn.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", jPanel2);

        jLabel3.setText("Bệnh_dự_đoán");

        jLabel4.setText("Triệu_chứng");

        jLabel5.setText("Chẩn_Đoán");

        jLabel6.setText("Phương_Pháp");

        txtmota.setText("Mã_Bệnh_Án");

        btnthem2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnthem2.setText("Thêm");
        btnthem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthem2ActionPerformed(evt);
            }
        });

        btnsua2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnsua2.setText("Sửa");
        btnsua2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsua2ActionPerformed(evt);
            }
        });

        btnxoa2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnxoa2.setText("Xóa");
        btnxoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoa2ActionPerformed(evt);
            }
        });

        btnmoi2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnmoi2.setText("Mới");
        btnmoi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoi2ActionPerformed(evt);
            }
        });

        btnfirst2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnfirst2.setText("|<");
        btnfirst2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirst2ActionPerformed(evt);
            }
        });

        btnprev2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnprev2.setText("<<");
        btnprev2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprev2ActionPerformed(evt);
            }
        });

        btnnext2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnnext2.setText(">>");
        btnnext2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnext2ActionPerformed(evt);
            }
        });

        btnlast2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlast2.setText(">|");
        btnlast2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlast2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(299, 705, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnthem2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsua2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnxoa2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnmoi2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnfirst2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnprev2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnnext2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnlast2))
                            .addComponent(txtmabenhan)
                            .addComponent(txtphuongphap)
                            .addComponent(txtchandoan)
                            .addComponent(txttrieuchung)
                            .addComponent(txtbenhdudoan))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbenhdudoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttrieuchung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtchandoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtphuongphap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmabenhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlast2)
                    .addComponent(btnnext2)
                    .addComponent(btnprev2)
                    .addComponent(btnfirst2)
                    .addComponent(btnmoi2)
                    .addComponent(btnxoa2)
                    .addComponent(btnsua2)
                    .addComponent(btnthem2))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthem2ActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnthem2ActionPerformed

    private void btnsua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsua2ActionPerformed
        // TODO add your handling code here:
        update();

    }//GEN-LAST:event_btnsua2ActionPerformed

    private void btnxoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoa2ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnxoa2ActionPerformed

    private void btnmoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoi2ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnmoi2ActionPerformed

    private void btnfirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirst2ActionPerformed
        // TODO add your handling code here:
        First();
    }//GEN-LAST:event_btnfirst2ActionPerformed

    private void btnprev2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprev2ActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnprev2ActionPerformed

    private void btnnext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnext2ActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnnext2ActionPerformed

    private void btnlast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlast2ActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnlast2ActionPerformed

    private void tblBenhAnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBenhAnMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount()== 2) {
            this.row = tblBenhAn.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblBenhAnMousePressed

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
            java.util.logging.Logger.getLogger(BenhAnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BenhAnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BenhAnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BenhAnJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BenhAnJDialog dialog = new BenhAnJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfirst2;
    private javax.swing.JButton btnlast2;
    private javax.swing.JButton btnmoi2;
    private javax.swing.JButton btnnext2;
    private javax.swing.JButton btnprev2;
    private javax.swing.JButton btnsua2;
    private javax.swing.JButton btnthem2;
    private javax.swing.JButton btnxoa2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblBenhAn;
    private javax.swing.JTextField txtbenhdudoan;
    private javax.swing.JTextField txtchandoan;
    private javax.swing.JTextField txtmabenhan;
    private javax.swing.JLabel txtmota;
    private javax.swing.JTextField txtphuongphap;
    private javax.swing.JTextField txttrieuchung;
    // End of variables declaration//GEN-END:variables
}
