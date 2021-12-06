/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDI;

import helper.Auth;
import helper.JDialogHelper;
import helper.JdbcHelper;
import helper.XValidated;
import static java.awt.Color.white;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import landCoffee_DAO.HoaDonChiTiet_DAO;
import landCoffee_DAO.KhachHang_DAO;
import landCoffee_Entity.HoaDonChiTiet;
import landCoffee_Entity.KhachHang;
import landCoffee_Entity.NhanVien;

/**
 *
 * @author Dell
 */
public class QuanLyKhachHang extends javax.swing.JInternalFrame {

    int index = -1;
    int soMaKH;

    /**
     * Creates new form QuanLyKhachHang
     */
    public QuanLyKhachHang() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        init();
    }
    int row = -1;
    KhachHang_DAO dao = new KhachHang_DAO();
    HoaDonChiTiet_DAO hdctDAO = new HoaDonChiTiet_DAO();

    void init() {
        fillTable();
        txtDiem.setText("0");
        txtDiem.setEnabled(false);
        this.row = -1;
        this.updateStatus();
        setTBL();
    }

    void fillTable() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        try {
            List<KhachHang> list = dao.selectAll();
            for (KhachHang kh : list) {
                Object[] row = {kh.getMaKH(), kh.getHoTen(), kh.getDiaChi(), kh.getSdt(), kh.getManv(), kh.getDiem()};
                model.addRow(row);
            }

        } catch (Exception e) {

            JDialogHelper.alert(this, "Lỗi truy vấn dữ liệu");

        }

    }

    void setTBL() {
        DefaultTableModel mol = (DefaultTableModel) tblLichSuMuaHang.getModel();
        mol.setColumnCount(0);
        mol.addColumn("Mã hóa đơn");
        mol.addColumn("Ngày mua");
        mol.addColumn("Tổng tiền");
    }

    void fillLichSuMuaHang(int x) {
        DefaultTableModel mol = (DefaultTableModel) tblLichSuMuaHang.getModel();
        mol.setRowCount(0);
        List<HoaDonChiTiet> list = hdctDAO.selectHoaDonByKeyword(x);
        for (int a = 0; a < list.size(); a++) {
            if (a > 0 && list.get(a).getMaHD() == list.get(a-1).getMaHD()) {
                continue;
            }
   //         Object[] row = {list.get(a).getMaHD(), list.get(a).getNgayTao(), list.get(a).getTongTien()};
            mol.addRow(new Object[]{list.get(a).getMaHD(), list.get(a).getNgayTao(), list.get(a).getTongTien()});
        }
    }

    void setForm(KhachHang kh) {
        txtTenKH.setText(kh.getHoTen());
        txtDiaChi.setText(kh.getDiaChi());
        txtsdt.setText(kh.getSdt());
        txtDiem.setText(String.valueOf(kh.getDiem()));
    }

    KhachHang getForm() {
        KhachHang kh = new KhachHang();
        kh.setHoTen(txtTenKH.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setSdt(txtsdt.getText());
        kh.setManv(Auth.user.getMaNV());
        kh.setDiem(Float.parseFloat(txtDiem.getText()));

        return kh;
    }

    public void setTrang() {
        txtTenKH.setBackground(white);
        txtDiaChi.setBackground(white);
        txtsdt.setBackground(white);
        txtDiem.setBackground(white);
    }

    void clearForm() {
        KhachHang kh = new KhachHang();
        setTrang();
        this.setForm(kh);
        this.row = -1;
        this.updateStatus();
    }

    void edit() {
        String makh = (String) tblKhachHang.getValueAt(this.row, 0);
        KhachHang kh = dao.selectById(makh);
        this.setForm(kh);
        tabs.setSelectedIndex(0);
        this.updateStatus();
        ;
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tblKhachHang.getRowCount() - 1);

        // Trạng thái form
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(!edit);
        btnXoa.setEnabled(!edit);

        // Trạng thái điều hướng
        btnFirt.setEnabled(edit && !first);
        btnPrev.setEnabled(edit && !first);
        btnNext.setEnabled(edit && !last);
        btnLast.setEnabled(edit && !last);
    }

    void firt() {
        this.row = 0;
        this.edit();
    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    void next() {
        if (this.row < tblKhachHang.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    void last() {
        this.row = tblKhachHang.getRowCount() - 1;
        this.edit();
    }

    void insert() {
//        if (XValidated.checkMaKH(txtMaKH, "Mã khách hàng này đã tồn tại!")) {
//            return;
//        }
        if (!CheckValidate()) {
            return;
        }
        KhachHang kh = getForm();
        try {
            dao.insert(kh);
            this.fillTable();
            this.clearForm();
            JDialogHelper.alert(this, "Thêm thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JDialogHelper.alert(this, "Thêm thật bại");
        }
    }

    void update() {
        if (!CheckValidate()) {
            return;
        }

        KhachHang kh = getForm();
        kh.setMaKH((tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0) + ""));
        try {
            dao.update(kh);
            this.fillTable();
            this.clearForm();
            JDialogHelper.alert(this, "Sửa thành công !");
        } catch (Exception e) {
            JDialogHelper.alert(this, "Sửa thất bại !");

        }
    }

    void delete() {

        String makh = (tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0) + "");
        if (JDialogHelper.confirm(this, "Bạn có muốn xóa khách hàng này không!")) {
            try {
                dao.delete(makh);
                this.fillTable();
                this.clearForm();
                JDialogHelper.alert(this, "Xóa thành công!");
            } catch (Exception e) {
                JDialogHelper.alert(this, "Xóa thất bại!");
            }
        }
    }

    private boolean CheckValidate() {
//        if (XValidated.checkRong(txtMaKH, "Mã không được trống!")) {
//            return false;
//        }
        if (XValidated.checkRong(txtTenKH, "Không được để trống tên!")) {
            return false;
        }
        if (txtDiaChi.getText().isEmpty()) {
            JDialogHelper.alert(this, "Không được để trống đia chỉ!");
            txtDiaChi.requestFocus();
            return false;
        }
        if (XValidated.checkRong(txtsdt, "Không được để trống số điện thoại!")) {
            return false;
        }
        if (XValidated.checkSDT(txtsdt, "Số điện thoại không đúng định dạng!")) {
            return false;
        }
        if (XValidated.checkRong(txtDiem, "Không được để trống điểm!")) {

            return false;
        }
        if (XValidated.checkSoNguyen(txtDiem, "Điểm sai định dạng!")) {
            return false;
        }
        return true;
    }

    void find() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        String keyword = txtTimTenKH.getText();
        List<KhachHang> list = dao.selectByKeyword(keyword);
        for (int x = 0; x < list.size(); x++) {
            model.addRow(new Object[]{list.get(x).getMaKH(), list.get(x).getHoTen(), list.get(x).getDiaChi(),
                list.get(x).getSdt(), list.get(x).getManv(), list.get(x).getDiem()});
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

        tabs = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtTimTenKH = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtDiem = new javax.swing.JTextField();
        txtsdt = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirt = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLichSuMuaHang = new javax.swing.JTable();

        setClosable(true);
        setTitle("Quản lý khách hàng");

        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên", "Địa Chỉ", "Số Điện Thoại", "Mã Nhân Viên", "Điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhachHangMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTimTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(94, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        tabs.addTab("Danh sách", jPanel2);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Tên khách hàng");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Địa chỉ");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Số điện thoại");

        txtTenKH.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtDiaChi.setColumns(20);
        txtDiaChi.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txtDiaChi.setRows(5);
        jScrollPane4.setViewportView(txtDiaChi);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Điểm");

        txtDiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtsdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnFirt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnFirt.setText("|<");
        btnFirt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirtActionPerformed(evt);
            }
        });

        btnPrev.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addComponent(btnFirt, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnFirt)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(btnLast))
                .addContainerGap())
        );

        tblLichSuMuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblLichSuMuaHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel27)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel23)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        tabs.addTab("Cập Nhật", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFirtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirtActionPerformed
        // TODO add your handling code here:
        firt();
    }//GEN-LAST:event_btnFirtActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
      //  delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnMoiActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void tblKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            soMaKH = Integer.parseInt(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0) + "");
            tabs.setSelectedIndex(1);
            KhachHang kh = new KhachHang();
            kh.setDiaChi(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 2) + "");
            kh.setDiem(Float.parseFloat(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 5) + ""));
            kh.setHoTen(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 1) + "");
            kh.setMaKH((tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 0) + ""));
            //kh.setManv(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 4) + "");
            kh.setSdt(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 3) + "");
            setForm(kh);
            System.out.println(soMaKH);
            fillLichSuMuaHang(soMaKH);
            updateStatus();
        }

    }//GEN-LAST:event_tblKhachHangMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        find();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirt;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblLichSuMuaHang;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimTenKH;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
