package helper;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import landCoffee_DAO.NhanVien_DAO;
import landCoffee_DAO.TaiKhoan_DAO;
import landCoffee_Entity.NhanVien;
import landCoffee_Entity.taiKhoan;

public class XValidated {

    public static boolean checkMaNV(JTextField tf, String mss) {
        NhanVien_DAO dao = new NhanVien_DAO();
        NhanVien nv = dao.selectById(tf.getText());
        if (nv != null) {
            JDialogHelper.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkTaiKhoan(JTextField tf, String mss) {
        TaiKhoan_DAO dao = new TaiKhoan_DAO();
        taiKhoan tk = dao.selectById(tf.getText());
        if (tk != null) {
            JDialogHelper.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSDT(JTextField tf, String mss) {
        String soDt = "^[0-9]{10}$";
        if (tf.getText().matches(soDt) == false) {
            JDialogHelper.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkRong(JTextField tf, String mss) {
        if (tf.getText().isEmpty()) {
            JDialogHelper.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean checkSoNguyen(JTextField tf, String mss) {
        try {
            float so = Float.parseFloat(tf.getText());
        } catch (Exception e) {
            JDialogHelper.alert(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }

}
