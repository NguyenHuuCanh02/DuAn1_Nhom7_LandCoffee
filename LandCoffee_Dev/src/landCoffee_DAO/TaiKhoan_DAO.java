/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_DAO;

import helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import landCoffee_Entity.taiKhoan;

/**
 *
 * @author nguye
 */
public class TaiKhoan_DAO extends LandCoffee_DAO<taiKhoan, String> {

    String insert_Sql = "INSERT INTO TAIKHOAN(IDNV,MATKHAU,VAITRO,MANV) VALUES(?,?,?,?)";
    String update_Sql = "UPDATE TAIKHOAN SET MATKHAU = ? WHERE IDNV = ?";
    String delete_Sql = "DELETE FROM TAIKHOAN WHERE IDNV = ?";
    String selectAll_Sql = "SELECT * FROM TAIKHOAN";
    String selectById_Sql = "SELECT * FROM TAIKHOAN WHERE IDNV = ?";

    @Override
    public void insert(taiKhoan entity) {
        try {
            JdbcHelper.executeUpdate(insert_Sql, entity.getTaiKhoan(), entity.getMatKhau(), entity.isVaiTro(), entity.getMaNV());
        } catch (Exception e) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(taiKhoan entity) {
        try {
            JdbcHelper.executeUpdate(update_Sql, entity.getMatKhau(), entity.getTaiKhoan());
        } catch (Exception e) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete_Sql, id);
        } catch (Exception e) {
            Logger.getLogger(NhanVien_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<taiKhoan> selectAll() {
        return this.selectBySql(selectAll_Sql);
    }

    @Override
    public taiKhoan selectById(String id) {
        List<taiKhoan> list = (List<taiKhoan>) this.selectBySql(selectById_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<taiKhoan> selectBySql(String sql, Object... args) {
        List<taiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                taiKhoan entity = new taiKhoan();
                entity.setTaiKhoan(rs.getString("IDNV"));
                entity.setMatKhau(rs.getString("MATKHAU"));
                entity.setVaiTro(rs.getBoolean("VAITRO"));
                entity.setMaNV(rs.getString("MANV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
