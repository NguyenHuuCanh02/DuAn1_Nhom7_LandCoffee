/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_GUI;

import helper.Auth;
import helper.JDialogHelper;
import landCoffee_DAO.TaiKhoan_DAO;

/**
 *
 * @author nguye
 */
public class doiMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form doiMatKhau
     */
    public doiMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel2 = new javax.swing.JLabel();
        txtMatKhauHienTai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtMatKhauMoi = new javax.swing.JTextField();
        btnHuy = new javax.swing.JButton();
        btnDoiMatKhau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.jpg"))); // NOI18N

        jLabel2.setText("Mật khẩu hiện tại");

        jLabel3.setText("Mật khẩu mới");

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy)
                        .addGap(18, 18, 18)
                        .addComponent(btnDoiMatKhau))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(txtMatKhauHienTai)
                        .addComponent(jLabel3)
                        .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatKhauHienTai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHuy)
                            .addComponent(btnDoiMatKhau)))
                    .addComponent(jLabel1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        // TODO add your handling code here:
        doiMatKhau();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed

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
            java.util.logging.Logger.getLogger(doiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doiMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doiMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtMatKhauHienTai;
    private javax.swing.JTextField txtMatKhauMoi;
    // End of variables declaration//GEN-END:variables
    TaiKhoan_DAO dao = new TaiKhoan_DAO();
    void doiMatKhau() {
        if (!Auth.isLogin()) {
            JDialogHelper.alert(this, "Bạn cần đăng nhập để sử dụng chức năng");
        } else {
            String mkht = txtMatKhauHienTai.getText();
            String mkm = txtMatKhauMoi.getText();
            if(txtMatKhauHienTai.getText().equals("")){
                JDialogHelper.alert(this, "Bạn phải nhập mật khẩu hiện tại");
                txtMatKhauHienTai.requestFocus();
            }
            if(txtMatKhauMoi.getText().equals("")){
                JDialogHelper.alert(this, "Bạn phải nhập mật khẩu mới");
                txtMatKhauMoi.requestFocus();
            }
            if (!mkht.equalsIgnoreCase(Auth.user.getMatKhau())) {
                JDialogHelper.alert(this, "Mật khẩu hiện tại không đúng");
                txtMatKhauHienTai.setText("");
                txtMatKhauHienTai.requestFocus();
            } else {
                Auth.user.setMatKhau(mkm);
                dao.update(Auth.user);
                JDialogHelper.alert(this, "Đổi mật khẩu thành công");
                this.dispose();
            }
        }
    }
}
