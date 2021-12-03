/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import helper.Auth;
import helper.JDialogHelper;
import java.util.List;
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.DefaultComboBoxModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import landCoffee_DAO.HoaDonChiTiet_DAO;
import landCoffee_DAO.HoaDon_DAO;
import landCoffee_DAO.KhachHang_DAO;
import landCoffee_DAO.SanPham_DAO;
import landCoffee_Entity.HoaDon;
import landCoffee_Entity.HoaDonChiTiet;
import landCoffee_Entity.KhachHang;
import landCoffee_Entity.SanPham;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author Dell
 */
public class BanHang extends javax.swing.JInternalFrame {

    /**
     * Creates new form TrangChu
     */
    DefaultTableModel mol;
    float tongTien;
    SanPham_DAO daoSP = new SanPham_DAO();
    HoaDon_DAO hdDAO = new HoaDon_DAO();
    HoaDonChiTiet_DAO hdctDAO = new HoaDonChiTiet_DAO();
    KhachHang_DAO khDAO = new KhachHang_DAO();
    boolean checkRow = false;
    int count = 0;
    int maHD = 1;

    public BanHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        init();
        System.out.println(Auth.user.getTaiKhoan());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        cboMenu = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        txtSL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtTienTraLai = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Đơn Giá", "Số Lượng", "Tổng Tiền"
            }
        ));
        jScrollPane4.setViewportView(jTable3);

        jLabel15.setText("Số lượng");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Trang Chủ");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jPanel4.setBackground(new java.awt.Color(51, 0, 0));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cafe_1.png"))); // NOI18N
        jLabel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cafe sữa1.png"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/nước cam1.png"))); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/trà sữa 1.png"))); // NOI18N
        jLabel14.setText("jLabel9");
        jLabel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jCheckBox1.setBackground(new java.awt.Color(51, 0, 0));
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Cafe Đen");

        jCheckBox2.setBackground(new java.awt.Color(51, 0, 0));
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Cafe Sữa");

        jCheckBox3.setBackground(new java.awt.Color(51, 0, 0));
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Cam ép");

        jCheckBox4.setBackground(new java.awt.Color(51, 0, 0));
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setText("Trà sữa");

        cboMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox1)))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox2)))
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox3)))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBox1))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cboMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBox2)
                                    .addComponent(jCheckBox4))))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Đồ uống", jPanel4);

        jPanel5.setBackground(new java.awt.Color(51, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        jTabbedPane5.addTab("Đồ ăn", jPanel5);

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Đơn Giá", "Số Lượng"
            }
        ));
        jScrollPane3.setViewportView(tblBang);

        txtSL.setText("1");
        txtSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLActionPerformed(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Số lượng");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        jButton5.setText("Thêm đồ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        jButton6.setText("Bỏ đồ");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Thành Tiền");

        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tiền Khách Đưa");

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyTyped(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Tiền Trả Lại");

        txtTienTraLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienTraLaiActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save as.png"))); // NOI18N
        jButton1.setText("Lưu và in hóa đơn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã khách hàng");

        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(26, 26, 26)
                        .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel1))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienTraLai)
                            .addComponent(txtTongTien)
                            .addComponent(txtTienKhachDua)
                            .addComponent(txtMaKH))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5)
                            .addComponent(jButton6))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtTienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addComponent(jButton1)))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTienTraLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienTraLaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienTraLaiActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        fillTable();
        checkRow = true;
        System.out.println(count);
        txtTongTien.setText(tongTien + "");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if (tblBang.getSelectedRow() >= 0) {
            tongTien = tongTien - Float.parseFloat(tblBang.getValueAt(tblBang.getSelectedRow(), 3) + "");

            txtTongTien.setText(tongTien + "");
            boDo();
        } else {
            JDialogHelper.alert(this, "Chưa chọn đồ cần bỏ");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtTienKhachDuaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKhachDuaKeyPressed

    private void txtTienKhachDuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTienKhachDuaKeyTyped

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        // TODO add your handling code here:
        if (txtTienKhachDua.getText().isEmpty()) {
            txtTienTraLai.setText("");
        }
        tinhTienTraLai();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        checkMaKH();
        if (checkMaKH() == true) {
            themHD();
            List<HoaDon> list = hdDAO.selectAll();
            int x = list.size();
            maHD = list.get(x - 1).getMaHD();
            System.out.println(maHD);
            for (int xy = 0; xy < count; xy++) {
                int sl = Integer.parseInt(tblBang.getValueAt(xy, 1) + "");
                themHDCT(xy, sl);
            }
        }

        // themHDCT();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed
    void init() {
        setTable();
        setCBO();
        txtTienTraLai.setEnabled(false);
    }
 
    void setTable() {
        mol = (DefaultTableModel) tblBang.getModel();
        mol.setColumnCount(0);
        String col[] = {" Tên Sản phẩm", "Số lượng", "Giá tiền", "Thành tiền"};
        for (String x : col) {
            mol.addColumn(x);
        }
    }

    void setCBO() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMenu.getModel();
        model.removeAllElements();
        List<SanPham> list = daoSP.selectAll();
        for (SanPham x : list) {
            model.addElement(x);
        }

    }

    boolean checkMaKH() {
        List<KhachHang> list = khDAO.selectAll();
        boolean check = false;
        for (KhachHang x : list) {
            if (txtMaKH.getText().equalsIgnoreCase(x.getMaKH())) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        return check;
    }

    HoaDon getForm() {
        String maKH;

        if (txtMaKH.getText().equalsIgnoreCase("")) {
            maKH = "1";
        } else {
            try {
                Integer.parseInt(txtMaKH.getText()+"");
                maKH = txtMaKH.getText();
            } catch (Exception e) {
            }

        }

        return new HoaDon(txtMaKH.getText(), Auth.user.getTaiKhoan(), tongTien);

    }

    void themHD() {
        try {
            HoaDon hd = getForm();
            hdDAO.insert(hd);
            JDialogHelper.alert(this, "Thêm thành công");

        } catch (Exception e) {
            JDialogHelper.alert(this, "Lỗi");
        }
    }

    void themHDCT(int rowSel, int SL) {
        try {
            HoaDonChiTiet hdct = getForm1(rowSel, SL);
            hdctDAO.insert(hdct);
            // JDialogHelper.alert(this, "Thêm thành công");
        } catch (Exception e) {
            JDialogHelper.alert(this, "Thêm thất bại");
        }
    }

    HoaDonChiTiet getForm1(int rowSel, int SL) {

        List<SanPham> list = daoSP.selectAll();
        Date date = Date.valueOf(LocalDate.now());
        double gia = 0;
        String maSP = "";
        for (SanPham x : list) {
            if (x.getTenSP().equalsIgnoreCase(tblBang.getValueAt(rowSel, 0) + "")) {
                gia = x.getGia();
                maSP = x.getMaSP();
                System.out.println(gia);
                break;
            }
        }
        HoaDonChiTiet hdct = new HoaDonChiTiet(maSP, SL, maHD, tongTien, date);
        return hdct;
    }

    void fillTable() {
        List<SanPham> list = daoSP.selectAll();
        double gia = 0;
        String tenSP = "";
        boolean checkTrungSP = false;
        for (SanPham x : list) {
            if (x.getTenSP().equalsIgnoreCase(cboMenu.getSelectedItem() + "")) {
                gia = x.getGia();
                tenSP = x.getTenSP();
                break;
            }
        }
        Integer sl = Integer.parseInt(txtSL.getText());
        double thanhTien = sl * gia;
        tongTien = (float) (tongTien + thanhTien);
        DefaultTableModel mol = (DefaultTableModel) tblBang.getModel();
        Object[] row = {cboMenu.getSelectedItem(), txtSL.getText(), gia, thanhTien};
        if (count > 0) {
            for (int x = 0; x < count; x++) {
                if (cboMenu.getSelectedItem().equals(tblBang.getValueAt(x, 0))) {
                    int sl1 = sl + Integer.parseInt(tblBang.getValueAt(x, 1) + "");
                    double thanhTien1 = thanhTien + Double.parseDouble(tblBang.getValueAt(x, 3) + "");
                    mol.setValueAt(sl1, x, 1);
                    mol.setValueAt(thanhTien1, x, 3);
                    checkTrungSP = false;
                    break;
                } else {
                    checkTrungSP = true;
                }
                // System.out.println(tblBang.getValueAt(x, 3) + "");
            }

        } else {
            mol.addRow(row);
            count++;
        }
        if (checkTrungSP == true) {
            mol.addRow(row);
            count++;
        }
    }

    void boDo() {
        DefaultTableModel mol = (DefaultTableModel) tblBang.getModel();
        mol.removeRow(tblBang.getSelectedRow());
    }

    void tinhTienTraLai() {
        float tienTraLai;
        try {
            float tienKhachDua = Float.parseFloat(txtTienKhachDua.getText() + "");
            float tienTong = Float.parseFloat(txtTongTien.getText() + "");
            tienTraLai = tienKhachDua - tienTong;
            if (txtTienKhachDua.getText().equalsIgnoreCase("")) {
                txtTienTraLai.setText("");
            } else {
                txtTienTraLai.setText(tienTraLai + "");
            }
        } catch (Exception e) {
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienTraLai;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
