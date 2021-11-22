/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package landCoffee_DAO;

import landCoffee_Entity.HoaDonChiTiet;
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
public class HoaDonChiTiet_DAO extends LandCoffee_DAO<HoaDonChiTiet, String> {

    String insert_Sql = "INSERT INTO HOADONCHITIET(MASP,MAHD,TONGTIEN,SOLUONG,NGAYTAO) VALUES(?,?,?,?,?)";
    String update_Sql = "UPDATE HOADONCHITIET SET MAHD = ?, TONGTIEN = ?,SOLUONG = ?,NGAYTAO= ? WHERE MASP = ?";
    String delete_Sql = "DELETE FROM HOADONCHITIET WHERE MASP = ?";
    String selectAll_Sql = "SELECT * FROM HOADONCHITIET";
    String selectBy_Sql = "SELECT * FROM HOADONCHITIET WHERE MASP = ?";

    @Override
    public void insert(HoaDonChiTiet entity) {
        try {
            JdbcHelper.executeUpdate(insert_Sql, entity.getMaSP(), entity.getMaHD(), entity.getTongTien(), entity.getSoLuong(), entity.getNgayTao());
        } catch (Exception e) {
            Logger.getLogger(HoaDonChiTiet_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        try {
            JdbcHelper.executeUpdate(update_Sql, entity.getMaHD(), entity.getTongTien(), entity.getSoLuong(), entity.getNgayTao(), entity.getMaSP());
        } catch (Exception e) {
            Logger.getLogger(HoaDonChiTiet_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.executeUpdate(delete_Sql, id);
        } catch (Exception e) {
            Logger.getLogger(HoaDonChiTiet_DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return this.selectBySql(selectAll_Sql);
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        List<HoaDonChiTiet> list = this.selectBySql(selectBy_Sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                HoaDonChiTiet entity = new HoaDonChiTiet();
                entity.setMaSP(rs.getString("MASP"));
                entity.setMaHD(rs.getString("MAHD"));
                entity.setTongTien(rs.getFloat("TONGTIEN"));
                entity.setSoLuong(rs.getInt("SOLUONG"));
                entity.setNgayTao(rs.getDate("NGAYTAO"));
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
