/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_DAO;

import landCoffee_Entity.KhachHang;
import helper.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyễn Tiến Dũng
 */
public class KhachHang_DAO extends LandCoffee_DAO<KhachHang, String> {

    String insert_Sql = "INSERT INTO KHACHHANG(TENKH,DIACHI,SDT,DIEM,MANV) VALUES(?,?,?,?,?)";
    String update_Sql = "UPDATE KHACHHANG SET TENKH = ?, DIACHI = ?, SDT = ?, DIEM = ?, MANV = ? WHERE MAKH = ?";
    String delete_Sql = "DELETE FROM KHACHHANG WHERE MAKH = ?";
    String selectAll_Sql = "SELECT * FROM KHACHHANG";
    String selectById_Sql = "SELECT * FROM KHACHHANG WHERE MAKH = ?";

    @Override
    public void insert(KhachHang entity) {
        try {
            JdbcHelper.executeUpdate(insert_Sql, entity.getHoTen(), entity.getDiaChi(), entity.getSdt(), entity.getDiem(), entity.getManv());
        } catch (Exception e) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(KhachHang entity) {
        try {
            JdbcHelper.executeUpdate(update_Sql, entity.getHoTen(), entity.getDiaChi(), entity.getSdt(), entity.getDiem(), entity.getManv(),entity.getMaKH());
        } catch (Exception e) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void updateDiem(KhachHang entity) {
        try {
            String sql = "update KHACHHANG set diem = ? where makh = ?";
            JdbcHelper.executeUpdate(sql, entity.getDiem(),entity.getMaKH());
        } catch (Exception e) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete_Sql, id);
        } catch (Exception e) {
            Logger.getLogger(KhachHang_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<KhachHang> selectAll() {
        return (List<KhachHang>) this.selectBySql(selectAll_Sql);
    }

    @Override
    public KhachHang selectById(String id) {
        List<KhachHang> list =  this.selectBySql(selectById_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                KhachHang entity = new KhachHang();
                entity.setMaKH(rs.getString("MAKH"));
                entity.setHoTen(rs.getString("TENKH"));
                entity.setDiaChi(rs.getString("DIACHI"));
                entity.setSdt(rs.getString("SDT"));
                entity.setDiem(rs.getFloat("DIEM"));
                entity.setManv(rs.getString("MANV"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
        public List<KhachHang> selectByKeyword(String keyWord) {
        String sql = "SELECT * FROM KHACHHANG WHERE TENKH LIKE ?";
        return this.selectBySql(sql, "%" + keyWord + "%");
    }

}
