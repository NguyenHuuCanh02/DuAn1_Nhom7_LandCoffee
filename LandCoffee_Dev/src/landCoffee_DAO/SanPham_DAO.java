/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_DAO;

import landCoffee_Entity.SanPham;
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
public class SanPham_DAO extends LandCoffee_DAO<SanPham, String> {

    String insert_Sql = "INSERT INTO SANPHAM(MASP,TENSP,GIA,HINHANH,MANV) VALUES(?,?,?,?,?)";
    String update_Sql = "UPDATE SANPHAM SET TENSP = ?, GIA = ?,HINHANH = ?,MANV = ? WHERE MASP = ?";
    String delete_Sql = "DELETE FROM SANPHAM WHERE MASP = ?";
    String selectAll_Sql = "SELECT * FROM SANPHAM";
    String selectById_Sql = "SELECT * FROM SANPHAM WHERE MASP = ?";

    @Override
    public void insert(SanPham entity) {
        try {
            JdbcHelper.executeUpdate(insert_Sql, entity.getMaSP(), entity.getTenSP(), entity.getGia(), entity.getHinh(), entity.getMaNV());
        } catch (Exception e) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(SanPham entity) {
        try {
            JdbcHelper.executeUpdate(update_Sql, entity.getTenSP(), entity.getGia(), entity.getHinh(), entity.getMaNV(), entity.getMaSP());
        } catch (Exception e) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete_Sql, id);
        } catch (Exception e) {
            Logger.getLogger(SanPham_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<SanPham> selectAll() {
        return (List<SanPham>) this.selectBySql(selectAll_Sql);
    }

    @Override
    public SanPham selectById(String id) {
        List<SanPham> list = (List<SanPham>) this.selectBySql(selectById_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                SanPham entity = new SanPham();
                entity.setMaSP(rs.getString("MASP"));
                entity.setTenSP(rs.getString("TENSP"));
                entity.setGia(rs.getFloat("GIA"));
                entity.setHinh(rs.getString("HINHANH"));
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
