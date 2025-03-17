/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.edusys.ui;

import com.edusys.entity.BacSi;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import com.edusys.dao.BacSiDAO;
import com.edusys.utils.MsgBox;
import com.edusys.utils.XImage;

/**
 *
 * @author ASUS
 */
public class BacSiJDialog extends javax.swing.JDialog {

    BacSiDAO dao = new BacSiDAO();

    int row = 0;

    /**
     * Creates new form BacSiJDialog
     */
    public BacSiJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    void FillTable() {
        DefaultTableModel model = (DefaultTableModel) tblbacsi.getModel();
        model.setRowCount(0);
        try {
            List<BacSi> list = dao.selectAll();
            for (BacSi nv : list) {
                Object[] row = {
                    nv.getID_Bác_Sĩ(),
                    nv.getHọ(),
                    nv.getTên(),
                    nv.getĐịa_Chỉ(),
                    nv.getSố_Điện_Thoại(),
                    nv.getMã_khoa(),
                    nv.getChuyên_Môn(),
                    nv.getChức_Vụ(),
                    nv.getMã_Bệnh_Án()
                };
                model.addRow(row);  // Thêm hàng vào mô hình bảng
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi Truy Vấn Lỗi Dữ Liệu");
        }
    }

    void init() {
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        setTitle("Hệ Thống Quản Lý Bệnh Nhân");
        FillTable();
    }

    void insert() {
        // Get the Dichvu model from the form
        BacSi model = getForm();
        String comfirm = new String(txtten.getText());
        if (comfirm.equals(model.getTên())) {
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
            String manv = txtIdbacsi.getText();
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

    void edit() {
        try {
            String MaNV = String.valueOf(tblbacsi.getValueAt(this.row, 0));
            System.out.println("MaNV" + MaNV);
            BacSi model = dao.selectByID(MaNV);
            if (model != null) {
                setFrom(model);
//                updateStatus();
                tabs.setSelectedIndex(1);
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi Truy Vấn Dữ Liệu" + e.getMessage());
        }
    }

    void setFrom(BacSi model) {
        txtIdbacsi.setText(String.valueOf(model.getID_Bác_Sĩ()));
        txtho.setText(model.getHọ());
        txtten.setText(model.getTên());
        txtdiachi.setText(model.getĐịa_Chỉ());
        txtSDT.setText(String.valueOf(model.getSố_Điện_Thoại()));
        txtmakhoa.setText(String.valueOf(model.getMã_khoa()));
        txtchuyenmon.setText(model.getChuyên_Môn());
        txtchucvu.setText(model.getChức_Vụ());
        txtmabenhan.setText(String.valueOf(model.getMã_Bệnh_Án()));
    }

    BacSi getForm() {
        BacSi model = new BacSi();

        // Set the properties of the NhanVien model using values from GUI components
        model.setID_Bác_Sĩ(Integer.parseInt(txtIdbacsi.getText()));
        model.setHọ(txtho.getText());
        model.setTên(txtten.getText());
        model.setĐịa_Chỉ(txtdiachi.getText());
        model.setSố_Điện_Thoại(Integer.parseInt(txtSDT.getText()));
        model.setMã_khoa(Integer.parseInt(txtmakhoa.getText()));
        model.setChuyên_Môn(txtchuyenmon.getText());
        model.setChức_Vụ(txtchucvu.getText());
        model.setMã_Bệnh_Án(Integer.parseInt(txtmabenhan.getText()));

        // Return the populated model
        return model;
    }

    void clearForm() {
        // Create a new NhanVien object and set the form with this new object, effectively clearing the form
        this.setFrom(new BacSi());

    }

    void First() {
        row = 0;
        edit();
    }

    void prev() {
        if (row > 0) {
            row--;
            edit();
        }
    }

    void next() {
        if (row < tblbacsi.getRowCount() - 1) {
            row++;
            edit();
        }
    }

    void last() {
        row = tblbacsi.getRowCount() - 1;
        edit();
    }

    void update() {
        BacSi model = getForm();

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
        boolean last = this.row == tblbacsi.getRowCount() - 1;

        // Enable or disable the txtMaNV text field based on edit mode
        txtIdbacsi.setEditable(!edit);

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbacsi = new javax.swing.JTable();
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtchuyenmon = new javax.swing.JTextField();
        txtchucvu = new javax.swing.JTextField();
        txtIdbacsi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtdiachi = new javax.swing.JTextField();
        txtmabenhan = new javax.swing.JTextField();
        txtten = new javax.swing.JTextField();
        txtmakhoa = new javax.swing.JTextField();
        txtho = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblbacsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Bác_Sĩ", "Họ", "Tên", "Địa_Chỉ", "Số_Điện_Thoại", "Mã_khoa", "Chuyên_Môn", "Chức_Vụ", "Mã_Bệnh_Án"
            }
        ));
        tblbacsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbacsiMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblbacsiMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblbacsi);
        if (tblbacsi.getColumnModel().getColumnCount() > 0) {
            tblbacsi.getColumnModel().getColumn(1).setResizable(false);
            tblbacsi.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblbacsi.getColumnModel().getColumn(2).setResizable(false);
            tblbacsi.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblbacsi.getColumnModel().getColumn(4).setPreferredWidth(100);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách", jPanel2);

        jLabel3.setText("ID_Bác_Sĩ");

        jLabel4.setText("Họ");

        jLabel5.setText("Tên");

        jLabel6.setText("Địa_chỉ");

        txtmota.setText("SĐT");

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

        jLabel7.setText("Chức_vụ");

        jLabel8.setText("Mã_Bệnh_Án");

        jLabel9.setText("Mã_Khoa");

        jLabel10.setText("Chuyên_Môn");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(299, 299, 299))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(412, 412, 412)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnthem2)
                        .addGap(33, 33, 33)
                        .addComponent(btnsua2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnfirst2)
                                .addGap(18, 18, 18)
                                .addComponent(btnprev2)
                                .addGap(76, 76, 76)
                                .addComponent(btnnext2)
                                .addGap(18, 18, 18)
                                .addComponent(btnlast2))
                            .addComponent(txtmabenhan, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdbacsi, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtmakhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnxoa2)
                                    .addGap(32, 32, 32)
                                    .addComponent(btnmoi2))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(299, 299, 299)))
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtchuyenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdbacsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmakhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtchuyenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtchucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmabenhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtmota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlast2)
                    .addComponent(btnnext2)
                    .addComponent(btnprev2)
                    .addComponent(btnfirst2)
                    .addComponent(btnmoi2)
                    .addComponent(btnxoa2)
                    .addComponent(btnsua2)
                    .addComponent(btnthem2))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        tabs.addTab("Cập nhật", jPanel1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Bác Sĩ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tabs, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlast2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlast2ActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnlast2ActionPerformed

    private void btnnext2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnext2ActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnnext2ActionPerformed

    private void btnprev2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprev2ActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnprev2ActionPerformed

    private void btnfirst2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirst2ActionPerformed
        // TODO add your handling code here:
        First();
    }//GEN-LAST:event_btnfirst2ActionPerformed

    private void btnmoi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoi2ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnmoi2ActionPerformed

    private void btnxoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoa2ActionPerformed
        // TODO add your handling code here:
        delete();
    }//GEN-LAST:event_btnxoa2ActionPerformed

    private void btnsua2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsua2ActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnsua2ActionPerformed

    private void btnthem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthem2ActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnthem2ActionPerformed

    private void tblbacsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbacsiMouseClicked
        // TODO add your handling code here:x   
    }//GEN-LAST:event_tblbacsiMouseClicked

    private void tblbacsiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbacsiMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            this.row = tblbacsi.getSelectedRow();
            edit();
        }
    }//GEN-LAST:event_tblbacsiMousePressed

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
            java.util.logging.Logger.getLogger(BacSiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BacSiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BacSiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BacSiJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BacSiJDialog dialog = new BacSiJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblbacsi;
    private javax.swing.JTextField txtIdbacsi;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtchucvu;
    private javax.swing.JTextField txtchuyenmon;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtho;
    private javax.swing.JTextField txtmabenhan;
    private javax.swing.JTextField txtmakhoa;
    private javax.swing.JLabel txtmota;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}
