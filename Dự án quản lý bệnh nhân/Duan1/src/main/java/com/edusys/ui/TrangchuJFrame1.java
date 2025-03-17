/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.edusys.ui;


import com.edusys.utils.Auth;
import com.edusys.utils.XImage;
import com.edusys.utils.MsgBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author Hi
 */
public class TrangchuJFrame1 extends javax.swing.JFrame {

   

    void init() {
        setSize(1000, 600);
        setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(this);
        setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO EDUSYS");
        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblDongHo.setText(format.format(new Date()));
            }
        }).start();    
    }
     public TrangchuJFrame1() {
        initComponents();
        init();
    }
    
    void openBenhNhan() {    
            new BenhNhanJDialog(this, true).setVisible(true);
        
    }
   
    void openThanNhan() {    
           new ThanNhanJDialog(this, true).setVisible(true);
       
    }
    void openDichVu() {     
           new DichVuJDialog(this, true).setVisible(true);
      
    }
    
    void openBenhAn() {
           new BenhAnJDialog(this, true).setVisible(true);
        
    }
    
    void openTrunggian() {
            new Trunggian2Dialog(this, true).setVisible(true);
            dispose();  
       
    }

    void KetThuc() {
        if (MsgBox.confirm(this, "BẠN MUỐN KẾT THÚC CHƯƠNG TRÌNH?")) {
            System.exit(0);
        }
    }
    void thongke() {
            new ThongkeBenhNhanJDialog(this, true).setVisible(true);  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        btnDangXuat = new javax.swing.JButton();
        btnKetThuc = new javax.swing.JButton();
        btnbenhnhan = new javax.swing.JButton();
        btnthannhan = new javax.swing.JButton();
        btnbenhan = new javax.swing.JButton();
        btndichvu = new javax.swing.JButton();
        btndichvu1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTrangThai = new javax.swing.JLabel();
        lblDongHo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuHeThong = new javax.swing.JMenu();
        mniDangNhap = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mniDangXuat = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mniDoiMatKhau = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mniKetThuc = new javax.swing.JMenuItem();
        mnuQuanLy = new javax.swing.JMenu();
        mniNguoiHoc = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mniChuyenDe = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mniKhoaHoc = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mniQuanLyNhanVien = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar1.setRollover(true);

        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Exit.png"))); // NOI18N
        btnDangXuat.setText("Trang chủ");
        btnDangXuat.setFocusable(false);
        btnDangXuat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDangXuat.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDangXuat);

        btnKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Stop.png"))); // NOI18N
        btnKetThuc.setText("Kết thúc");
        btnKetThuc.setFocusable(false);
        btnKetThuc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKetThuc.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetThucActionPerformed(evt);
            }
        });
        jToolBar1.add(btnKetThuc);

        btnbenhnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/User group.png"))); // NOI18N
        btnbenhnhan.setText("Bệnh nhân");
        btnbenhnhan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbenhnhan.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnbenhnhan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbenhnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbenhnhanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnbenhnhan);

        btnthannhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Users.png"))); // NOI18N
        btnthannhan.setText("Thân nhân");
        btnthannhan.setFocusable(false);
        btnthannhan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnthannhan.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnthannhan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnthannhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthannhanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnthannhan);

        btnbenhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Lists.png"))); // NOI18N
        btnbenhan.setText("Bệnh án");
        btnbenhan.setFocusable(false);
        btnbenhan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnbenhan.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnbenhan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnbenhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbenhanActionPerformed(evt);
            }
        });
        jToolBar1.add(btnbenhan);

        btndichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Price list.png"))); // NOI18N
        btndichvu.setText("Dịch vụ");
        btndichvu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndichvu.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btndichvu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btndichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndichvuActionPerformed(evt);
            }
        });
        jToolBar1.add(btndichvu);

        btndichvu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Bar chart.png"))); // NOI18N
        btndichvu1.setText("Thống Kê Bệnh Nhân");
        btndichvu1.setFocusable(false);
        btndichvu1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btndichvu1.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btndichvu1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btndichvu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndichvu1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btndichvu1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblTrangThai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Info.png"))); // NOI18N
        lblTrangThai.setText("Hệ quản lý đào tạo ");

        lblDongHo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Alarm.png"))); // NOI18N
        lblDongHo.setText("00 : 00 : 00 am");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addComponent(lblDongHo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDongHo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        mnuHeThong.setText("Hệ thống");

        mniDangNhap.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Key.png"))); // NOI18N
        mniDangNhap.setText("Đăng nhập");
        mniDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDangNhapActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDangNhap);
        mnuHeThong.add(jSeparator1);

        mniDangXuat.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mniDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Exit.png"))); // NOI18N
        mniDangXuat.setText("Đăng xuất");
        mnuHeThong.add(mniDangXuat);
        mnuHeThong.add(jSeparator2);

        mniDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Refresh.png"))); // NOI18N
        mniDoiMatKhau.setText("Đổi mật khẩu");
        mniDoiMatKhau.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                mniDoiMatKhauMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        mniDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDoiMatKhauActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniDoiMatKhau);
        mnuHeThong.add(jSeparator3);

        mniKetThuc.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mniKetThuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Stop.png"))); // NOI18N
        mniKetThuc.setText("Kết thúc");
        mniKetThuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKetThucActionPerformed(evt);
            }
        });
        mnuHeThong.add(mniKetThuc);

        jMenuBar1.add(mnuHeThong);

        mnuQuanLy.setText("Quản lý");

        mniNguoiHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/User group.png"))); // NOI18N
        mniNguoiHoc.setText("Bệnh nhân");
        mniNguoiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNguoiHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniNguoiHoc);
        mnuQuanLy.add(jSeparator4);

        mniChuyenDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Users.png"))); // NOI18N
        mniChuyenDe.setText("Thân nhân");
        mniChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniChuyenDeActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniChuyenDe);
        mnuQuanLy.add(jSeparator5);

        mniKhoaHoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Lists.png"))); // NOI18N
        mniKhoaHoc.setText("Bệnh án");
        mniKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniKhoaHocActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniKhoaHoc);
        mnuQuanLy.add(jSeparator6);

        mniQuanLyNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/edusys/icon/Price list.png"))); // NOI18N
        mniQuanLyNhanVien.setText("Dịch vụ");
        mniQuanLyNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniQuanLyNhanVienActionPerformed(evt);
            }
        });
        mnuQuanLy.add(mniQuanLyNhanVien);

        jMenuBar1.add(mnuQuanLy);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 379, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 359, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKetThucActionPerformed
        KetThuc();
    }//GEN-LAST:event_mniKetThucActionPerformed

    private void mniKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniKhoaHocActionPerformed
        
    }//GEN-LAST:event_mniKhoaHocActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        openTrunggian();
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnKetThucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetThucActionPerformed
        KetThuc();
    }//GEN-LAST:event_btnKetThucActionPerformed

    private void btndichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndichvuActionPerformed
    openDichVu();
    }//GEN-LAST:event_btndichvuActionPerformed

    private void mniDoiMatKhauMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_mniDoiMatKhauMenuKeyPressed
      
    }//GEN-LAST:event_mniDoiMatKhauMenuKeyPressed

    private void mniDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDoiMatKhauActionPerformed
        
    }//GEN-LAST:event_mniDoiMatKhauActionPerformed

    private void mniDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDangNhapActionPerformed
        
    }//GEN-LAST:event_mniDangNhapActionPerformed

    private void btnbenhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbenhanActionPerformed
    openBenhAn();
    }//GEN-LAST:event_btnbenhanActionPerformed

    private void btnthannhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthannhanActionPerformed
        openThanNhan();
    }//GEN-LAST:event_btnthannhanActionPerformed

    private void mniQuanLyNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniQuanLyNhanVienActionPerformed
        
    }//GEN-LAST:event_mniQuanLyNhanVienActionPerformed

    private void btnbenhnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbenhnhanActionPerformed
        openBenhNhan();
    }//GEN-LAST:event_btnbenhnhanActionPerformed

    private void mniNguoiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNguoiHocActionPerformed
        
    }//GEN-LAST:event_mniNguoiHocActionPerformed

    private void mniChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniChuyenDeActionPerformed
        
    }//GEN-LAST:event_mniChuyenDeActionPerformed

    private void btndichvu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndichvu1ActionPerformed
        // TODO add your handling code here:
        thongke();
    }//GEN-LAST:event_btndichvu1ActionPerformed

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
            java.util.logging.Logger.getLogger(TrangchuJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangchuJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangchuJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangchuJFrame1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangchuJFrame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnKetThuc;
    private javax.swing.JButton btnbenhan;
    private javax.swing.JButton btnbenhnhan;
    private javax.swing.JButton btndichvu;
    private javax.swing.JButton btndichvu1;
    private javax.swing.JButton btnthannhan;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblDongHo;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JMenuItem mniChuyenDe;
    private javax.swing.JMenuItem mniDangNhap;
    private javax.swing.JMenuItem mniDangXuat;
    private javax.swing.JMenuItem mniDoiMatKhau;
    private javax.swing.JMenuItem mniKetThuc;
    private javax.swing.JMenuItem mniKhoaHoc;
    private javax.swing.JMenuItem mniNguoiHoc;
    private javax.swing.JMenuItem mniQuanLyNhanVien;
    private javax.swing.JMenu mnuHeThong;
    private javax.swing.JMenu mnuQuanLy;
    // End of variables declaration//GEN-END:variables
}
